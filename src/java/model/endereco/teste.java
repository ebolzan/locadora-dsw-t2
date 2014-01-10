/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.endereco;

import java.util.List;
import model.cliente.Clientes;
import model.cliente.ClientesDAO;

/**
 *
 * @author evandro
 */
public class teste {
    
    public static void main(String args[])
    {
        
        EnderecosDAO enderecosDao = new EnderecosDAO();        
        
        List<Enderecos> end = enderecosDao.lista();
        
        for(Enderecos aux: end)
        {
            System.out.println(aux.getCidade());
        }
        
        
        
    }
    
}
