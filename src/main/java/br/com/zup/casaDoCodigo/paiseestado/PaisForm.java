package br.com.zup.casaDoCodigo.paiseestado;

import javax.validation.constraints.NotBlank;

import br.com.zup.casaDoCodigo.validacoes.UniqueValue;

public class PaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Nome é obrigatório")
	private String nome;
	
	@Deprecated
	public PaisForm() {
	}
	
	public PaisForm(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}
}