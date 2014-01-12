/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.filme;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.categoria.Categorias;
import model.categoria.CategoriasDAO;
import model.filme.Filmes;
import model.filme.FilmesDAO;

/**
 *
 * @author evandro
 */

@Named
@SessionScoped
public class FilmesBean implements Serializable{
    
    private FilmesDAO filmes;    
        
    private String descricao;
    private Date ano;
    private Categorias categorias;
    private Boolean editavel;        

    public FilmesBean() {        
        this.filmes = new FilmesDAO();                
    }
        
    public FilmesDAO getFilmes() {
        return filmes;
    }

    public void setFilmes(FilmesDAO filmes) {
        this.filmes = filmes;
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
    
    //retorna filmes em list
    public List<Filmes> getFilmesList()
    {
        return this.filmes.lista();
    }
    
    public String addAction()
    {
        Filmes filme = new Filmes(Integer.SIZE, descricao, ano, categorias);
        filmes.salvar(filme);        
        return null;
    }
    
    public String deleteAction(Filmes filme)
    {
        filmes.excluir(filme);
        return null;
    }        
    
    public String updateAction(Filmes filme)
    {
        filmes.atualizar(filme);
        return null;
    }    
    
    public Boolean getEditavel() {
        return editavel;
    }

    public void setEditavel(Boolean editavel) {
        this.editavel = editavel;
    }  
    
    public String saveAction()  {
       for(Filmes filme : this.getFilmesList()) {           
           this.filmes.atualizar(filme);
           filme.setEditavel(false);           
       }       
       return null;
    }
}
