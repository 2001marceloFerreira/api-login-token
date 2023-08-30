package br.com.clientes.apiclientes.dataprovider.jpa;

import br.com.clientes.apiclientes.dataprovider.api.viacep.response.ViaCepResponse;
import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>
{
    void deleteById(UUID id);

    Optional<ViaCepResponse> findByCep(String cep);
}
