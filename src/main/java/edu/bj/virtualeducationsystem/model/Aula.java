package edu.bj.virtualeducationsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class Aula {
	
	@Column(name = "titulo", nullable = false, length = 80)
	private String titulo;
	
	
	@Column(name = "descricao", nullable = false, length = 80)
	private String descricao;

	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	
	

}
