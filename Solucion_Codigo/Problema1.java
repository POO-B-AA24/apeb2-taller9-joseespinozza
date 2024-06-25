class Capitulo {
    private String titulo;
    private int numero;
    private List<Seccion> secciones;

    // Otros atributos y métodos relevantes
}

class Seccion extends Capitulo {
    private String contenido;
    private List<Parrafo> parrafos;

    // Otros atributos y métodos relevantes
}

class Parrafo extends Seccion {
    private List<Sentencia> sentencias;

    // Otros atributos y métodos relevantes
}

class Sentencia extends Parrafo {
    private List<String> palabras;

    // Otros atributos y métodos relevantes
}

class Figura {
    private String nombre;
    private String ruta;
    private String descripcion;

    // Otros atributos y métodos relevantes
}
