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
public interface InterfaceCategorias {
    
    public void salvar(Categorias categorias);
    public void excluir(Categorias categorias);
    public void atualizar(Categorias categorias);
    public Categorias carregar(Integer codigo);
    public List<Categorias> lista();    
}
