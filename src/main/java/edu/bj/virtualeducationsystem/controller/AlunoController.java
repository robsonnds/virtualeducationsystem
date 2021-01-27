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

import edu.bj.virtualeducationsystem.model.Aluno;
import edu.bj.virtualeducationsystem.repository.Alunos;

@Controller
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	
	
	
	
	private static final String CADASTRO_VIEW = "CadastroAluno";
	
	@Autowired
	private Alunos alunosRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroAluno");
		mv.addObject(new Aluno());
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	
	public String salvar(@Validated Aluno aluno, Errors errors ,RedirectAttributes attributes){			
		
		if (errors.hasErrors()) {
			
			return CADASTRO_VIEW;
		}
		
		alunosRepository.save(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso");
		
		return "redirect:/alunos/novo";
	
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Aluno>todosAlunos = alunosRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaAlunos");
		
		mv.addObject("alunos", todosAlunos);
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo) {

		
		Aluno aluno = alunosRepository.findById(codigo).orElse(null);
		
		ModelAndView mv = new ModelAndView("CadastroAluno");
		
		mv.addObject(aluno);
		
		return mv;
		
			
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo) {
		
		Optional<Aluno> aluno = alunosRepository.findById(codigo);
		
		if (aluno.isPresent()) {
			
			try {
				alunosRepository.delete(aluno.get());
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("Erro ao excluir o aluno");
			}
												
		}
		
		return "redirect:/alunos";
			
	}
	

}
