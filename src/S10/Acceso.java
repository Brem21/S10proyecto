package S10;

import java.time.LocalDateTime;

public class Acceso {
    private String codigoUsuario;
    private boolean exito;
    private LocalDateTime timestamp;

    public Acceso(String codigoUsuario, boolean exito) {
        this.codigoUsuario = codigoUsuario;
        this.exito = exito;
        this.timestamp = LocalDateTime.now(); // Fecha y hora del intento
    }

    @Override
    public String toString() {
        return String.format("Código Usuario: %s, Acceso: %s, Fecha y Hora: %s",
                codigoUsuario, exito ? "Exitoso" : "Fallido", timestamp);
    }
}


