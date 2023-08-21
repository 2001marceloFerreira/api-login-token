package br.com.clientes.apiclientes.service;

import br.com.clientes.apiclientes.dataprovider.jpa.ClienteGatewayImpl;
import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ClienteService {

    @Autowired
    private ClienteGatewayImpl clienteGateway;


    public Cliente incluir(Cliente cliente) {
        return clienteGateway.save(cliente);
    }

    public List<Cliente> pesquisarClientes() {
        return clienteGateway.findAll();
    }

    public Cliente atualizarCliente(UUID id, Cliente cliente) {

        Cliente clienteExistente = clienteGateway.findById(id).orElseThrow(() -> null);

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());

        return clienteGateway.save(clienteExistente);
    }

    public void excluirCliente(UUID id) {
        clienteGateway.deleteById(id);
    }


}
