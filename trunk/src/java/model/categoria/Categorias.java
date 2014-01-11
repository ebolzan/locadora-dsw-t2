/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.categoria;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 *
 * @author evandro
 */
@Entity
@Table(name= "categorias")
public class Categorias implements Serializable{

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Integer id;            
    private String descricao;
    
    @Transient
    private Boolean editavel = true;
    
    public Categorias(){}
    
    public Categorias(Integer id, String descricao)
    {
        this.id        = id;
        this.descricao = descricao;
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
    
    public Boolean getEditavel() {
        return editavel;
    }

    public void setEditavel(Boolean editavel) {
        this.editavel = editavel;
    }
    

    @Override
    public String toString() {
        return "Categorias{" + "id=" + id + ", descricao=" + descricao + '}';
    }   
    
}
