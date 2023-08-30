package br.com.clientes.apiclientes.service.viacepService;


import br.com.clientes.apiclientes.dataprovider.api.viacep.ViaCepAppAPIClient;
import br.com.clientes.apiclientes.dataprovider.api.viacep.response.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class ViacepService {

    private static final Logger logger = Logger.getLogger(
            ViacepService.class.getName());

    @Autowired
    private ViaCepAppAPIClient viaCepAppAPIClient;


    public ViaCepResponse BuscarDadosPeloCep(String cep) {
        logger.info("buscando pelo CEP = " + cep);
        return viaCepAppAPIClient.consultarCep(cep);
    }


}
