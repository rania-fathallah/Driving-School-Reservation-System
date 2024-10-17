package controlers;

import codecs.SessionCodec;
import com.mongodb.client.MongoCursor;
import dao.Engineerdao;
import dao.Sessiondao;
import dao.Vehicledao;
import entities.*;
import input.EngineerInput;
import input.SessionInput;
import input.StudentInput;
import input.VehicleInput;
import org.bson.Document;

import java.util.Vector;

public class SessionControler {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void addSession() {
        Student student;
        Appointment appointment;
        Vehicle vehicle = null;
        Engineer engineer = null;
        int x = 0;
        do {
            student = StudentControler.getStudent();
            if (student == null) {
                x = SessionInput.test();
            } else {
                int poucentage;
                if (SessionInput.type() == 0) {
                    System.out.println(ANSI_YELLOW + "ADDING A DRIVING LESSON FOR STUDENT WITH CIN NUMBER " + student.getNumCin() + ANSI_RESET);
                    if (Character.compare('A', student.getPermis()) == 0) {
                        poucentage = 4;
                    } else {
                        if (Character.compare('B', student.getPermis()) == 0) {
                            poucentage = 6;
                        } else {
                            poucentage = 8;
                        }
                    }
                    do {
                        appointment = AppointmentControler.createAppointment();
                        if (appointment == null) {
                            x = SessionInput.test1();
                        } else {
                            MongoCursor<Document> cursor = Sessiondao.findDrivingSessions(appointment);
                            Vector<DrivingSession> v = new Vector<>();
                            if (cursor != null) {
                                while (cursor.hasNext()) {
                                    v.add(SessionCodec.convertD(cursor.next()));
                                }
                            }
                            cursor = Sessiondao.findSessions(appointment);
                            Vector<Session> v1 = new Vector<>();

                            if (cursor != null) {
                                while (cursor.hasNext()) {
                                    v1.add(SessionCodec.convert(cursor.next()));
                                }
                            }
                            engineer = chooseEngineerFromExisting(v1, student);
                            vehicle = chooseVehicleFromExisting(v, student.getPermis());
                            if (engineer == null || vehicle == null) {
                                x = SessionInput.test2();
                            }
                        }
                    } while ((appointment == null || engineer == null || vehicle == null) && x == 0);
                    if (!(appointment == null || engineer == null || vehicle == null)) {
                        Sessiondao.insertSession(new DrivingSession(appointment, vehicle, engineer, student));
                        long time = (long) (((double) (appointment.getEndl() - appointment.getStartl())) / 3600000);
                        StudentControler.updateStudenttotal(student.getNumCin(), (15 + (15 * 0.1 * poucentage)) * time);
                        EngineerControler.updateEngineerSalary(engineer.get_id(), 10 * time);
                    }
                } else {
                    System.out.println(ANSI_YELLOW + "ADDING A CODE LESSON FOR STUDENT WITH CIN NUMBER " + student.getNumCin() + ANSI_RESET);
                    if (Character.compare('A', student.getPermis()) == 0) {
                        poucentage = 2;
                    } else {
                        if (Character.compare('B', student.getPermis()) == 0) {
                            poucentage = 3;
                        } else {
                            poucentage = 5;
                        }
                    }
                    do {
                        appointment = AppointmentControler.createAppointment();
                        if (appointment == null) {
                            x = SessionInput.test();
                        } else {
                            MongoCursor<Document> cursor = Sessiondao.findSessions(appointment);
                            Vector<Session> v = new Vector<>();
                            while (cursor.hasNext()) {
                                v.add(SessionCodec.convert(cursor.next()));
                            }
                            engineer = chooseEngineerFromExisting(v, student);
                            if (engineer == null) {
                                x = 1;
                            }
                        }
                    } while (appointment == null && x == 0);


                    Sessiondao.insertSession(new CodeSession(appointment, engineer, student));
                    long time = (long) (((double) (appointment.getEndl() - appointment.getStartl())) / 3600000);
                    StudentControler.updateStudenttotal(student.getNumCin(), (15 + (15 * 0.1 * poucentage)) * time);
                    EngineerControler.updateEngineerSalary(engineer.get_id(), 7 * time);
                }
            }
        } while (student == null && x == 0);
    }

    public static Engineer chooseEngineerFromExisting(Vector<Session> v, Student student) {
        if (v.size() == 0) {
            Vector<Engineer> list = Engineerdao.getEngineers();
            System.out.println(ANSI_CYAN + "Choose one of these available engineers :(a number)" + ANSI_YELLOW);
            EngineerInput.printEngineers(list);
            System.out.print(ANSI_RED + "->" + ANSI_RESET);
            int choice = SessionInput.aNumber();
            return (list.get(choice));
        } else {
            Vector<Long> e = new Vector<>();
            for (int i = 0; i < v.size(); i++) {
                e.add(v.get(i).getEngineer().get_id());
            }
            if (e.size() == Engineerdao.nombreIngenieur()) {
                return (null);
            } else {
                Vector<Engineer> list = new Vector<>();
                Vector<Engineer> listT = Engineerdao.getEngineers();
                int k;
                for (int j = 0; j < listT.size(); j++) {
                    k = 0;
                    if (v.get(j).getStudent().getNumCin() == student.getNumCin()) {
                        System.out.println(ANSI_RED + "The student already have a lesson at that time " + ANSI_RESET);
                        break;
                    }
                    for (int i = 0; i < e.size(); i++) {
                        if (listT.get(j).get_id() == e.get(i)) {
                            k = 1;
                            break;
                        }
                    }
                    if (k == 0) {
                        list.add(listT.get(j));
                    }
                }
                if (list.size() == 0) {
                    return null;
                }
                System.out.println(ANSI_CYAN + "Choose one of these available engineers :(a number)" + ANSI_YELLOW);
                EngineerInput.printEngineers(list);
                System.out.print(ANSI_RED + "->" + ANSI_RESET);
                int choice = SessionInput.aNumber();
                return (list.get(choice));

            }

        }
    }

    public static Vehicle chooseVehicleFromExisting(Vector<DrivingSession> v, char permisType) {
        Vector<Long> e = new Vector<>();
        for (int i = 0; i < v.size(); i++) {
            e.add(v.get(i).getVehicle().get_id());
        }
        if (e.size() == Vehicledao.nombreDeVehicule()) {
            return (null);
        } else {
            Vector<Vehicle> list = new Vector<>();
            Vector<Vehicle> listT;
            if (Character.compare('B', permisType) == 0) {
                listT = Vehicledao.getVehicles("Car");
                int k;
                for (int j = 0; j < listT.size(); j++) {
                    k = 0;
                    for (int i = 0; i < v.size(); i++) {
                        if (listT.get(j).get_id() == e.get(i)) {
                            k = 1;
                            break;
                        }
                    }
                    if (k == 0) {
                        list.add(listT.get(j));
                    }
                }
            } else {
                if (Character.compare('C', permisType) == 0) {
                    listT = Vehicledao.getVehicles("Truck");
                    int k;
                    for (int j = 0; j < listT.size(); j++) {
                        k = 0;
                        for (int i = 0; i < v.size(); i++) {
                            if (listT.get(j).get_id() == e.get(i)) {
                                k = 1;
                                break;
                            }
                        }
                        if (k == 0) {
                            list.add(listT.get(j));
                        }
                    }
                } else {
                    listT = Vehicledao.getVehicles("Motorcycle");
                    int k;
                    for (int j = 0; j < listT.size(); j++) {
                        k = 0;
                        for (int i = 0; i < v.size(); i++) {
                            if (listT.get(j).get_id() == e.get(i)) {
                                k = 1;
                                break;
                            }
                        }
                        if (k == 0) {
                            list.add(listT.get(j));
                        }
                    }
                }
            }

            System.out.println(ANSI_CYAN + "Choose one of these available vehicles :(a number)" + ANSI_YELLOW);
            VehicleInput.printVehicules(list);
            System.out.println(ANSI_RED + "->" + ANSI_RESET);
            int choice = SessionInput.aNumber();
            return (list.get(choice));
        }
    }

    public static void printSessions() {
        Vector<Session> v = Sessiondao.getSessions(StudentInput.insertCin());
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }


}
