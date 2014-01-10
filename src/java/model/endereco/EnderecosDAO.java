/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.endereco;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author evandro
 */
public class EnderecosDAO implements InterfaceEnderecos{
    
    @Override
    public void salvar(Enderecos enderecos) {               
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.save(enderecos);        
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
    public void excluir(Enderecos enderecos) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.delete(enderecos);        
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
    public void atualizar(Enderecos enderecos) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.update(enderecos);
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
    public Enderecos carregar(Integer codigo) {
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            Enderecos cat = (Enderecos) session.get(Enderecos.class, codigo);            
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
    public List<Enderecos> lista() {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();                    
            List<Enderecos> lista =  session.createQuery("from Enderecos").list();            
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
