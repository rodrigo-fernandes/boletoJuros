package br.com.boletojuros.core.port.out;

import br.com.boletojuros.core.domain.BoletoCalculado;

/**
 * Executa o cálculo de BoletoCalculado de saída
 * 
 * @author Rodrigo Fernandes
 *
 */
public interface SalvarCalculoBoletoPort {

	void executar(BoletoCalculado boletoCalculado);

}
