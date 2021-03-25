/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import entidades.Modelo;
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
public class ModeloController {  
    public void editar(String modeloid, String marca, String nombre){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query query= sessionAcceso.createSQLQuery("UPDATE public.modelo SET marca='"+marca+"',"
                + " nombre='"+nombre+"' WHERE modeloid ="+modeloid);
        query.executeUpdate();
        transaction.commit();
    }
    public void guardar(String marca, String nombre){
            /*Creamos el objeto a persistir*/
        Modelo modelo = new Modelo(marca, nombre);
        // SessionFactory session para conectarnos por medio de Hibernate a la DB
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();   
        /* 
            uso beginTransanction() para obtener acceso a standard transaction API <code>UserTransaction</code> y
            begin a transaction on this thread of execution.
        */
        Transaction transaction = sessionAcceso.beginTransaction();
        sessionAcceso.save(modelo);
        transaction.commit();  
    }
    public void eliminar(String id ){
            /*Creamos el objeto a persistir*/
//        Modelo marca = new Modelo(Long.parseLong(id), nombre, paisDeOrigen);
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
        Query query= sessionAcceso.createSQLQuery("Delete from public.modelo WHERE modeloid ="+id);
        query.executeUpdate();
        transaction.commit();     
        //sessionAcceso.close();
       // session.close();
    }
    
    public List<Modelo> listarModelos(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Modelo> listaModelo = sessionAcceso.createCriteria(Modelo.class ).list();
//        CriteriaQuery<Marca> criteriaQuery = builder.createQuery(Modelo.class);
//        criteriaQuery.fr
//        List<Marca> marcas =  sessionAcceso.createQuery(criteriaQuery).list();
        //session.close();
        return listaModelo;
    }
//     public Boolean validarUsuario(){
//        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
//        Session sessionAcceso = session.openSession();
//        Transaction transaction = sessionAcceso.beginTransaction();
//        sessionAcceso.createSQLQuery("Select * from usuario where"+ " username=" + "ale" + " and password = " + "contrasenia"  );
//    } 
    
//    public Modelo buscarMarca(String marca){
//        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
//        Session sessionAcceso = session.openSession();
//        Transaction transaction = sessionAcceso.beginTransaction();
//        //sessionAcceso.createQuery(marca, type)
//    }
    
}
