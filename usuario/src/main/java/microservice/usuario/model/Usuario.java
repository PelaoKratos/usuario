
package microservice.usuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    private String nombreUsuario;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede superar 50 caracteres")
    private String apellidoUsuario;

    @Column(length = 250, nullable = true, unique = true)
    @NotBlank(message = "El correo no puede estar vacío")
    @Size(max = 250, message = "El correo no puede superar 250 caracteres")
    private String correoUsuario;

    @Column(length = 250, nullable = true, unique = true)
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(max = 250, message = "La contraseña no puede superar 250 caracteres")
    private String contraseñaUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private Role rolUsuario;

}
