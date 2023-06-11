package br.com.boletojuros.core.port.in;

import java.time.LocalDate;

import br.com.boletojuros.core.domain.BoletoCalculado;

/**
 * Interface contendo a regra de entrada do boleto
 * 
 * @author Rodrigo Fernandes
 *
 */
public interface CalculoBoletoPort {

	BoletoCalculado executar(String codigo, LocalDate dataPagamento);

}
