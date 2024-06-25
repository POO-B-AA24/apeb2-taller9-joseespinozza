import java.util.HashMap;
import java.util.Map;

class Zona {
    private String nombre;
    private int numLocalidades;
    private double precioNormal;
    private double precioAbonado;
    private int localidadesVendidas;

    public Zona(String nombre, int numLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numLocalidades = numLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.localidadesVendidas = 0;
    }

    public boolean tieneLocalidadesDisponibles() {
        return localidadesVendidas < numLocalidades;
    }

    public void venderLocalidad() {
        localidadesVendidas++;
    }

    public double getPrecioEntrada(boolean esAbonado) {
        return esAbonado ? precioAbonado : precioNormal;
    }

    // Getters para otros atributos
}

class Entrada {
    private static int contadorId = 1;
    private int id;
    private String nombreEspectador;
    private Zona zona;

    public Entrada(String nombreEspectador, Zona zona) {
        this.id = contadorId++;
        this.nombreEspectador = nombreEspectador;
        this.zona = zona;
    }

    public int getId() {
        return id;
    }

    public double getPrecioEntrada(boolean esAbonado) {
        return zona.getPrecioEntrada(esAbonado);
    }

    // Getters para otros atributos
}

public class TeatroApp {
    private Map<Integer, Entrada> entradas;

    public TeatroApp() {
        entradas = new HashMap<>();
    }

    public void venderEntrada(String nombreEspectador, Zona zona, boolean esAbonado) {
        if (zona.tieneLocalidadesDisponibles()) {
            Entrada entrada = new Entrada(nombreEspectador, zona);
            entradas.put(entrada.getId(), entrada);
            zona.venderLocalidad();
            System.out.println("Entrada vendida. Identificador: " + entrada.getId() +
                    ", Precio: " + entrada.getPrecioEntrada(esAbonado));
        } else {
            System.out.println("La zona está completa. No se puede vender la entrada.");
        }
    }

    public void consultarEntrada(int id) {
        Entrada entrada = entradas.get(id);
        if (entrada != null) {
            System.out.println("Nombre del espectador: " + entrada.getNombreEspectador() +
                    ", Precio: " + entrada.getPrecioEntrada(false) +
                    ", Zona: " + entrada.getZona().getNombre());
        } else {
            System.out.println("No existe ninguna entrada con ese identificador.");
        }
    }

    public static void main(String[] args) {
        TeatroApp teatro = new TeatroApp();
        Zona principal = new Zona("Principal", 200, 25.0, 17.5);
        teatro.venderEntrada("Juan", principal, false);
        teatro.consultarEntrada(1);
    }
}
