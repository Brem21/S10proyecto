package S10;
public class Usuario {
    private String codigo;
    private String nombre;
    private String apellido;
    private String departamento;
    private String nivelAcceso;
    private int intentosFallidos;
    private boolean bloqueado;

    public Usuario(String codigo, String nombre, String apellido, String departamento, String nivelAcceso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.nivelAcceso = nivelAcceso;
        this.intentosFallidos = 0;
        this.bloqueado = false;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDepartamento() { return departamento; }
    public String getNivelAcceso() { return nivelAcceso; }
    public int getIntentosFallidos() { return intentosFallidos; }
    public boolean isBloqueado() { return bloqueado; }

    public void incrementarIntentosFallidos() { this.intentosFallidos++; }
    public void resetearIntentosFallidos() { this.intentosFallidos = 0; }
    public void bloquearUsuario() { this.bloqueado = true; }
    public void desbloquearUsuario() { this.bloqueado = false; }

    // Representación en String para mostrar información
    @Override
    public String toString() {
        return String.format("Código: %s, Nombre: %s %s, Departamento: %s, Nivel de Acceso: %s, Intentos Fallidos: %d, Bloqueado: %s",
                codigo, nombre, apellido, departamento, nivelAcceso, intentosFallidos, bloqueado ? "Sí" : "No");
    }
}