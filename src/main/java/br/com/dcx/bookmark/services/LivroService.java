package br.com.dcx.bookmark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dcx.bookmark.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;
}
