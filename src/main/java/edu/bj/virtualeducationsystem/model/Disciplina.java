package edu.bj.virtualeducationsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class Disciplina {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	@Column(name = "descricao", nullable = false, length = 80)
	private String descricao;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	private boolean ativa;
	
	//private Tutor tutor;
	
	//private Aluno aluno;
	
	//private Aula aula
	
	

}
