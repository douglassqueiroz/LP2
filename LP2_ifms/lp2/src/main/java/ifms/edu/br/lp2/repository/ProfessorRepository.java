package ifms.edu.br.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifms.edu.br.lp2.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
    
}
