package br.com.clientes.apiclientes.entrypoint.rest;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.usecase.AlterarClienteUseCase;
import br.com.clientes.apiclientes.usecase.ConsultarClienteUseCase;
import br.com.clientes.apiclientes.usecase.CriarClienteUseCase;
import br.com.clientes.apiclientes.usecase.ExcluirClienteUseCase;
import br.com.clientes.apiclientes.usecase.viacepUseCase.BuscarDadosPeloCepUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteResource {

    @Autowired
    private CriarClienteUseCase criarClienteUseCase;
    @Autowired
    private ConsultarClienteUseCase consultarClienteUseCase;
    @Autowired
    private AlterarClienteUseCase alterarClienteUseCase;
    @Autowired
    private ExcluirClienteUseCase excluirClienteUseCase;

    @Autowired
    private BuscarDadosPeloCepUseCase buscarDadosPeloCepUseCase;

    @Tag(name = "Usuario")
    @Operation(summary = "Realizar a inclusão de um novo Cliente.")
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(
            @RequestBody Cliente request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED).body(criarClienteUseCase.execute(request));
    }

    @Tag(name = "Usuario")
    @Operation(summary = "Busca todos os Clientes.")
    @GetMapping
    public ResponseEntity<List<Cliente>> consultarClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(consultarClienteUseCase.execute());
    }

    @Tag(name = "Usuario")
    @Operation(summary = "Atualiza os dados do Cliente.")
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Cliente> AtualizarCliente(@PathVariable("id") UUID id, @RequestBody Cliente cliente) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alterarClienteUseCase.execute(id, cliente));
    }

    @Tag(name = "Usuario")
    @Operation(summary = "Realiza a exclusão de um Cliente.")
    @DeleteMapping
    public void excluirCliente(@RequestParam("id") UUID id) {
        excluirClienteUseCase.execute(id);
    }

}
