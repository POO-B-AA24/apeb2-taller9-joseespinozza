class Pelicula {
    private String titulo;
    private String autor;
    private int anioEdicion;
    private String idioma;

    public Pelicula(String titulo, String autor, int anioEdicion, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
        this.idioma = idioma;
    }

    public double calcularPrecioAlquiler() {
        // Implementación para calcular el precio de alquiler
        return 0.0; // Placeholder
    }
}

class Dvd extends Pelicula {
    private double capacidadGb;

    public Dvd(String titulo, String autor, int anioEdicion, String idioma, double capacidadGb) {
        super(titulo, autor, anioEdicion, idioma);
        this.capacidadGb = capacidadGb;
    }
}

class Vhs extends Pelicula {
    private String tipoCinta;

    public Vhs(String titulo, String autor, int anioEdicion, String idioma, String tipoCinta) {
        super(titulo, autor, anioEdicion, idioma);
        this.tipoCinta = tipoCinta;
    }
}

public class Ejecutor {
    public static void main(String[] args) {
        // Instanciar objetos con datos aleatorios
        Dvd dvd1 = new Dvd("Matrix", "Wachowski", 1999, "Inglés", 4.7);
        Vhs vhs1 = new Vhs("Titanic", "Cameron", 1997, "Español", "VHS-Standard");

        // Realizar pruebas según la preferencia del usuario
        // ...
    }
}
