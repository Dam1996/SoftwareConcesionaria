/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import entidades.Marca;
//import entidades.Usuario;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author Alejandro
 */
public class MarcaController {  
    public void editarMarca(String marcaid, String nombre, String paisDeOrigen){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query query= sessionAcceso.createSQLQuery("UPDATE public.marca SET nombre='"+nombre+"',"
                + " paisdeorigen='"+paisDeOrigen+"' WHERE marcaid ="+marcaid);
        query.executeUpdate();
        transaction.commit();
    }
    public void guardarMarca(String nombre, String paisDeOrigen){
            /*Creamos el objeto a persistir*/
        Marca marca = new Marca(nombre, paisDeOrigen);
        // SessionFactory session para conectarnos por medio de Hibernate a la DB
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();   
        /* 
            uso beginTransanction() para obtener acceso a standard transaction API <code>UserTransaction</code> y
            begin a transaction on this thread of execution.
        */
        Transaction transaction = sessionAcceso.beginTransaction();
        sessionAcceso.save(marca);
        transaction.commit();  
    }
    public void eliminarMarca(String id ){
            /*Creamos el objeto a persistir*/
//        Marca marca = new Marca(Long.parseLong(id), nombre, paisDeOrigen);
//        // SessionFactory session para conectarnos por medio de Hibernate a la DB
//        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
//        SessionFactory session = factoriaUtil.getSessionFactory();// conectamos hibernate con postgres
//        Session sessionAcceso = session.openSession();
//        Transaction transaction = sessionAcceso.beginTransaction();
//        sessionAcceso.delete(marca);
//        transaction.commit();    
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query query= sessionAcceso.createSQLQuery("Delete from public.marca WHERE marcaid ="+id);
        query.executeUpdate();
        transaction.commit();     
        //sessionAcceso.close();
       // session.close();
    }
    
    public List<Marca> listarMarcas(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Marca> listaMarca = sessionAcceso.createCriteria(Marca.class ).list();
//        CriteriaQuery<Marca> criteriaQuery = builder.createQuery(Marca.class);
//        criteriaQuery.fr
//        List<Marca> marcas =  sessionAcceso.createQuery(criteriaQuery).list();
        //session.close();
        return listaMarca;
    }
//     public Boolean validarUsuario(){
//        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
//        Session sessionAcceso = session.openSession();
//        Transaction transaction = sessionAcceso.beginTransaction();
//        sessionAcceso.createSQLQuery("Select * from usuario where"+ " username=" + "ale" + " and password = " + "contrasenia"  );
//    } 
    
//    public Marca buscarMarca(String marca){
//        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
//        Session sessionAcceso = session.openSession();
//        Transaction transaction = sessionAcceso.beginTransaction();
//        //sessionAcceso.createQuery(marca, type)
//    }
    
}
