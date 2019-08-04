package br.com.dcx.bookmark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcx.bookmark.domain.Livro;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	
}