package ifms.edu.br.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifms.edu.br.lp2.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{
    
}
