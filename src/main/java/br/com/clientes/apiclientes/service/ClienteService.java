package br.com.clientes.apiclientes.service;

import br.com.clientes.apiclientes.common.ObjectExtensions;
import br.com.clientes.apiclientes.dataprovider.jpa.ClienteRepository;
import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteRequestDTO;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

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

    public List<Cliente> pesquisarClientes(){

        return clienteRepository.findAll();

    }

    public Cliente atualizarCliente(UUID id, Cliente cliente){
        Cliente clienteAtual = clienteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity nao encontrada"));

        clienteAtual.setNome(cliente.getNome());
        clienteAtual.setEmail(cliente.getEmail());

        return clienteRepository.save(clienteAtual);
    }

  public void excluirCliente(UUID id){
       clienteRepository.deleteById(id);
}


}
