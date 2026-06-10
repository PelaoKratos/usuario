
package microservice.usuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 50, nullable = false)
    private String nombreUsuario;

    @Column(length = 50, nullable = false)
    private String apellidoUsuario;

    @Column(length = 250, nullable = true, unique = true)
    private String correoUsuario;

    @Column(length = 250, nullable = true, unique = true)
    private String contraseñaUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private Role rolUsuario;

    @Column(nullable = false)
    private boolean estado = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
            String contraseñaUsuario, Role rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.rolUsuario = rolUsuario;
    }

    @PrePersist
    void prePersist() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        return estado
                && correoUsuario != null
                && contraseñaUsuario != null
                && correoUsuario.equalsIgnoreCase(correo)
                && contraseñaUsuario.equals(contraseña);
    }

    public void actualizarDatos(String nombre, String apellido, String correo) {
        this.nombreUsuario = nombre;
        this.apellidoUsuario = apellido;
        this.correoUsuario = correo;
    }

    public void desactivar() {
        this.estado = false;
    }

    public void activar() {
        this.estado = true;
    }

    public void recuperarContrasena(String nuevaContrasena) {
        this.contraseñaUsuario = nuevaContrasena;
    }
}
