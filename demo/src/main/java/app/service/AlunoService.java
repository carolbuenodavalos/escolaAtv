package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public String save(Aluno aluno) {
		this.alunoRepository.save(aluno); 
		return "Aluno salvo com sucesso";
	}
	

	public String update(long id, Aluno aluno) {
		aluno.setId(id);
		this.alunoRepository.save(aluno); //-> qdo tem ID vira UPDATE livro SET ....
		return "Informações do aluno salvo com sucesso";
	} 
	
	public String delete(long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno deletado com sucesso";
	}
	
	public Aluno findById(long id) {
		return this.alunoRepository.findById(id).get();
	}
	
	public List<Aluno> findByNome(String nome){
		return this.alunoRepository.findByNomeStartingWithIgnoreCase(nome);
	}
	
	public List<Aluno> findByTelefone(String telefone){
		return this.alunoRepository.findByTelefoneContaining(telefone);
	}
	
	
    public List<Aluno> findByTurmaNome(String nome) {
        return alunoRepository.findByTurmaNome(nome);
    }
    
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

}