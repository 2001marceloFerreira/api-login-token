package br.com.clientes.apiclientes.usecase;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlterarClienteUseCase {

    @Autowired
    private ClienteService service;

    public Cliente execute(UUID id, Cliente cliente) {
        try {
            return service.atualizarCliente(id, cliente);
        } catch (Exception e) {
            return null;
        }
    }

}
