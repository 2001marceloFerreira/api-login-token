package br.com.clientes.apiclientes.usecase;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteRequestDTO;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteResponseDTO;
import br.com.clientes.apiclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarClienteUseCase {

    @Autowired
    private ClienteService service;

public void execute(ClienteRequestDTO request){
    try {
//        ClienteResponseDTO  response = service.incluir(request);
        service.incluir(request);

    }catch (Exception e){

    }
}

}
