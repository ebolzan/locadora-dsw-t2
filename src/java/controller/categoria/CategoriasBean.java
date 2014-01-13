/**
 * 
 */

package controller.categoria;

import java.io.Serializable;
import java.util.ArrayList;
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
    
    private final CategoriasDAO categoriaDao;
    private String descricao;        
    private Categorias cat;
    private Boolean editavel;        
    
    public CategoriasBean()
    {
        categoriaDao = new CategoriasDAO();
        //cat = categorias.carregar(2);
    }        

    public Boolean getEditavel() {
        return editavel;
    }

    public void setEditavel(Boolean editavel) {
        this.editavel = editavel;
    }   
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public ArrayList<Categorias> getCategorias()
    {
        return categoriaDao.lista();
    }
    
    public Categorias getCat() {
        return cat;
    }

    public void setCat(Categorias cat) {
        this.cat = cat;
    }
    
    public String addAction()
    {   
        Categorias c1 = new Categorias(Integer.SIZE, descricao);
        categoriaDao.salvar(c1);
        
        return null;
    }
    
    public String deleteAction(Categorias categorias)
    {
        categoriaDao.excluir(categorias);
        return null;
    }
    
    public String updateAction(Categorias categorias)
    {
        categoriaDao.atualizar(categorias);
        return null;
    }
    
     public String editAction(Categorias cat) {
	cat.setEditavel(true);
	return null;
    }
     
   public String saveAction()  
   {
       for(Categorias cat2 : this.getCategorias())
       {           
           this.categoriaDao.atualizar(cat2);
           cat2.setEditavel(false);           
       }
       
       return null;
   }
}