package input;
import entities.Engineer;

import java.util.Scanner;
import java.util.Vector;

public class EngineerInput {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static Scanner sc=new Scanner(System.in);

    public static String insertNom(){
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the first name of the engineer :"+ ANSI_RESET);
        return(sc.nextLine());
    }
    public static long insertCin(){
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the CIN number of the engineer :"+ ANSI_RESET);
        return(sc.nextLong());
    }
    public static String insertPrenom(){
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the last name of the engineer :"+ ANSI_RESET);
        return(sc.nextLine());
    }
    public static String whatToUpdate(){
        sc.nextLine();
        System.out.println(ANSI_GREEN + "What do you want to update :"+ ANSI_RESET);
        return(sc.nextLine());
    }

    public static double insertsalary(){
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write salary  :"+ ANSI_RESET);
        return(sc.nextDouble());
    }

    public static void printEngineers(Vector<Engineer> v){
        for(int j=0;j<v.size();j++){
            System.out.println(j +"_ The engineer "+v.get(j).getNom()+" "+v.get(j).getPrenom()+" .");
        }
    }

}
