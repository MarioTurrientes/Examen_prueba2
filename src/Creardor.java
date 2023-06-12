import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mturr
 */
public class Creardor {
    
    // Creamos una lista de autoras:
    private static ArrayList <Autora> listaAutora = new ArrayList();
    
    
    //Constructor:
    public Creardor() {
    }
    
    //------------------------------------------------------------------------------------------------------------
    
    
    // rellenar lista Autoras mencionada en la clase base_datos:
    public void rellenar_lista(Autora autora){
        listaAutora.add(autora);
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    
    
    // Mostrar todo los datos de la lista:
    public void muestra_lista(){
        
        for(int i=0;i<listaAutora.size();i++) {
            System.out.println(listaAutora.get(i).toString()); //Llamamos al metodo toString de la clase Autora para saber los datos de cada posicion de arrayList:
        } 
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    
    
    public static Autora buscarAutoraPorId(int idAutora) {
        // Recorre la lista de autoras y busca la autora con el ID especificado
        for (Autora autora : listaAutora) {
            if (autora.getId() == idAutora) {
                return autora;
            }
        }
        return null; // Si no se encuentra la autora, retorna null
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    
    
    // Metodo para dar la autora con mas premios:
    public Autora buscarAutoraConMayorPremio() {
        Autora autoraMaxima = null;
        int maximo = 0;

        for (Autora autora : listaAutora) {
            int premios = autora.getPremios();
            if (premios > maximo) {
                maximo = premios;
                autoraMaxima = autora;
            }
        }

        return autoraMaxima;
    }
     
    
    //------------------------------------------------------------------------------------------------------------
    
    
    // Metodo para mostrar el numero de autoras de cada campo de trabajo:
    public void numeroAutorasPorCampoTrabajo() {
        
        // Creamos un mapa que almacena el campo y su recuento:
        Map<String, Integer> countByCampoTrabajo = new HashMap<>();
        
        for (Autora autora : listaAutora) {
            String campoTrabajo = autora.getAreaTrabajo();  //obtenemos el campo de la autora actual y se guarda en el string campoTrabajo
            
            // Si el campo de trabajo ya está presente en el mapa, se incrementa
            // Si no está presente, se agrega al mapa con un recuento inicial de 1.
            countByCampoTrabajo.put(campoTrabajo, countByCampoTrabajo.getOrDefault(campoTrabajo, 0) + 1);   //Obtiene el recuento actual del campo de trabajo. Si no existe, devuelve 0, si no suma 1.
        }
        
        for (Map.Entry<String, Integer> entry : countByCampoTrabajo.entrySet()) {
            
            // Se obtiene el campo de trabajo de la entrada actual.
            String campoTrabajo = entry.getKey();
            
            // Se obtiene el recuento de autoras del campo de trabajo actual.
            int count = entry.getValue();
            System.out.println("Campo de trabajo: " + campoTrabajo + ", Número de autoras: " + count);
        }
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    
    
    public void guardarAutorasEnCSV(String nombreArchivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));  //si el archivo no existe se creará uno nuevo con dicho nombre.

        for (Autora autora : listaAutora) {
            String linea = autora.toString(); // Utilizar el método toString() de la clase autora que ya esta con comas.
            
            writer.write(linea);    //Se escribe la cadena linea en el archivo CSV utilizando el objeto writer
            writer.newLine();   //Se agrega una nueva línea al archivo CSV después de escribir cada autora
        }

        writer.close(); //se cierra el objeto, asegura que todos los datos se guarden correctamente en el archivo 
    }
    
    
    //-------------------------------------------- Añadido ----------------------------------------------------------------
    
    
    public Autora BuscarAutoraPorNA(String nombre, String apellido) {
        for (Autora autora : listaAutora) {
            if (autora.getNombre().equalsIgnoreCase(nombre) && autora.getApellidos().equalsIgnoreCase(apellido)) {
                return autora;
            }
        }
        return null; // Si no se encuentra la autora, se retorna null
    }
    
}













// Metodo para encontrar la autora:
    //public static Autora buscarAutoraPorId(int idAutora) {
        // Recorre la lista de autoras y busca la autora con el ID especificado
        //for (Autora autora : listaAutora) {
            //if (autora.getId() == idAutora) {
                //return autora;
            //}
        //}
        //return null; // Si no se encuentra la autora, retorna null
    //}


// Otra forma por si no tenemos el ToString con comas de la clase autora:
//public void guardarAutorasEnCSV(String nombreArchivo) throws IOException {
        //BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

        //for (Autora autora : listaAutoras) {
            //String linea = autora.getNombre() + "," + autora.getApellido() + "," + autora.getPais() + "," + autora.getEdad();
            //writer.write(linea);
            //writer.newLine();
        //}

        //writer.close();
    //}