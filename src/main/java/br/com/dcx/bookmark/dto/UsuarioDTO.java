package br.com.dcx.bookmark.dto;

import java.io.Serializable;

import br.com.dcx.bookmark.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String nome;
	
	public UsuarioDTO(){}
	
	public UsuarioDTO(Usuario usuario){
		id = usuario.getId();
		nome = usuario.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
