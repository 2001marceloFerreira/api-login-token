package br.com.clientes.apiclientes.usecase;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteResponseDTO;
import br.com.clientes.apiclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ConsultarClienteUseCase {

    @Autowired
    private ClienteService service;

    public List<Cliente> execute() {

        return service.pesquisarClientes();

    }

}
