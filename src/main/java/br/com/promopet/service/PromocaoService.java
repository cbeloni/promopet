package br.com.promopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.promopet.entity.Promocao;
import br.com.promopet.repository.PromocaoRepository;

@Service
public class PromocaoService {
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	public Promocao salvar(Promocao promocao) {
		return promocaoRepository.save(promocao); 
	}
	
	public void apagar(Promocao promocao) {
		promocaoRepository.delete(promocao); 
	}
	
	public Page<Promocao> listarTodos(final Pageable pageable){
		return promocaoRepository.findAll(pageable);
	}
	
	public List<Promocao> listarTodos(){
		return promocaoRepository.findAll(Sort.by(Sort.Direction.DESC,"atualizacao"));
	}
	
	public Promocao listarPorId(Long id) {
		return promocaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
	}

}
