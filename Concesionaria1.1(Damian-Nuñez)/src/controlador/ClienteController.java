/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Cliente;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author damia
 */
public class ClienteController {
    public List<Cliente> listarClientes(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Cliente> listaClientes = sessionAcceso.createCriteria(Cliente.class ).list();
//        CriteriaQuery<Marca> criteriaQuery = builder.createQuery(Marca.class);
//        criteriaQuery.fr
//        List<Marca> marcas =  sessionAcceso.createQuery(criteriaQuery).list();
        //session.close();
        return listaClientes;
    }
    public void guardarCliente(Cliente cliente){
            /*Creamos el objeto a persistir*/
        // SessionFactory session para conectarnos por medio de Hibernate a la DB
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();   
        /* 
            uso beginTransanction() para obtener acceso a standard transaction API <code>UserTransaction</code> y
            begin a transaction on this thread of execution.
        */
        Transaction transaction = sessionAcceso.beginTransaction();
        sessionAcceso.save(cliente);
        transaction.commit();  
    }
    public void editar(String personaid, String nombre, String apellido,String dni,String telefono,String direccion,
            String ciudad,String codigoPostal,String email, Date fechaNacimiento, Date fechaAlta){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryPersona= sessionAcceso.createSQLQuery("UPDATE public.persona SET nombre='"+nombre+"',"+ 
                " apellido='"+apellido+"',"+ " dni='"+dni+"',"+ " telefono='"+telefono+"',"+ " direccion='"+direccion+"',"
                + " codpostal='"+codigoPostal+"',"+ " ciudad='"+ciudad+"',"+ " fechanacimiento='"+fechaNacimiento
                        +"' WHERE personaid ="+personaid);
        Query queryCliente= sessionAcceso.createSQLQuery("UPDATE public.cliente SET email='"+email+"',"
                + " fechaalta='"+fechaAlta+"' WHERE persona_id ="+personaid);
        queryPersona.executeUpdate();
        queryCliente.executeUpdate();
        transaction.commit();
    }
     public void eliminarCliente(String id ){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryCliente= sessionAcceso.createSQLQuery("Delete from public.cliente WHERE persona_id ="+id);
        Query queryPersona= sessionAcceso.createSQLQuery("Delete from public.persona WHERE personaid ="+id);
        queryCliente.executeUpdate();
        queryPersona.executeUpdate();
        transaction.commit();     
        //sessionAcceso.close();
       // session.close();
    }
}
