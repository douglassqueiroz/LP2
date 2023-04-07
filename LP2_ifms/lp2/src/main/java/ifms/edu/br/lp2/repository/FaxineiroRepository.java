package ifms.edu.br.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifms.edu.br.lp2.model.Faxineiro;

public interface FaxineiroRepository extends JpaRepository <Faxineiro, Long> {
    
}
