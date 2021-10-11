package br.com.promopet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.promopet.entity.Promocao;
import br.com.promopet.service.PromocaoService;

@RestController
@RequestMapping("promocao")
public class PromocaoController {
	
	@Autowired
	private PromocaoService promocaoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Promocao> buscaPorId(@PathVariable Long id){
		Promocao promocao = promocaoService.listarPorId(id);
		return new ResponseEntity<Promocao>(promocao, HttpStatus.OK);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<Page<Promocao>> buscarTodos(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy){
		
		Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC,sortBy));
		
		Page<Promocao> promocoes = promocaoService.listarTodos(pageable);

		return new ResponseEntity<Page<Promocao>>(promocoes, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Promocao> salvar(@RequestBody Promocao promocao){
		Promocao promocaoSalva = promocaoService.salvar(promocao); 
		
		return new ResponseEntity<Promocao>(promocaoSalva, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Promocao> apagar(@PathVariable Long id){
		Promocao promocao = promocaoService.listarPorId(id);
		promocaoService.apagar(promocao); 
		
		return new ResponseEntity<Promocao>(promocao, HttpStatus.OK);
	}
		

}
