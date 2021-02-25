package br.com.zup.casaDoCodigo.clientes;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casaDoCodigo.paiseestado.Estado;
import br.com.zup.casaDoCodigo.paiseestado.Pais;
import br.com.zup.casaDoCodigo.validacoes.CpfOuCnpj;
import br.com.zup.casaDoCodigo.validacoes.ExistsId;
import br.com.zup.casaDoCodigo.validacoes.UniqueValue;

public class ClienteForm {
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CpfOuCnpj
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "CPF ou CNPJ já cadastrado")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "País não existe")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id", message = "Estado não existe")
    private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	@Deprecated
	public ClienteForm() {
	}

	public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
            @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais, Long idEstado,
            @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

    public Cliente toModel(EntityManager manager) {
    	Pais pais = manager.find(Pais.class, idPais);
    	Estado estado = manager.find(Estado.class, idEstado);
    	
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais,
                estado, telefone, cep);
    }
}