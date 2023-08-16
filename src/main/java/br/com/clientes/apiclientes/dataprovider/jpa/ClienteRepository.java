package br.com.clientes.apiclientes.dataprovider.jpa;

import br.com.clientes.apiclientes.dataprovider.jpa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>
{

}
