package br.com.boletojuros.core.exception;

import br.com.boletojuros.core.domain.enums.TipoExecao;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Classe responsável por subir a exceção
 * 
 * @author Rodrigo Fernandes
 *
 */
@AllArgsConstructor
public class ApplicationException extends RuntimeException {

	private TipoExecao tipoExecao;

	public ApplicationException(TipoExecao tipoExecao) {
		super();
		this.tipoExecao = tipoExecao;
	}

	public TipoExecao getTipoExecao() {
		return tipoExecao;
	}

	public void setTipoExecao(TipoExecao tipoExecao) {
		this.tipoExecao = tipoExecao;
	}

	@Override
	public String toString() {
		return "ApplicationException [tipoExecao=" + tipoExecao + "]";
	}

}
