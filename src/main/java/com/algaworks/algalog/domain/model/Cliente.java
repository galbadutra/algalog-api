package com.algaworks.algalog.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded= true) 
@Getter 
@Setter 
@Entity  // para que essa classe recebe uma entidade no banco de dados se o nome da tabela fosse diferente @Table(name='tb_cliente')
public class Cliente {
			
			@EqualsAndHashCode.Include // ? aprender
			@Id    // define a chave primaria 
			@GeneratedValue(strategy = GenerationType.IDENTITY) // para usar a forma nativa do banco de dados
			private Long id;
			
			@NotBlank
			@Size(max = 60)
			// exemplo  se nome da coluna for diferente @Column(name = "nome_cliente")
			private String nome;
			
			@NotBlank
			@Email
			@Size(max =255)
			private String email;
			
			@NotBlank
			@Size(max=20)
			private String telefone;
			
}
