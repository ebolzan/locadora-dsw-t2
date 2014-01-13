/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.categoria;

import java.util.List;

/**
 *
 * @author evandro
 */
public class teste {
    
    public static void main(String[] args)
    {
        
        /*
        Categorias cat = new Categorias();
        cat.setId(3);
        cat.setDescricao("Django livre");
                
        */
        
        CategoriasDAO catDAO =  new CategoriasDAO();
        
        /*
        Categorias cat = catDAO.carregar(2);
        cat.setDescricao("Romance atualizado");
        catDAO.atualizar(cat);        
                
        */
        
        Categorias cat = new Categorias();
        cat = catDAO.getCategoriaByName("Drama");
        
        System.out.print(cat);
                
        
    }
    
}
