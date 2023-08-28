package br.com.clientes.apiclientes.usecase;

import br.com.clientes.apiclientes.commons.exceptions.*;
import br.com.clientes.apiclientes.commons.extensions.JsonExtensions;
import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.service.ClienteService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CriarClienteUseCase {

    @Autowired
    private ClienteService service;

    public Cliente execute(Cliente request) {
        try {
            return service.incluir(request);

        } catch (FeignException e) {
            String erroMessage = JsonExtensions.erroMessageToString(e.getMessage().toString());
            if (e.status() == HttpStatus.NOT_FOUND.value()){
                throw new NotFoundException("Requisição não encontrada. "+ erroMessage, e);
            }
            if (e.status() == HttpStatus.BAD_REQUEST.value()) {
                throw new BadRequestException("Corpo da requisição inválido: " + erroMessage, e);
            }
            if(e.status() == HttpStatus.UNAUTHORIZED.value()) {
                throw new UnauthorizedException("Requer autorização", e);
            }
            if(e.status() == HttpStatus.FORBIDDEN.value()) {
                throw new ForbiddenException("Você não tem permissão para acessar", e);
            }
            throw new ClienteException("Oops! Alguma coisa deu errado.", e);
        } catch (Exception e) {
            throw new ClienteException("Não foi possível criar o Cliente", e);
        }
    }
}
