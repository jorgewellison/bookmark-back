package br.com.dcx.bookmark.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dcx.bookmark.domain.Usuario;
import br.com.dcx.bookmark.repositories.UsuarioRepository;
import br.com.dcx.bookmark.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepo;
	
	
	public Usuario insert(Usuario usuario){
		usuario.setId(null);
		return userRepo.save(usuario);
	}
	
	public Usuario find(Integer id) {
		Optional<Usuario> usuario = userRepo.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
		}
	
	public Usuario update(Usuario usuario){
		find(usuario.getId());
		return userRepo.save(usuario);
	}
}
