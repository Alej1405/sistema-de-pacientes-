// importando las librerias necesarias
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sistema de Turnos de Pacientes");

        //inicio del ingreso de datos 
        Scanner sc = new Scanner(System.in);

        //ingrego y recopilacion de datos
        System.out.print("Nombre del Paciente: ");
        String nombre = sc.nextLine();

        System.out.print("Cedula del Paciente: ");
        String cedula = sc.nextLine();

        System.out.print("Edad del Paciente: ");
        String edad = sc.nextLine();

        Paciente p =  new Paciente(nombre, cedula, edad);

        System.out.println("Paciente " + p.nombre + " registrado");

        sc.close();
        
    }
}
