package br.com.clientes.apiclientes.service;


import br.com.clientes.apiclientes.dataprovider.api.viacep.ViaCepAppAPIClient;
import br.com.clientes.apiclientes.dataprovider.api.viacep.response.ViaCepResponse;
import br.com.clientes.apiclientes.dataprovider.jpa.ClienteGatewayImpl;
import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class ClienteService {

    private static final Logger logger = Logger.getLogger(
            ClienteService.class.getName());

    @Autowired
    private ClienteGatewayImpl clienteGateway;

    @Autowired
    private ViaCepAppAPIClient viaCepAppAPIClient;

    public Cliente incluir(Cliente cliente) {
        return clienteGateway.save(cliente);
    }

    public List<Cliente> pesquisarClientes() {
        return clienteGateway.findAll();
    }


    public ViaCepResponse BuscarDadosPeloCep(String cep) {
        logger.info("buscando pelo CEP = " + cep);
        return viaCepAppAPIClient.consultarCep(cep);
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
