// Clase base: Mensaje
abstract class Mensaje {
    private String remitente;
    private String destinatario;
    private String nombreRemitente;
    private String nombreDestinatario;

    public Mensaje(String remitente, String destinatario, String nombreRemitente, String nombreDestinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.nombreRemitente = nombreRemitente;
        this.nombreDestinatario = nombreDestinatario;
    }

    public abstract void enviarMensaje();
    public abstract void visualizarMensaje();
}

// Subclase: MensajeTexto
class MensajeTexto extends Mensaje {
    private String texto;

    public MensajeTexto(String remitente, String destinatario, String nombreRemitente, String nombreDestinatario, String texto) {
        super(remitente, destinatario, nombreRemitente, nombreDestinatario);
        this.texto = texto;
    }

    @Override
    public void enviarMensaje() {
        // Implementación para enviar el mensaje de texto
        System.out.println("Enviando mensaje de texto: " + texto);
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("Mensaje de texto: " + texto);
    }
}

// Subclase: MensajeImagen
class MensajeImagen extends Mensaje {
    private String nombreImagen;

    public MensajeImagen(String remitente, String destinatario, String nombreRemitente, String nombreDestinatario, String nombreImagen) {
        super(remitente, destinatario, nombreRemitente, nombreDestinatario);
        this.nombreImagen = nombreImagen;
    }

    @Override
    public void enviarMensaje() {
        // Implementación para enviar la imagen
        System.out.println("Enviando imagen: " + nombreImagen);
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("Nombre de la imagen: " + nombreImagen);
    }
}

// Ejemplo de uso
public class Ejecutor {
    public static void main(String[] args) {
        MensajeTexto mensajeTexto = new MensajeTexto("123456", "987654", "Juan", "María", "¡Hola!");
        mensajeTexto.enviarMensaje();
        mensajeTexto.visualizarMensaje();

        MensajeImagen mensajeImagen = new MensajeImagen("123456", "987654", "Juan", "María", "vacaciones.jpg");
        mensajeImagen.enviarMensaje();
        mensajeImagen.visualizarMensaje();
    }
}
