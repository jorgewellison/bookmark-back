package br.com.dcx.bookmark.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dcx.bookmark.domain.Livro;
import br.com.dcx.bookmark.repositories.LivroRepository;
import br.com.dcx.bookmark.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;
	
	
	public Livro insert(Livro livro){
		livro.setId(null); /*Garantindo que o objeto adicionado seja um novo objeto, por isso o id nulo*/
		return repo.save(livro);
	}
	
	public Livro find(Integer id) {
		Optional<Livro> livro = repo.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
		}

	
	public List<Livro> findAll(){
		return repo.findAll();
	}
	
	public void delete(Integer id){
		repo.deleteById(id);
	}
	
	public Livro update(Livro livro){
		find(livro.getId());
		return repo.save(livro);
	}
}
