/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.cliente;

import model.endereco.Enderecos;
import model.endereco.EnderecosDAO;

/**
 *
 * @author evandro
 */
public class teste {
 
    public static void main(String args[])
    {
        ClientesDAO clientesDao = new ClientesDAO();
        Clientes clientes = new Clientes(new Integer(31),"Edu","55", "edu@gmail.com");
        clientes.setCelular("999");                                               
        clientesDao.salvar(clientes);
                
       // EnderecosDAO enderecoDao = new EnderecosDAO();
        //Enderecos enderecos = new Enderecos(clientes.getId(),"Av rodolfo behr", "Santa Maria", "RS", "97105440");
        //enderecoDao.salvar(enderecos);                
        
        
    }
    
}
