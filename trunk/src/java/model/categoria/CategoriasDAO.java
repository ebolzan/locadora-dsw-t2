package model.categoria;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author evandro
 */
public class CategoriasDAO implements InterfaceCategorias {

    @Override
    public void salvar(Categorias categorias) {               
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.save(categorias);        
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
    public void excluir(Categorias categorias) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.delete(categorias);        
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
    public void atualizar(Categorias categorias) {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            session.update(categorias);
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
    public Categorias carregar(Integer codigo) {
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();        
            Categorias cat = (Categorias) session.get(Categorias.class, codigo);            
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
    public List<Categorias> lista() {
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {                   
            session = hibernate.util.HibernateUtil.getSessionFactory().openSession();        
            transaction = session.beginTransaction();
            transaction.begin();                    
            List<Categorias> lista =  session.createQuery("from Categorias").list();            
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
