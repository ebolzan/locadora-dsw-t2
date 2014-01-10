/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.cliente;

import java.util.List;
import model.cliente.Clientes;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author evandro
 */
public class ClientesDAO implements InterfaceClientes{
    
    @Override
    public void salvar(Clientes clientes) {               
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.save(clientes);        
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
    public void excluir(Clientes clientes) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.delete(clientes);        
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
    public void atualizar(Clientes clientes) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.update(clientes);
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
    public Clientes carregar(Integer codigo) {
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            Clientes cat = (Clientes) session.get(Clientes.class, codigo);            
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
    public List<Clientes> lista() {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();                    
            List<Clientes> lista =  session.createQuery("from Clientes").list();            
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
