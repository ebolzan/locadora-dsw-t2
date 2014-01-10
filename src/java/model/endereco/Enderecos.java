/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.endereco;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.cliente.Clientes;

/**
 *
 * @author evandro
 */
@Entity
@Table(name = "enderecos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e"),
    @NamedQuery(name = "Enderecos.findByRua", query = "SELECT e FROM Enderecos e WHERE e.rua = :rua"),
    @NamedQuery(name = "Enderecos.findByNumero", query = "SELECT e FROM Enderecos e WHERE e.numero = :numero"),
    @NamedQuery(name = "Enderecos.findByBairro", query = "SELECT e FROM Enderecos e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Enderecos.findByCidade", query = "SELECT e FROM Enderecos e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Enderecos.findByEstado", query = "SELECT e FROM Enderecos e WHERE e.estado = :estado"),
    @NamedQuery(name = "Enderecos.findByCep", query = "SELECT e FROM Enderecos e WHERE e.cep = :cep"),
    @NamedQuery(name = "Enderecos.findByClientesId", query = "SELECT e FROM Enderecos e WHERE e.clientesId = :clientesId")})
public class Enderecos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;
    @Lob
    @Column(name = "complemento")
    private String complemento;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clientes_id")
    private Integer clientesId;
    @JoinColumn(name = "clientes_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Clientes clientes;

    public Enderecos() {
    }

    public Enderecos(Integer clientesId) {
        this.clientesId = clientesId;
    }

    public Enderecos(Integer clientesId, String rua, String cidade, String estado, String cep) {
        this.clientesId = clientesId;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
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

    public Integer getClientesId() {
        return clientesId;
    }

    public void setClientesId(Integer clientesId) {
        this.clientesId = clientesId;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientesId != null ? clientesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.clientesId == null && other.clientesId != null) || (this.clientesId != null && !this.clientesId.equals(other.clientesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Enderecos[ clientesId=" + clientesId + " ]";
    }
    
}
