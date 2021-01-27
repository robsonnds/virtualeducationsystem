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


import edu.bj.virtualeducationsystem.model.Tutor;
import edu.bj.virtualeducationsystem.repository.Tutores;

@Controller
@RequestMapping(value = "/tutores")
public class TutorController {
	
	
	
	
	
	private static final String CADASTRO_VIEW = "CadastroTutor";
	
	@Autowired
	private Tutores tutoresRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroTutor");
		mv.addObject(new Tutor());
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	
	public String salvar(@Validated Tutor tutor, Errors errors ,RedirectAttributes attributes){			
		
		if (errors.hasErrors()) {
			
			return CADASTRO_VIEW;
		}
		
		tutoresRepository.save(tutor);
		attributes.addFlashAttribute("mensagem", "Tutor salvo com sucesso");
		
		return "redirect:/tutores/novo";
	
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Tutor>todosTutores = tutoresRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTutores");
		
		mv.addObject("tutores", todosTutores);
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo) {

		
		Tutor tutor	= tutoresRepository.findById(codigo).orElse(null);
		
		ModelAndView mv = new ModelAndView("CadastroTutor");
		
		mv.addObject(tutor);
		
		return mv;
		
			
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo) {
		
		Optional<Tutor> tutor = tutoresRepository.findById(codigo);
		
		if (tutor.isPresent()) {
			
			try {
				tutoresRepository.delete(tutor.get());
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("Erro ao excluir o tutor");
			}
												
		}
		
		return "redirect:/tutores";
			
	}
	

}
