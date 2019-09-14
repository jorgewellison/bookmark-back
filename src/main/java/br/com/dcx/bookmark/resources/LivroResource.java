package br.com.dcx.bookmark.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dcx.bookmark.domain.Livro;
import br.com.dcx.bookmark.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Livro livro){
		livro = service.insert(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Livro>> find(@PathVariable Integer id){
		Optional<Livro> livro = service.find(id);
		return ResponseEntity.ok().body(livro);
	}
}
