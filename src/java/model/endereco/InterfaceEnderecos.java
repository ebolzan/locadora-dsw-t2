/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.endereco;

import java.util.List;

/**
 *
 * @author evandro
 */
public interface InterfaceEnderecos {
    public void salvar(Enderecos enderecos);
    public void excluir(Enderecos enderecos);
    public void atualizar(Enderecos enderecos);
    public Enderecos carregar(Integer codigo);
    public List<Enderecos> lista();   
}
