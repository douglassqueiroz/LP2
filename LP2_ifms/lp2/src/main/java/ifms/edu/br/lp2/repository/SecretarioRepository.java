package ifms.edu.br.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifms.edu.br.lp2.model.Secretario;

public interface SecretarioRepository extends JpaRepository<Secretario, Long> {
    
}
