import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author mturr
 */
public class Principal {
    
    private static Creardor c1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //O. Compartir un objeto entre clases que es para la lista:
        c1 = new Creardor(); // Inicializar el objeto Creardor
        
        
        //1.1 Llamamos al menu principal y luego la respuesta la guardamos en opcion:
        int opcion = menuPrincipal();
        
        switch (opcion) {
            case 1:
                System.out.println("Ha elegido hacer conexión con la base de datos");
                Base_Datos bd = new Base_Datos(c1); //O. Pasamos el objeto lista por argumento.
                
                try {
                    Connection connection = bd.getConnection();
                    
                    // Realizar operaciones con la base de datos
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                }
                break;
                
            case 2:
                System.out.println("Ha elegido leer un fichero");
                break;
                
            case 0:
                System.out.println("Saliendo del programa...");
                break;
                
            default:
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                break;
        }
        
        
        //----------------------------------------------FIN 1 MENU--------------------------------------------------------------

        
        //Variables:
        int opcion2;
        
        do{
            
            //2. Llmamos al segundo menu para ver que quiere hacer el usuario:
            opcion2 = menu();
            
            switch (opcion2) {
                case 1:
                   Scanner sc = new Scanner(System.in);
                    
                    System.out.print("Ingrese el id de la autora: ");
                    int idAutora = sc.nextInt();

                    // Buscar la autora en la lista
                    Autora autoraEncontrada = c1.buscarAutoraPorId(idAutora);

                    if (autoraEncontrada != null) {
                        System.out.println("Autora encontrada:\n" + autoraEncontrada);
                    } else {
                        System.out.println("No se encontró la autora.");
                    }
                    
                    break;

                case 2:
                    // creamos un objeto autoraMaxima, y con esa lista llamamos a buscar mayor:
                    Autora autoraMaxima = c1.buscarAutoraConMayorPremio();
                    
                    if (autoraMaxima != null) {
                        System.out.println("La autora con el mayor número de premios recibidos es: "+ autoraMaxima);
                        
                    } else {
                        System.out.println("No se encontraron autoras en la lista.");
                    }
                    
                    break;
                    
                case 3:
                    // Creamos el objeto autora vacio para introducir datos por teclado:
                    Autora autora1 = new Autora();
                    
                    // Llamamos al metodo de crear nueva autora de la clase autora:
                    autora1.crear_autora();
                    
                    // Añadimos en la listaAutoras la autora del objeto autora1:
                    c1.rellenar_lista(autora1);
                    
                    break;
                    
                case 4:
                    c1.numeroAutorasPorCampoTrabajo();
                    
                    break;
                    
                case 5:
                    Scanner sc1 = new Scanner(System.in);
                    
                    System.out.println("Ingrese el nombre de la autora:");
                    String nombre = sc1.nextLine();
                    System.out.println("Ingrese el apellido de la autora:");
                    String apellido = sc1.nextLine();
                    
                    Autora persona = c1.BuscarAutoraPorNA(nombre, apellido);
                    if (persona != null) {
                        System.out.println("Autora encontrada: " + persona);
                    } else {
                        System.out.println("No se encontró la autora.");
                    }
                    
                    break;

                case 0:
                    // Imprimimos la lista con los cambios:
                    c1.muestra_lista();
                    
                    // Llamar al método para guardar la lista en un archivo CSV
                    Scanner sc2 = new Scanner(System.in);
                    
                    try {
                        System.out.println("Ingrese el nombre del archivo CSV: ");
                        String nombreArchivo = sc2.nextLine();
                        c1.guardarAutorasEnCSV(nombreArchivo);
                        System.out.println("El archivo CSV se ha creado correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo CSV: " + e.getMessage());
                    }
                    
                    // Mensaje despedida:
                    System.out.println("Saliendo del programa...");
                    break;
                    

                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    
                    break;
            }
        }while (opcion2 != 0);
        
    }   
    
    
    //-------------------------------------------------- FIN PROGRAMA ----------------------------------------------------------
    
    
    //1. Menu principal para leer basedatos o fichero:
    public static int menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("----- MENÚ PRINCIPAL -----");
        System.out.println("1. Realizar conexión a base de datos");
        System.out.println("2. Realizar operaciones con un fichero CSV");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
        opcion = scanner.nextInt();

        return opcion;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    //2. Funcion para llamar al menu:
    public static int menu() {
        
        Scanner scanner = new Scanner(System.in);

        //Menu del programa:
        
            System.out.println("=== MENÚ ===");
            System.out.println("0. Salir");
            System.out.println("1. Mostrar autora");
            System.out.println("2. Mostrar autora con mas premios");
            System.out.println("3. Añadir autora");
            System.out.println("4. Mostrar numero de autoras por campo de trabajo");
            System.out.print("Elija una opción: ");
            
            // respuesta del usuario:
            int opcion = scanner.nextInt();
            
        return opcion;
    }
    
    
}
