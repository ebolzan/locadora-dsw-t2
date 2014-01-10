/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.locacao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import model.cliente.Clientes;
import model.midia.Midias;

/**
 *
 * @author evandro
 */
@Entity
@Table(name = "locacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacoes.findAll", query = "SELECT l FROM Locacoes l"),
    @NamedQuery(name = "Locacoes.findById", query = "SELECT l FROM Locacoes l WHERE l.id = :id"),
    @NamedQuery(name = "Locacoes.findByDataEmprestimo", query = "SELECT l FROM Locacoes l WHERE l.dataEmprestimo = :dataEmprestimo"),
    @NamedQuery(name = "Locacoes.findByHoraEmprestimo", query = "SELECT l FROM Locacoes l WHERE l.horaEmprestimo = :horaEmprestimo"),
    @NamedQuery(name = "Locacoes.findByDataDevolucao", query = "SELECT l FROM Locacoes l WHERE l.dataDevolucao = :dataDevolucao")})
public class Locacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_emprestimo")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    @Column(name = "hora_emprestimo")
    private String horaEmprestimo;
    @Column(name = "data_devolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Lob
    @Column(name = "obs")
    private String obs;
    @JoinColumn(name = "midias_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Midias midiasId;
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes clientesId;

    public Locacoes() {
    }

    public Locacoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Midias getMidiasId() {
        return midiasId;
    }

    public void setMidiasId(Midias midiasId) {
        this.midiasId = midiasId;
    }

    public Clientes getClientesId() {
        return clientesId;
    }

    public void setClientesId(Clientes clientesId) {
        this.clientesId = clientesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacoes)) {
            return false;
        }
        Locacoes other = (Locacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Locacoes[ id=" + id + " ]";
    }
    
}
