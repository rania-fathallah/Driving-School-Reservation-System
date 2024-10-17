package controlers;

import dao.Vehicledao;
import entities.*;
import input.VehicleInput;

import java.util.Vector;

public class VehicleControler {


    //SEARCHING FOR A VEHICLE IN THE DATABASE AND RETURNING IT AS A INSTANCE OF CLASS VEHICLE//
    public static Vehicle getVehicle() {
        Vehicle v = Vehicledao.searchVehicle(VehicleInput.insertnumImmatriculation());
        return (v);
    }


    //ADDING A VEHICLE  TO THE DATABASE//
    public static void addVehicle() {
        String type = VehicleInput.insertType();
        if (type.equalsIgnoreCase("car")) {
            Vehicledao.insertVehicle(new Car(VehicleInput.insertnumImmatriculation(), VehicleInput.insertDateMiseInService()));
        } else {
            if (type.equalsIgnoreCase("motorcycle")) {
                Vehicledao.insertVehicle(new Motorcycle(VehicleInput.insertnumImmatriculation(), VehicleInput.insertDateMiseInService()));
            } else {
                if (type.equalsIgnoreCase("truck")) {
                    Vehicledao.insertVehicle(new Truck(VehicleInput.insertnumImmatriculation(), VehicleInput.insertDateMiseInService()));
                } else {
                    System.out.println("Type not valid !");
                }
            }
        }
    }

    //DELETE A VEHICLE FROM THE DATABASE BY INPUTTING THE IMMATRICULATION NUMBER OF THE VEHICLE YOUR WANT TO DELETE//
    public static void removeVehicle() {
        Vehicledao.deleteVehicule(VehicleInput.insertnumImmatriculation());
    }


    public static void printVehicles() {
        Vector<Vehicle> v = Vehicledao.getVehicles();
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }


}
