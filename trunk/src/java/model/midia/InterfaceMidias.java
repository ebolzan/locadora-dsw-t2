/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.midia;

import java.util.List;

/**
 *
 * @author evandro
 */
public interface InterfaceMidias {
    
    public void salvar(Midias enderecos);
    public void excluir(Midias enderecos);
    public void atualizar(Midias enderecos);
    public Midias carregar(Integer codigo);
    public List<Midias> lista();   
    
}
