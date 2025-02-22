package app.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
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
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Pattern
	(regexp = "^\\S+\\s+\\S+.*$", message = "O Professor deve ter no minimo um nome e sobrenome")
	private String nome;
	@CPF
	private String cpf;
	@Email
	private String email;
	
	@Pattern
	(regexp = "^\\S+\\s+\\S+.*$", message = "a especialidade (em caso de haver uma) deve conter duas palavras")
	private String especialidade;
	
	   @ManyToMany(mappedBy = "professores")
	   @JsonIgnoreProperties("professores")
	   private List<Turma> turmas;
	   
	   
}
