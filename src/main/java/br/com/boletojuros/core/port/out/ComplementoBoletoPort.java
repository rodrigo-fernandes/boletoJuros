package br.com.boletojuros.core.port.out;

import br.com.boletojuros.core.domain.Boleto;

/**
 * Interface responsável pela saída do boleto
 * 
 * @author Rodrigo Fernandes
 *
 */
public interface ComplementoBoletoPort {

	Boleto executar(String codigo);
}
