/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Vendedor;
import java.util.Date;
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
public class VendedorController {
    public void guardarVendedor(Vendedor vendedor){
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
        sessionAcceso.save(vendedor);
        transaction.commit();  
    }
    public List<Vendedor> listarVendedor(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Vendedor> listaVendedores = sessionAcceso.createCriteria(Vendedor.class ).list();
//        CriteriaQuery<Marca> criteriaQuery = builder.createQuery(Marca.class);
//        criteriaQuery.fr
//        List<Marca> marcas =  sessionAcceso.createQuery(criteriaQuery).list();
        //session.close();
        return listaVendedores;
    }
    
    public void editar(String personaid, String nombre, String apellido,String dni,String telefono,String direccion,
            String ciudad,String codigoPostal,String emailVentas, Date fechaNacimiento, String legajo, String telefonoVentas){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryPersona= sessionAcceso.createSQLQuery("UPDATE public.persona SET nombre='"+nombre+"',"+ 
                " apellido='"+apellido+"',"+ " dni='"+dni+"',"+ " telefono='"+telefono+"',"+ " direccion='"+direccion+"',"
                + " codpostal='"+codigoPostal+"',"+ " ciudad='"+ciudad+"',"+ " fechanacimiento='"+fechaNacimiento
                        +"' WHERE personaid ="+personaid);
        Query queryVendedor= sessionAcceso.createSQLQuery("UPDATE public.vendedor SET email_ventas='"+emailVentas+"',"
                + " legajo='"+legajo+"',"+ " telefono_ventas='"+telefonoVentas+"' WHERE personaid ="+personaid);
        queryPersona.executeUpdate();
        queryVendedor.executeUpdate();
        transaction.commit();
    }
    public void eliminarVendedor(String id ){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryVendedor= sessionAcceso.createSQLQuery("Delete from public.vendedor WHERE personaid ="+id);
        Query queryPersona= sessionAcceso.createSQLQuery("Delete from public.persona WHERE personaid ="+id);
        queryVendedor.executeUpdate();
        queryPersona.executeUpdate();
        transaction.commit();     
        //sessionAcceso.close();
       // session.close();
    }
}
