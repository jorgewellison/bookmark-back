package br.com.dcx.bookmark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dcx.bookmark.domain.Usuario;
import br.com.dcx.bookmark.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepo;
	
	
	public Usuario insert(Usuario usuario){
		usuario.setId(null);
		return userRepo.save(usuario);
	}
}
