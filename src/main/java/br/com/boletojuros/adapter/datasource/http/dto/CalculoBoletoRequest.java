package br.com.boletojuros.adapter.datasource.http.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculoBoletoRequest {

	@NotNull
	private String codigo;
	@NotNull
	@JsonProperty("data_pagamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
