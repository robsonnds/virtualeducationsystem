package edu.bj.virtualeducationsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bj.virtualeducationsystem.model.Aula;
import edu.bj.virtualeducationsystem.repository.Aulas;

@Controller
@RequestMapping(value = "/aulas")
public class AulaController {
	
	
	
	
	
	private static final String CADASTRO_VIEW = "CadastroAula";
	
	@Autowired
	private Aulas aulasRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroAula");
		mv.addObject(new Aula());
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	
	public String salvar(@Validated Aula aula, Errors errors ,RedirectAttributes attributes){			
		
		if (errors.hasErrors()) {
			
			return CADASTRO_VIEW;
		}
		
		aulasRepository.save(aula);
		attributes.addFlashAttribute("mensagem", "Aula salva com sucesso");
		
		return "redirect:/aulas/novo";
	
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Aula>todosAulas = aulasRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTutores");
		
		mv.addObject("aulas", todosAulas);
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo) {

		
		Aula aula	= aulasRepository.findById(codigo).orElse(null);
		
		ModelAndView mv = new ModelAndView("CadastroAula");
		
		mv.addObject(aula);
		
		return mv;
		
			
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo) {
		
		Optional<Aula> aula = aulasRepository.findById(codigo);
		
		if (aula.isPresent()) {
			
			try {
				aulasRepository.delete(aula.get());
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("Erro ao excluir a Aula");
			}
												
		}
		
		return "redirect:/aulas";
			
	}
	

}
