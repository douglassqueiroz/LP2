package ifms.edu.br.lp2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAluno;
    private String nome;

    public String getNome(){
        return nome;
    }
    public void setNome(String newNome){
        this.nome = newNome;
    }
}
