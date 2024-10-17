package controlers;

import dao.Examdao;
import entities.*;
import input.ExamInput;
import input.SessionInput;
import input.StudentInput;
import mainApplication.Start;

public class ExamControler {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void addExam() {
        Student student;
        Appointment appointment;
        int x = 0;
        do {
            student = StudentControler.getStudent();
            if (student == null) {
                x = ExamInput.test();
            } else {
                if (student.getCodeTestResult() == Boolean.FALSE) {
                    System.out.println(ANSI_YELLOW + "ADDING A CODE EXAM FOR STUDENT WITH CIN NUMBER " + student.getNumCin() + ANSI_RESET);

                    do {
                        appointment = AppointmentControler.createAppointment();
                        if (appointment == null) {
                            x = ExamInput.test1();
                        } else {
                            if (Examdao.searchExam(student.getNumCin()) == null) {
                                ExamInput.test2();
                                Start.start();
                            }
                        }
                    } while ((appointment == null) && x == 0);
                    if (!(appointment == null)) {
                        Examdao.insertExam(new Exam(appointment, student, "code"));
                        StudentControler.updateStudenttotal(student.getNumCin(), 50.0);
                    }
                } else {
                    System.out.println(ANSI_YELLOW + "ADDING A DRIVING EXAMA CODE LESSON FOR STUDENT WITH CIN NUMBER " + student.getNumCin() + ANSI_RESET);
                    do {
                        appointment = AppointmentControler.createAppointment();
                        if (appointment == null) {
                            x = SessionInput.test();
                        } else {
                            if (Examdao.searchExam(student.getNumCin()) == null) {
                                ExamInput.test2();
                                Start.start();

                            }
                        }
                    } while (appointment == null && x == 0);
                    Examdao.insertExam(new Exam(appointment, student, "driving"));
                    StudentControler.updateStudenttotal(student.getNumCin(), 50.0);
                }
            }
        } while (student == null && x == 0);
    }

    public static Exam getExam() {
        Exam e = Examdao.searchExam(StudentInput.insertCin());
        return (e);
    }
}
