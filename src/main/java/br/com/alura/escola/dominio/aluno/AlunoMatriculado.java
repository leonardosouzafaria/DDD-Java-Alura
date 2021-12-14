package br.com.alura.escola.dominio.aluno;

import java.time.LocalDateTime;

import br.com.alura.escola.dominio.Evento;

public class AlunoMatriculado implements Evento{

	private CPF cpf;
	private LocalDateTime momento;
	
	public AlunoMatriculado(CPF cpfDoAluno) {
		this.cpf = cpfDoAluno;
		this.momento = LocalDateTime.now();
	}
	
	public CPF getCpf() {
		return cpf;
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

}
