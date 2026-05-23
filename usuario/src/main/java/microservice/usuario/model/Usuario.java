
package microservice.usuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String nombreUsuario;

    @Column(length = 50, nullable = false)
    private String apellidoUsuario;

    @Column(length = 250, nullable = true, unique = true)
    private String correoUsuario;

    @Column(length = 250, nullable = true, unique = true)
    private String contraseñaUsuario;

    @Column(length = 250, nullable = true, unique = true)
    private String rolUsuario;


}
