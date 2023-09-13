//package br.com.clientes.apiclientes;
//
//import br.com.clientes.apiclientes.dataprovider.jpa.ClienteRepository;
//import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//@DataJpaTest
//public class ClienteRepositoryTests {
//
//
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    @Test
//    public void criarClienteTest() {
//        Cliente cliente = new Cliente();
//        cliente.setId(UUID.randomUUID());
//        cliente.setNome("marceloTeste");
//        cliente.setEmail("marcelo@gmail.com");
//        cliente.setCep("73005102");
//        cliente.setIdade(21);
//        cliente.setSenha("123456");
//        cliente.setCep("73005102");
//        cliente.setSalario(3241.74);
//
//        clienteRepository.save(cliente);
//
//        Cliente clienteSalvo = clienteRepository.findById(cliente.getId()).orElse(null);
//        assertThat(clienteSalvo).isNotNull();
//        assertThat(clienteSalvo.getNome()).isEqualTo("Cliente Teste");
//    }
//
//}
