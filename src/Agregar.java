import java.util.Scanner;
import java.util.HashMap;
public class Agregar {
    // recibe el Scanner del main y devuelve el Paciente creado
    public Paciente agregar(Scanner sc, HashMap<String, Paciente>registrado ) {
        // ingreso y recopilacion de datos
        System.out.print("Cedula del Paciente: ");
        String cedula = sc.nextLine();
        if (registrado.containsKey(cedula)){
            System.out.println("El paciente ya esta registrado");
            return null;
        }
        
        System.out.print("Nombre del Paciente: ");
        String nombre = sc.nextLine();

        System.out.print("Edad del Paciente: ");
        String edad = sc.nextLine();

        Paciente p = new Paciente(nombre, cedula, edad);
        registrado.put(cedula, p);

        System.out.println("Paciente " + p.nombre + " registrado");
        return p;
    }
}
