package br.com.clientes.apiclientes.entrypoint.rest.dto;

import br.com.clientes.apiclientes.model.dto.enums.AutorizacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteResponseDTO {

    private UUID id;

    private String nome;

//    private String email;
//
//    private String senha;
//
//    private Integer idade;
//
//    private Double salario;
//
//    private String cep;
//
//    private AutorizacaoEnum autorizacao;

}
