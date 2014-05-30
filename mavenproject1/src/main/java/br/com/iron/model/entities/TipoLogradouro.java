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
@Table (name = "tipologradouro")
public class TipoLogradouro implements Serializable {
    
       private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue
    @Column(name="IdLogradouro",nullable = false)  
    private Integer idLogradouro;
    @Column(name = "Nome",nullable = false,length = 80)
    private String  nome;

    @OneToMany(mappedBy = "tipologradouro",fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouross")
    private List<Endereco> enderecos;
    public TipoLogradouro() {
    }

    public Integer getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Integer idLogradouro) {
        this.idLogradouro = idLogradouro;
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
        int hash = 7;
        hash = 29 * hash + (this.idLogradouro != null ? this.idLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        return true;
    }
    
    
}
