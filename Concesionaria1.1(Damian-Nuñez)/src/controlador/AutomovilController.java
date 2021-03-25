/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Automovil;
import entidades.Modelo;
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
public class AutomovilController {
    public void guardarAutomovil(Automovil automovil){
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
        sessionAcceso.save(automovil);
        transaction.commit();  
    }
    public List<Automovil> listarAutomovil(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Automovil> listaAutomoviles = sessionAcceso.createCriteria(Automovil.class ).list();
        return listaAutomoviles;
    }
    public void editar(String automovilid, String precio, String color,String anio,long modelo, String km, String stock){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryAutomovil= sessionAcceso.createSQLQuery("UPDATE public.automovil SET precio='"+precio+"',"
                + " color='"+color+"',"+ " aniofabricacion='"+anio+"',"+ " modelo_id='"+modelo+"',"+ "km='"+km+"',"+ "stock='"+stock+"' WHERE automovilid ="+automovilid);
        queryAutomovil.executeUpdate();
        transaction.commit();
    }
    public void eliminarAutomovil(String id ){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryAutomovil= sessionAcceso.createSQLQuery("Delete from public.automovil WHERE automovilid ="+id);
        queryAutomovil.executeUpdate();
        transaction.commit();     
        //sessionAcceso.close();
       // session.close();
    }
}
