import java.util.ArrayList;
import java.util.List;

class Empleado {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String DNI;

    public Empleado(String nombre, String apellidos, String direccion, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.DNI = DNI;
    }

    // Getters y setters
}

class Trabajador extends Empleado {
    private double sueldoFijo;
    private Trabajador jefe;

    public Trabajador(String nombre, String apellidos, String direccion, String DNI, double sueldoFijo) {
        super(nombre, apellidos, direccion, DNI);
        this.sueldoFijo = sueldoFijo;
    }

    public void setJefe(Trabajador jefe) {
        this.jefe = jefe;
    }

    public double calcularSueldo() {
        return sueldoFijo;
    }
}

class FijoMensual extends Trabajador {
    public FijoMensual(String nombre, String apellidos, String direccion, String DNI, double sueldoFijo) {
        super(nombre, apellidos, direccion, DNI, sueldoFijo);
    }
}

class Comisionista extends Trabajador {
    private double ventasRealizadas;
    private double porcentajeComision;

    public Comisionista(String nombre, String apellidos, String direccion, String DNI, double sueldoFijo,
                        double ventasRealizadas, double porcentajeComision) {
        super(nombre, apellidos, direccion, DNI, sueldoFijo);
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSueldo() {
        return sueldoFijo + (ventasRealizadas * porcentajeComision);
    }
}

class PorHoras extends Trabajador {
    private int horasRealizadas;
    private double precioHora;

    public PorHoras(String nombre, String apellidos, String direccion, String DNI, double sueldoFijo,
                    int horasRealizadas, double precioHora) {
        super(nombre, apellidos, direccion, DNI, sueldoFijo);
        this.horasRealizadas = horasRealizadas;
        this.precioHora = precioHora;
    }

    @Override
    public double calcularSueldo() {
        if (horasRealizadas <= 40) {
            return sueldoFijo + (horasRealizadas * precioHora);
        } else {
            int horasExtras = horasRealizadas - 40;
            return sueldoFijo + (40 * precioHora) + (horasExtras * (precioHora * 1.5));
        }
    }
}

public class Ejecutor {
    public static void main(String[] args) {
        // Ejemplo de uso
        FijoMensual fijo = new FijoMensual("Juan", "Pérez", "Calle A", "12345678", 2000.0);
        Comisionista comisionista = new Comisionista("María", "Gómez", "Calle B", "98765432",
                1500.0, 10000.0, 0.05);
        PorHoras porHoras = new PorHoras("Pedro", "López", "Calle C", "54321098",
                10.0, 50, 20.0);

        System.out.println("Sueldo de fijo: " + fijo.calcularSueldo());
        System.out.println("Sueldo de comisionista: " + comisionista.calcularSueldo());
        System.out.println("Sueldo por horas: " + porHoras.calcularSueldo());
    }
}
