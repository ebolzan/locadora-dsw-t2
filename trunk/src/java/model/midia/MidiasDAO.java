/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.midia;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author evandro
 */
public class MidiasDAO implements InterfaceMidias{
    
     @Override
    public void salvar(Midias midias) {               
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.save(midias);        
            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
                transaction.rollback();
            
            ex.printStackTrace();
        } 
        finally
        {
            session.close();
        }
    }

    @Override
    public void excluir(Midias midias) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.delete(midias);        
            transaction.commit();
            
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
                transaction.rollback();
            
            ex.printStackTrace();                        
        } 
        finally
        {
            session.close();
        }                
    }

    @Override
    public void atualizar(Midias midias) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.update(midias);
            transaction.commit();                                    
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
                transaction.rollback();
            
            ex.printStackTrace();
        } 
        finally
        {
            session.close();     
        }                        
    }

    @Override
    public Midias carregar(Integer codigo) {
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            Midias cat = (Midias) session.get(Midias.class, codigo);            
            transaction.commit();
                        
            return cat;
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
                transaction.rollback();
            ex.printStackTrace();
        } 
        finally
        {
            session.close();     
        }
        
        return null;
    }

    @Override
    public List<Midias> lista() {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();                    
            List<Midias> lista =  session.createQuery("from Midias").list();            
            transaction.commit();
                        
            return lista;
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
                transaction.rollback();
            
            ex.printStackTrace();
        } 
        finally
        {
            session.close();     
        }
                
        return null;                        
    }
    
}
