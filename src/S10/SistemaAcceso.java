package S10;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcceso {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Acceso> accesos = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado exitosamente: " + usuario.getNombre());
    }

    public void registrarAcceso(String codigoUsuario, boolean exito) {
        Usuario usuario = buscarUsuarioPorCodigo(codigoUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        if (usuario.isBloqueado()) {
            System.out.println("Acceso denegado. Usuario bloqueado.");
            return;
        }

        Acceso intento = new Acceso(codigoUsuario, exito);
        accesos.add(intento);

        if (exito) {
            usuario.resetearIntentosFallidos();
            System.out.println("Acceso exitoso registrado.");
        } else {
            usuario.incrementarIntentosFallidos();
            if (usuario.getIntentosFallidos() >= 3) {
                usuario.bloquearUsuario();
                System.out.println("Usuario bloqueado por demasiados intentos fallidos.");
            } else {
                System.out.println("Intento de acceso fallido registrado.");
            }
        }
    }

    public Usuario buscarUsuarioPorCodigo(String codigo) {
        return usuarios.stream().filter(u -> u.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

    public void mostrarAccesos() {
        if (accesos.isEmpty()) {
            System.out.println("No hay intentos de acceso registrados.");
        } else {
            accesos.forEach(System.out::println);
        }
    }
}