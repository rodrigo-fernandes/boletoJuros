package br.com.boletojuros.adapter.datasource.http.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ErroResponse {

	private List<String> mensagens = new ArrayList<>();
	private String erro;
	private int codigo;
	private Date timestamp;
	private String path;

	public ErroResponse(List<String> mensagens, String erro, int codigo, Date timestamp, String path) {
		super();
		this.mensagens = mensagens;
		this.erro = erro;
		this.codigo = codigo;
		this.timestamp = timestamp;
		this.path = path;
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
