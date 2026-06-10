package microservice.usuario.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class UsuarioModelTest {

    @Test
    void iniciarSesionValidaCredencialesYEstado() {
        Usuario usuario = new Usuario(1L, "Ana", "Rojas", "ana@mail.com", "clave", new Role());

        assertThat(usuario.iniciarSesion("ana@mail.com", "clave")).isTrue();

        usuario.desactivar();

        assertThat(usuario.iniciarSesion("ana@mail.com", "clave")).isFalse();
    }

    @Test
    void actualizaActivaYRecuperaContrasena() {
        Usuario usuario = new Usuario();

        usuario.actualizarDatos("Luis", "Perez", "luis@mail.com");
        usuario.recuperarContrasena("nueva");
        usuario.activar();

        assertThat(usuario.getNombreUsuario()).isEqualTo("Luis");
        assertThat(usuario.getApellidoUsuario()).isEqualTo("Perez");
        assertThat(usuario.getCorreoUsuario()).isEqualTo("luis@mail.com");
        assertThat(usuario.getContraseñaUsuario()).isEqualTo("nueva");
        assertThat(usuario.isEstado()).isTrue();
    }

    @Test
    void prePersistDefineFechaCreacionSiNoExiste() {
        Usuario usuario = new Usuario();

        usuario.prePersist();

        assertThat(usuario.getFechaCreacion()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}
