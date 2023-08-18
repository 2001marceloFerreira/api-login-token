package br.com.clientes.apiclientes.entrypoint.rest;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteRequestDTO;
import br.com.clientes.apiclientes.entrypoint.rest.dto.ClienteResponseDTO;
import br.com.clientes.apiclientes.usecase.AlterarClienteUseCase;
import br.com.clientes.apiclientes.usecase.ConsultarClienteUseCase;
import br.com.clientes.apiclientes.usecase.CriarClienteUseCase;
import br.com.clientes.apiclientes.usecase.ExcluirClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ClienteResource {

    @Autowired
    private CriarClienteUseCase criarClienteUseCase;
    @Autowired
    private ConsultarClienteUseCase consultarClienteUseCase;
    @Autowired
    private AlterarClienteUseCase alterarClienteUseCase;
    @Autowired
    private ExcluirClienteUseCase excluirClienteUseCase;

    //    @Tag(name = "Registro de Acesso")
//    @Operation(summary = "Realizar a inclusão de um novo registro de acesso.")
    @PostMapping
    public ResponseEntity<Object> criarCliente(
            @RequestBody ClienteRequestDTO request
    ) {
        criarClienteUseCase.execute(request);
        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> consultarClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(consultarClienteUseCase.execute());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Cliente> AtualizarCliente(@PathVariable("id") UUID id, @RequestBody Cliente cliente ){

        return ResponseEntity.status(HttpStatus.CREATED).body(alterarClienteUseCase.execute(id,cliente));
    }

    @DeleteMapping
    public void excluirCliente(@RequestParam("id") UUID id){
        excluirClienteUseCase.execute(id);
    }

}
