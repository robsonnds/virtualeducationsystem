package edu.bj.virtualeducationsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="disciplina")
public class Disciplina {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	@Column(name = "descricao", nullable = false, length = 80)
	private String descricao;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	
	@Column(name = "disciplina_ativa")
	private boolean disciplinaAtiva;
	
	
	
	//private Tutor tutor;
	
	//private Aluno aluno;
	
	//private Aula aula

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isAtiva() {
		return disciplinaAtiva;
	}

	public void setAtiva(boolean ativa) {
		this.disciplinaAtiva = ativa;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + ", ativa=" + disciplinaAtiva + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disciplinaAtiva ? 1231 : 1237);
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (disciplinaAtiva != other.disciplinaAtiva)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	

	
	

}
