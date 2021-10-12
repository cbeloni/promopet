package br.com.promopet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.promopet.entity.Promocao;
import br.com.promopet.service.PromocaoService;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping
@CrossOrigin
@Log4j2
public class PromocaoViewController {

	@Autowired
	private PromocaoService promocaoService;
	
	@GetMapping
	public String viewTodos(Model model){	
		List<Promocao> promocoes = promocaoService.listarTodos();
		model.addAttribute("promocoes", promocoes);
		return "index";
	}
	
	@GetMapping("/apagar/{id}")
	public String apagar(@PathVariable Long id, Model model){
		try {
			Promocao promocao = promocaoService.listarPorId(id);
			promocaoService.apagar(promocao);
						
		} catch (Exception ex) {
			log.info("Erro ao apagar promoção");
		}
		List<Promocao> promocoes = promocaoService.listarTodos();
		model.addAttribute("promocoes", promocoes);
		return "index";
	}
	
	
}
