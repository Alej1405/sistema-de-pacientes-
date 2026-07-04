// importando las librerias necesarias
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agregar agregar = new Agregar();

        // cola de turnos (FIFO): el primero en llegar es el primero en atenderse
        Queue<Paciente> turnos = new LinkedList<>();

        //lista para recordar y validar pila
        HashMap<String, Paciente >registrado = new HashMap<>();

        int opcion = 0;

        // menu con while: se repite hasta elegir salir (opcion 4)
        while (opcion != 4) {
            System.out.println("\n=== Sistema de Turnos de Pacientes ===");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Atender siguiente");
            System.out.println("3. Ver pacientes en espera");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpia el salto de linea que deja nextInt

            switch (opcion) {
                case 1:
                    // registra el paciente y lo encola al final
                    Paciente nuevo = agregar.agregar(sc, registrado);
                    if (nuevo != null){
                        turnos.offer(nuevo);
                    }
                    break;
                case 2:
                    // saca al primero de la cola (FIFO)
                    Paciente atendido = turnos.poll();
                    if (atendido == null) {
                        System.out.println("No hay pacientes en espera.");
                    } else {
                        System.out.println("Atendiendo a: " + atendido.nombre
                                + " |cedula: " + atendido.cedula);
                    }
                    break;
                case 3:
                    System.out.println("Pacientes en espera: " + turnos.size());
                    for (Paciente p : turnos) {
                        System.out.println("Nombre:  " + p.nombre +" | Cedula: "+ p.cedula +" | Edad: " + p.edad);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo.");
            }
        }

        sc.close();
    }
}

// clase que se encarga de registrar un paciente
// class Agregar {

//     // recibe el Scanner del main y devuelve el Paciente creado
//     public Paciente agregar(Scanner sc) {
//         // ingreso y recopilacion de datos
//         System.out.print("Nombre del Paciente: ");
//         String nombre = sc.nextLine();

//         System.out.print("Cedula del Paciente: ");
//         String cedula = sc.nextLine();

//         System.out.print("Edad del Paciente: ");
//         String edad = sc.nextLine();

//         Paciente p = new Paciente(nombre, cedula, edad);

//         System.out.println("Paciente " + p.nombre + " registrado");
//         return p;
//     }
// }
