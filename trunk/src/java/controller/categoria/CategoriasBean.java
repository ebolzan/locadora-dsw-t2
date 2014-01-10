/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.categoria;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.categoria.Categorias;
import model.categoria.CategoriasDAO;

/**
 *
 * @author evandro
 */

@Named
@SessionScoped
public class CategoriasBean implements Serializable{
    
    private String descricao;
    
    private final CategoriasDAO categorias;
    private Categorias cat;
    
    public CategoriasBean()
    {
        categorias = new CategoriasDAO();
        cat = categorias.carregar(2);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<Categorias> getCategorias()
    {
        return categorias.lista();
    }
    
    public Categorias getCat() {
        return cat;
    }

    public void setCat(Categorias cat) {
        this.cat = cat;
    }
    
}
