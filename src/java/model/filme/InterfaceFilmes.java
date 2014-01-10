/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.filme;

import java.util.List;

/**
 *
 * @author evandro
 */
public interface InterfaceFilmes {
    
    public void salvar(Filmes enderecos);
    public void excluir(Filmes enderecos);
    public void atualizar(Filmes enderecos);
    public Filmes carregar(Integer codigo);
    public List<Filmes> lista();   
    
}
