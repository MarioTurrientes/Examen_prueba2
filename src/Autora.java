import java.util.Scanner;

/**
 *
 * @author mturr
 */
public class Autora {
 
    //Atributos:
    private int id, premios;
    private String nombre, apellidos, alias, fecha, pais, areaTrabajo;

    
    //------------------------------------------------------------------------------------------------------------
    
    
    //Constructor:
    public Autora(int id, String nombre, String apellidos, String alias, String fecha, int premios, String pais, String areaTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alias = alias;
        this.fecha = fecha;
        this.premios = premios;
        this.pais = pais;
        this.areaTrabajo = areaTrabajo;
    }

    
    //------------------------------------------------------------------------------------------------------------
    
    
    //Constructor vacio:
    public Autora() {
        
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    
    
    // Sobrescribir el método toString() para una representación personalizada de Autora:
    @Override
    public String toString() {
        return id + "," + nombre + "," + apellidos + "," + alias +
                "," + fecha + "," + premios + "," + pais +
                "," + areaTrabajo;
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    
    
    // Metodo para crear una autora:
    public void crear_autora(){
        //creamos el sacanner:
        Scanner leer = new Scanner(System.in);
        
        // datos que rellena el usuario de cada atributo:
        System.out.println("Escribe el nombre:");
        setNombre(nombre = leer.next());
        System.out.println("Escribe el apellido:");
        setApellidos(apellidos = leer.next());
        System.out.println("Escribe el alias:");
        setAlias(alias = leer.next());
        System.out.println("Escribe la fecha nacimiento:");
        setFecha(fecha = leer.next());
        System.out.println("Escribe numero premios:");
        setPremios(premios = leer.nextInt());
        System.out.println("Escribe el pais:");
        setPais(pais = leer.next());
        System.out.println("Escribe el area trabajo:");
        setAreaTrabajo(areaTrabajo = leer.next());
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    //Getters:

    public int getId() {
        return id;
    }

    public int getPremios() {
        return premios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getAlias() {
        return alias;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPais() {
        return pais;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }
    
    
    //------------------------------------------------------------------------------------------------------------
    // Setters:

    
    public void setId(int id) {
        this.id = id;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }
    
}
