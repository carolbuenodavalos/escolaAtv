package app.entity;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern
	(regexp = "^\\S+\\s+\\S+.*$", message = "O nome do Aluno deve conter ao menos duas palavras separadas.")
	private String nome;
	
	@CPF
	private String cpf;
	private String telefone;
	
    @ManyToOne
    @JoinColumn(name = "turma_id")
    @JsonIgnoreProperties("alunos") 
    private Turma turma;
	

	
	
	{
		
	}
	
}
