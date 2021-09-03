package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Transactional
	public 	Cliente salvar(Cliente cliente) {
			boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
					.stream()
					.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
			if(emailEmUso) {
				throw new NegocioException("Já existe um email cadastrado.");
			}
			return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
