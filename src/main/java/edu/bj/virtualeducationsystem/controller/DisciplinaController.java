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


import edu.bj.virtualeducationsystem.model.Disciplina;
import edu.bj.virtualeducationsystem.repository.Disciplinas;

@Controller
@RequestMapping(value = "/disciplinas")
public class DisciplinaController {
	
	
	
	private static final String CADASTRO_VIEW = "CadastroDisciplinas";
	
	@Autowired
	private Disciplinas disciplinaRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroDisciplinas");
		mv.addObject(new Disciplina());
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	
	public String salvar(@Validated Disciplina disciplina, Errors errors ,RedirectAttributes attributes){			
		
		if (errors.hasErrors()) {
			
			return CADASTRO_VIEW;
		}
		
		disciplinaRepository.save(disciplina);
		attributes.addFlashAttribute("mensagem", "Disciplina salva com sucesso");
		
		return "redirect:/disciplinas/novo";
	
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Disciplina>todasDisciplinas = disciplinaRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaDisciplinas");
		
		mv.addObject("disciplinas", todasDisciplinas);
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo) {

		
		Disciplina disciplina	= disciplinaRepository.findById(codigo).orElse(null);
		
		ModelAndView mv = new ModelAndView("CadastroDisciplinas");
		
		mv.addObject(disciplina);
		
		return mv;
		
			
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo) {
		
		Optional<Disciplina> disciplina = disciplinaRepository.findById(codigo);
		
		if (disciplina.isPresent()) {
			
			try {
				disciplinaRepository.delete(disciplina.get());
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("Erro ao excluir A Disciplina");
			}
												
		}
		
		return "redirect:/disciplinas";
			
	}
	

}
