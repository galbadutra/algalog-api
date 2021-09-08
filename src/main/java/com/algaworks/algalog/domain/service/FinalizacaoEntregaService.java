package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private BuscarEntregaService buscarEntregaService;
	private EntregaRepository entregaRepository;

	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscarEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entrega.setStatus(StatusEntrega.FINALIZADA);
		
		entregaRepository.save(entrega);
	}
}