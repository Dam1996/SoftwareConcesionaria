/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Automovil;
import entidades.Venta;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author damia
 */
public class VentaController {
     public void guardarVenta(Venta venta){
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
        sessionAcceso.save(venta);
        transaction.commit();  
    }
     public List<Venta> listarVenta(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Venta> lista = sessionAcceso.createCriteria(Venta.class ).list();
        return lista;
    }
}
