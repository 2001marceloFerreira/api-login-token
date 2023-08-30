package br.com.clientes.apiclientes.entrypoint.rest.viacepResource;

import br.com.clientes.apiclientes.dataprovider.api.viacep.response.ViaCepResponse;
import br.com.clientes.apiclientes.usecase.viacepUseCase.BuscarDadosPeloCepUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cep")
public class ViacepResource {

    @Autowired
    private BuscarDadosPeloCepUseCase buscarDadosPeloCepUseCase;

    @Tag(name = "Via CEP")
    @Operation(summary = "Mostra as informações pelo CEP.")
    @GetMapping
    public ResponseEntity<ViaCepResponse> BuscarDadosPeloCep(@RequestParam String cep){
        return ResponseEntity.status(HttpStatus.OK).body(buscarDadosPeloCepUseCase.execute(cep));
    }

}
