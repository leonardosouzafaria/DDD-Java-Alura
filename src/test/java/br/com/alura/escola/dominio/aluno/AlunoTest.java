package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.infra.aluno.MaximoTelefonePorAlunoException;

class AlunoTest {
	
	private Aluno aluno;
	
	@BeforeEach
	void inicializar() {
		this.aluno = new Aluno(new CPF("664.253.640-17"), "Leonardo de Souza Faria", new Email("leonardo.email@gmail.com"));
	}
	
	@Test
	void devePermitirAdicionarUmTelefone() {
		this.aluno.adicionarTelefone("11", "56545654");
		assertEquals(1, this.aluno.getTelefones().size());
	}
	
	@Test
	void devePermitirAdicionarDoisTelefone() {
		this.aluno.adicionarTelefone("11", "56545654");
		this.aluno.adicionarTelefone("11", "56545654");
		assertEquals(2, this.aluno.getTelefones().size());
	}

	@Test
	void naoDeveriaAdicionarTelefoneSeListaForIgualADois() {
		assertThrows(MaximoTelefonePorAlunoException.class, ()-> {
			this.aluno.adicionarTelefone("11", "56545654");
			this.aluno.adicionarTelefone("11", "56545654");
			this.aluno.adicionarTelefone("11", "56545654");
		});
	}

}
