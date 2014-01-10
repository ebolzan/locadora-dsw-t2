/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.endereco;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.endereco.Enderecos;
import model.endereco.EnderecosDAO;

/**
 *
 * @author evandro
 */
@Named
@SessionScoped
public class EnderecosBean implements Serializable {
    
    private EnderecosDAO enderecoDao;
    
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;

    public EnderecosBean() {
        this.enderecoDao = new EnderecosDAO();
    }

    public EnderecosDAO getEnderecoDao() {
        return enderecoDao;
    }

    public void setEnderecoDao(EnderecosDAO enderecoDao) {
        this.enderecoDao = enderecoDao;
    }       
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    /**
     * @return lista de enderecos do banco de dados
     *         
    */
    public List<Enderecos> getEnderecos()
    {
        return this.enderecoDao.lista();
    }
    
    public String addAction()
    {
        
        return null;
    }
    
    public String editAction(Enderecos enderecos)
    {
        return null;
    }
    
    public String deleteAction(Enderecos enderecos)
    {
        return null;
    }
    
    public String updateAction()
    {
        return null;        
    }        
    
}
