/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.cliente;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.cliente.Clientes;
import model.cliente.ClientesDAO;

/**
 *
 * @author evandro
 */
@Named
@SessionScoped
public class ClientesBean implements Serializable{
    
    private ClientesDAO clienteDao;
    
    private String nome;
    private String telefone;
    private String celular;
    private String email;

    public ClientesBean() {
        this.clienteDao = new ClientesDAO();
    }

    public ClientesDAO getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClientesDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Clientes> getClientesList()
    {
        return this.clienteDao.lista();
    }
    
    public String deleteAction(Clientes clientes)
    {
        this.clienteDao.excluir(clientes);
        return null;
    }
    
    public String addAction()
    {
        Clientes c1 = new Clientes(Integer.SIZE, nome, telefone, email);
         
        if(celular != null)
            c1.setCelular(celular);
        
        clienteDao.salvar(c1);
        return null;
    }
        
    public String updateAction(Clientes clientes)
    {
        this.clienteDao.atualizar(clientes);
        return null;
    }    
}
