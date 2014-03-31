

package br.com.iron.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Rhuan
 */
@Entity
@Table (name = "cidade")
public class Cidade implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdCidade",nullable = false)  
    private Integer idCidade;
    @Column(name = "Nome",nullable = false,length = 80)
    private String  nome;

    @OneToMany(mappedBy = "cidade",fetch = FetchType.LAZY)
    @ForeignKey(name="CidadeEndereco")
    private List<Endereco> enderecos;
    public Cidade() {
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        return true;
    }

    
    
}
