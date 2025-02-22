package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty (message = "o nome da Turma é obrigatorio")
	private String nome;
	private String semestre;
	private String ano;
	private String turno;
	
	
	@ManyToMany
	@JoinTable(name="turma_abc_professor")
	@JsonIgnoreProperties("turmas")
	@NotEmpty(message = "Não é possível existir uam turma sem pelo menos um professor associado")
	private List<Professor> professores;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnoreProperties()
	private List<Aluno> alunos;
	
	@ManyToOne
	@NotNull(message = "O curso é obrigatório para salvar uma turma")
	private Curso curso;
	
}
