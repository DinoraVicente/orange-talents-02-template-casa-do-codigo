package br.com.zup.casaDoCodigo.validacoes;

public class ErrorFormDto {

	private String campo;
	private String erro;
	
	public ErrorFormDto() {
	}

	public ErrorFormDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}