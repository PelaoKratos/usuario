package microservice.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.usuario.model.Usuario;
import microservice.usuario.repository.UsuarioRepository;
@Service
public class UsuarioService {
        @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setApellidoUsuario(usuario.getApellidoUsuario());
            usuarioExistente.setCorreoUsuario(usuario.getCorreoUsuario());
            usuarioExistente.setContraseñaUsuario(usuario.getContraseñaUsuario());
            usuarioExistente.setRolUsuario(usuario.getRolUsuario());
        }
        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario deleteUsuario(Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioRepository.delete(usuarioExistente);
        }
        return usuarioExistente;
    }
}
