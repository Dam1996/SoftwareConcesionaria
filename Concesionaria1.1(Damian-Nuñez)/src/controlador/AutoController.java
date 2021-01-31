/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Auto;
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
public class AutoController {
    public void guardarAuto(Auto auto){
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
        sessionAcceso.save(auto);
        transaction.commit();  
    }
    public List<Auto> listarAuto(){
        SessionFactory session = factoriaSesionesHibernateUtilOLd.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        CriteriaBuilder builder = sessionAcceso.getCriteriaBuilder();
        List<Auto> listaAuto = sessionAcceso.createCriteria(Auto.class ).list();
        return listaAuto;
    }
    public void editar(String autoId,Integer chasi, String precio,String patente ,Long automovilid, String km){
        factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
        SessionFactory session = factoriaUtil.getSessionFactory();
        Session sessionAcceso = session.openSession();
        Transaction transaction = sessionAcceso.beginTransaction();
        Query queryAuto= sessionAcceso.createSQLQuery("UPDATE public.auto SET numerochasis='"+chasi+"',"
                + " precioventa='"+precio+"',"+ " patente='"+patente+"',"+ " automovil_id='"+automovilid+"',"+ " escerokm='"+km+"' WHERE autoid ="+autoId);
        queryAuto.executeUpdate();
        transaction.commit();
    }
}
