package br.com.clientes.apiclientes.dataprovider.jpa;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteGatewayImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteById(UUID id){
         clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll(){
       return clienteRepository.findAll();
    }



}
