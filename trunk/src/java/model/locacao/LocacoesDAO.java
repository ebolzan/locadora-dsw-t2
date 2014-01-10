/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.locacao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author evandro
 */
public class LocacoesDAO implements InterfaceLocacoes{
 
     
    @Override
    public void salvar(Locacoes locacoes) {               
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.save(locacoes);        
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
    public void excluir(Locacoes locacoes) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.delete(locacoes);        
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
    public void atualizar(Locacoes locacoes) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.update(locacoes);
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
    public Locacoes carregar(Integer codigo) {
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            Locacoes cat = (Locacoes) session.get(Locacoes.class, codigo);            
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
    public List<Locacoes> lista() {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();                    
            List<Locacoes> lista =  session.createQuery("from Locacoes").list();            
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
