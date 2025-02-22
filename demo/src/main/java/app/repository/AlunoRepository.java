package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
    // Buscar alunos pelo COMEÇO do nome
	public List<Aluno> findByNomeStartingWithIgnoreCase(String nome);

    // Buscar alunos por QUALQUER PARTE do número de telefone
    public List<Aluno> findByTelefoneContaining(String telefone);



    @Query("SELECT a FROM Aluno a WHERE a.turma.nome = :nome")
    List<Aluno> findByTurmaNome(@Param("nome") String nome);
}


