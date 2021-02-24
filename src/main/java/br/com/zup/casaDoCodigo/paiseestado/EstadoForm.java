package br.com.zup.casaDoCodigo.paiseestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casaDoCodigo.validacoes.ExistsId;
import br.com.zup.casaDoCodigo.validacoes.UniqueValue;

public class EstadoForm {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Nome é obrigatório")
	private String nome;
	@NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Pais não existe")
	private Long idPais;
	
	@Deprecated
	public EstadoForm() {
	}
	
	public EstadoForm(@NotBlank Estado estado, @NotNull Pais pais) {
		this.nome = estado.getNome();
		this.idPais = pais.getId();
	}

	public String getNome() {
		return nome;
	}
	
	public Long getIdPais() {
		return idPais;
	}

	public Estado toModel(EntityManager manager) {
		return new Estado(nome, manager.find(Pais.class, idPais));
	}

	@Override
	public String toString() {
		return "EstadoForm [nome=" + nome + ", idPais=" + idPais + "]";
	}
}