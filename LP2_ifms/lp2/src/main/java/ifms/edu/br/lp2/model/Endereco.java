package ifms.edu.br.lp2.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@javax.persistence.Entity
public class Endereco {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEndereco;
    
    @Column()
    private String nameEndereco;
}
