package br.com.boletojuros.adapter.datasource.http.mapper;

import org.mapstruct.Mapper;

import br.com.boletojuros.adapter.datasource.http.dto.CalculoBoletoResponse;
import br.com.boletojuros.core.domain.BoletoCalculado;

/**
 * Converte um BoletoCalculo em CalculoBoletoResponse
 * 
 * @author Rodrigo Fernandes
 *
 */
@Mapper(componentModel = "spring")
public interface CalculoBoletoMapper {

	CalculoBoletoResponse toDTO(BoletoCalculado boletoCalculado);

}
