package ifms.edu.br.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifms.edu.br.lp2.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    //public Aluno findById(long id);
}
