package br.com.clientes.apiclientes.dataprovider.request;

import br.com.clientes.apiclientes.model.dto.enums.UserRoleEnum;

public record RegisterDTO(String login, String password, UserRoleEnum role) {
}
