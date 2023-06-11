package br.com.boletojuros.adapter.datasource.database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.boletojuros.core.domain.enums.TipoBoleto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boleto_calculado")
public class BoletoCalculadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String codigo;
	@Column(name = "valor_original")
	private BigDecimal valorOriginal;
	@Column
	private BigDecimal valor;
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;
	@Column
	private BigDecimal juros;
	@Column
	private TipoBoleto tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public TipoBoleto getTipo() {
		return tipo;
	}

	public void setTipo(TipoBoleto tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "BoletoCalculadoEntity [id=" + id + ", codigo=" + codigo + ", valorOriginal=" + valorOriginal
				+ ", valor=" + valor + ", dataVencimento=" + dataVencimento + ", dataPagamento=" + dataPagamento
				+ ", juros=" + juros + ", tipo=" + tipo + "]";
	}

}
