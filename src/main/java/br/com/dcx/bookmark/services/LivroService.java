package br.com.dcx.bookmark.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dcx.bookmark.domain.Livro;
import br.com.dcx.bookmark.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;
	
	
	public Livro insert(Livro livro){
		livro.setId(null); /*Garantindo que o objeto adicionado seja um novo objeto, por isso o id nulo*/
		return repo.save(livro);
	}
	
	public Optional<Livro> find(Integer id) {
		return repo.findById(id);
	}
	
	public List<Livro> findAll(){
		return repo.findAll();
	}
	
	public void delete(Integer id){
		repo.deleteById(id);
	}
}
