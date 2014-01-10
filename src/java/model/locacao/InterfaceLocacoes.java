/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.locacao;

import java.util.List;

/**
 *
 * @author evandro
 */
public interface InterfaceLocacoes {
    
    public void salvar(Locacoes enderecos);
    public void excluir(Locacoes enderecos);
    public void atualizar(Locacoes enderecos);
    public Locacoes carregar(Integer codigo);
    public List<Locacoes> lista();   
    
}
