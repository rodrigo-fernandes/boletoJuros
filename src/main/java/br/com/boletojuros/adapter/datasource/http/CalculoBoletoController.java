package br.com.boletojuros.adapter.datasource.http;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boletojuros.adapter.datasource.http.dto.CalculoBoletoRequest;
import br.com.boletojuros.adapter.datasource.http.dto.CalculoBoletoResponse;
import br.com.boletojuros.adapter.datasource.http.mapper.CalculoBoletoMapper;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Classe responsável pela ponte com a API (entrada)
 * 
 * @author Rodrigo Fernandes
 *
 */
@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {

	private final CalculoBoletoPort calculoBoletoPort;
	private final CalculoBoletoMapper mapper;

	public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, CalculoBoletoMapper mapper) {
		this.calculoBoletoPort = calculoBoletoPort;
		this.mapper = mapper;
	}

	@PostMapping("/calculo")
	@Operation(summary = "Calcular juros de um boleto")
	public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto) {

		var boletoCalculado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());

		return ResponseEntity.ok(mapper.toDTO(boletoCalculado));

	}

}
