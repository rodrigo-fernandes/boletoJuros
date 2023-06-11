package br.com.boletojuros.core.usecase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enums.TipoBoleto;
import br.com.boletojuros.core.domain.enums.TipoExecao;
import br.com.boletojuros.core.exception.ApplicationException;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import br.com.boletojuros.core.port.out.SalvarCalculoBoletoPort;

/**
 * Responsável por realizar o cálculo do juros do boleto
 * 
 * @author Rodrigo Fernandes
 *
 */
@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {

	private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);

	private final ComplementoBoletoPort complementoBoletoPort;
	private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;

	public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort,
			SalvarCalculoBoletoPort salvarCalculoBoletoPort) {
		this.complementoBoletoPort = complementoBoletoPort;
		this.salvarCalculoBoletoPort = salvarCalculoBoletoPort;
	}

	@Override
	public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {

		var boleto = complementoBoletoPort.executar(codigo);

		validar(boleto);

		var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
		var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(BigDecimal.valueOf(100));
		var juros = valorJurosDia.multiply(BigDecimal.valueOf(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);

		var boletoCalculado = new BoletoCalculado(boleto.getCodigo(), boleto.getValor(), boleto.getValor().add(juros),
				boleto.getDataVencimento(), boleto.getDataVencimento(), juros, boleto.getTipo());

		// TODO - salvar o boleto
		salvarCalculoBoletoPort.executar(boletoCalculado);

		return boletoCalculado;
	}

	// Valida se o boleto está vencido, se o tipo é XPTO e se existe
	private void validar(Boleto boleto) {

		if (boleto == null) {
			throw new ApplicationException(TipoExecao.BOLETO_INVALIDO);
		}

		if (boleto.getTipo() != TipoBoleto.XPTO) {
			throw new ApplicationException(TipoExecao.TIPO_BOLETO_INVALIDO);
		}

		if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
			throw new ApplicationException(TipoExecao.BOLETO_NAO_VENCIDO);
		}
	}

	// Retorna a data em dias
	private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
		return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
	}

}
