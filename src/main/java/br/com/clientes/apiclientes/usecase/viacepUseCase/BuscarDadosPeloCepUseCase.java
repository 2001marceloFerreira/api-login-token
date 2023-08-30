package br.com.clientes.apiclientes.usecase.viacepUseCase;

import br.com.clientes.apiclientes.dataprovider.api.viacep.response.ViaCepResponse;
import br.com.clientes.apiclientes.service.viacepService.ViacepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarDadosPeloCepUseCase {
    @Autowired
    ViacepService service;

    public ViaCepResponse execute(String cep) {

            return service.BuscarDadosPeloCep(cep);

}
}
