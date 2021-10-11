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

@Controller
@RequestMapping
@CrossOrigin
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
		Promocao promocao = promocaoService.listarPorId(id);
		promocaoService.apagar(promocao);
		
		List<Promocao> promocoes = promocaoService.listarTodos();
		model.addAttribute("promocoes", promocoes);
		return "index";
	}
	
	
}
