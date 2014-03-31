/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table (name = "tipoendereco")
public class TipoEndereco implements Serializable{
    
       private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue
    @Column(name="IdTipoEndereco",nullable = false)  
    private Integer idTipoEndereco;
    @Column(name = "Nome",nullable = false,length = 80)
    private String  nome;

    @OneToMany(mappedBy = "tipoendereco",fetch = FetchType.LAZY)
    @ForeignKey(name="TipoEnderecoEndereco")
    private List<Endereco> enderecos;
    public TipoEndereco() {
    }

    public Integer getIdEndereco() {
        return idTipoEndereco;
    }

    public void setIdEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        return true;
    }
    
    
}
