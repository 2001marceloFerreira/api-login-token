package br.com.clientes.apiclientes.usecase;

import br.com.clientes.apiclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;



@Component
public class ExcluirClienteUseCase {

    @Autowired
    private ClienteService service;

    public void execute(UUID id) {
        try {
             service.excluirCliente(id);
        } catch (Exception e) {

        }
    }

}
