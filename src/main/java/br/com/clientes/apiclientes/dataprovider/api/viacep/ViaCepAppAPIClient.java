package br.com.clientes.apiclientes.dataprovider.api.viacep;

import br.com.clientes.apiclientes.dataprovider.api.viacep.response.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "api-viaCep",
        url = "${client.viacep.host}"
)
@Component
public interface ViaCepAppAPIClient {

    @GetMapping("/{cep}/json")
     ViaCepResponse consultarCep(@RequestParam("cep") String cep);

}
