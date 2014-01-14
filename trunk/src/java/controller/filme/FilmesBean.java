/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.filme;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    //categoria dao para listar todas as categorias
    private CategoriasDAO categoriasDao = new CategoriasDAO();
        
    private FilmesDAO filmes;    
    
    private String categoriaInput; 
    private String descricao;
    private Date ano;
    private Categorias categorias;
    private Boolean editavel;        
    
    //static var para inserir objetos
    private static Map<String,Categorias> categoriasValue;
    static{
      categoriasValue = new LinkedHashMap<String,Categorias>();    
    }

    public Map<String,Categorias> getCategoriasValue() {
    return categoriasValue;
    }

    public String getCategoriaInput() {
        return categoriaInput;
    }

    public void setCategoriaInput(String categoriaInput) {
        this.categoriaInput = categoriaInput;
    }            
    
    public List<Categorias> getCategoriasDao()
    {
        for(Categorias cat : categoriasDao.lista())
        {
            //label, value
        categoriasValue.put(cat.getDescricao(), cat);         
        }
        return categoriasDao.lista();
    }
    

    public FilmesBean() {        
        this.filmes = new FilmesDAO();                
        
        //cria hash de categorias
            for(Categorias cat : categoriasDao.lista())
            {
                //label, value
                categoriasValue.put(cat.getDescricao(), cat);                         
            }                
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
        //Date lancamento = new Date(ano);
        Categorias c1 = this.categoriasDao.getCategoriaByName(this.getCategoriaInput());
        Filmes filme = new Filmes(Integer.SIZE, descricao, ano, c1);
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