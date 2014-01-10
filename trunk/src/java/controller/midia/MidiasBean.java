/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.midia;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.filme.Filmes;
import model.midia.Midias;
import model.midia.MidiasDAO;

/**
 *
 * @author evandro
 */
@Named
@SessionScoped
public class MidiasBean implements Serializable{
    
    private MidiasDAO midiasDao;    
    private char inutilizada;
    private Filmes filmes;

    public MidiasBean() {
        this.midiasDao = new MidiasDAO();
    }

    public MidiasDAO getMidiasDao() {
        return midiasDao;
    }

    public void setMidiasDao(MidiasDAO midiasDao) {
        this.midiasDao = midiasDao;
    }

    public char getInutilizada() {
        return inutilizada;
    }

    public void setInutilizada(char inutilizada) {
        this.inutilizada = inutilizada;
    }

    public Filmes getFilmes() {
        return filmes;
    }

    public void setFilmes(Filmes filmes) {
        this.filmes = filmes;
    }
            
    public List<Midias> getMidiasList()
    {
        return this.midiasDao.lista();
    }
    
    public String addAction()
    {
        Midias m1 = new Midias(Integer.SIZE);
        midiasDao.salvar(m1);        
        return null;
    }
    
    public String deleteAction(Midias m1)
    {
        midiasDao.excluir(m1);
        return null;
    }        
    
    public String updateAction(Midias m1)
    {
        midiasDao.atualizar(m1);
        return null;
    }       
}