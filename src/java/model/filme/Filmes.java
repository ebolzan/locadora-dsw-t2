/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.filme;

/**
 *
 * @author evandro
 */

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import model.categoria.Categorias;
import org.hibernate.annotations.Type;

/**
 *
 * @author evandro
 */

@Entity
@Table(name = "filmes")
public class Filmes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
        
    @Column(name = "descricao")
    private String descricao;  
    
    @Temporal(TemporalType.DATE)
    @Column(name = "ano")
    private Date ano;
    
    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categorias categorias;
    
    @Transient
    private Boolean editavel = false;

    public Filmes(){}
    
    public Filmes(Integer id, String descricao, Date ano, Categorias categorias) {
        this.id = id;
        this.descricao = descricao;
        this.ano = ano;
        this.categorias = categorias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }   
    
    public Boolean getEditavel() {
        return editavel;
    }

    public void setEditavel(Boolean editavel) {
        this.editavel = editavel;
    }

    @Override
    public String toString() {
        return descricao;
    }            
    
            
}
