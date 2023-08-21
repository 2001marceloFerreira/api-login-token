package br.com.clientes.apiclientes.usecase;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarClienteUseCase {

    @Autowired
    private ClienteService service;

    public Cliente execute(Cliente request) {
        try {
            return service.incluir(request);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
