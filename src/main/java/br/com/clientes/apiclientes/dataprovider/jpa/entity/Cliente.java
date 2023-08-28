package br.com.clientes.apiclientes.dataprovider.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientes")
@Data
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

//
//    @Column(name = "senha", nullable = false, updatable = false)
//    private String senha;
//
//    @Column(name = "idade", nullable = false, updatable = false)
//    private Integer idade;
//
//    @Column(name = "salario", nullable = false, updatable = false)
//    private Double salario;
//
//    @Column(name = "cep", nullable = false, updatable = false)
//    private String cep;
//
//    @Column(name = "dt_cadastro", nullable = false, updatable = false)
//    private LocalDate dtCadastro;
//
//    @Column(name = "autorizacao", nullable = false, updatable = false)
//    private AutorizacaoEnum autorizacao;



}
