package br.com.clientes.apiclientes.service;

import br.com.clientes.apiclientes.common.ObjectExtensions;
import br.com.clientes.apiclientes.dataprovider.jpa.ClienteRepository;
import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteRequestDTO;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public synchronized ClienteResponseDTO incluir(ClienteRequestDTO requestDTO){

        Cliente cliente = ObjectExtensions.toObject(requestDTO, Cliente.class);

        return ObjectExtensions.toObject(
                clienteRepository.save(cliente),
                ClienteResponseDTO.class);
    }

}
