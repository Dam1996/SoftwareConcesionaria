/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Cliente;
import entidades.Persona;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PersonaController {


public void guardarPersona(Persona persona){
   factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd(); 
   SessionFactory session = factoriaUtil.getSessionFactory();
    Session sessionAcceso =session.openSession();
    Transaction transaction = sessionAcceso.beginTransaction();
    sessionAcceso.save(persona);
    transaction.commit();
}    

public void guardarCliente(Cliente cliente){
    factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
    SessionFactory session = factoriaUtil.getSessionFactory();
    Session sessionAcceso =session.openSession();
    Transaction transaction = sessionAcceso.beginTransaction();
    sessionAcceso.save(cliente);
    transaction.commit();
    
}

public List<Persona> listarPersonas(){
    factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
    SessionFactory session =factoriaUtil.getSessionFactory();
    Session sessionAcceso= session.openSession();
    Transaction transaction = sessionAcceso.beginTransaction();
    CriteriaBuilder builder =sessionAcceso.getCriteriaBuilder();
    List<Persona> listPersona=sessionAcceso.createCriteria(Persona.class).list();
    return listPersona;
}
public List<Cliente> listarClientes(){
    factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
    SessionFactory session =factoriaUtil.getSessionFactory();
    Session sessionAcceso= session.openSession();
    Transaction transaction = sessionAcceso.beginTransaction();
    CriteriaBuilder builder =sessionAcceso.getCriteriaBuilder();
    List<Cliente> listCliente=sessionAcceso.createCriteria(Persona.class).list();
    return listCliente;
}


public Persona getPersona(int id) {
         Persona persona = new Persona();
         factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
         SessionFactory session = factoriaUtil.getSessionFactory();
         Session sessionAcceso = session.openSession();
         Transaction transaction = sessionAcceso.beginTransaction();
         CriteriaQuery<Persona> query = (CriteriaQuery<Persona>) sessionAcceso.createSQLQuery("Select * from persona where id= " + id );
        return persona;
        
}

public void modificarPersona(){
    factoriaSesionesHibernateUtilOLd factoriaUtil = new factoriaSesionesHibernateUtilOLd();
    SessionFactory session = factoriaUtil.getSessionFactory();
    Session sessionAcceso=session.openSession();
    Transaction transaction =sessionAcceso.beginTransaction();
    Query query = sessionAcceso.createQuery("UPDATE public.persona SET nombre=?, apellido=?, dni=?,"
            + " fechanacimiento=?, telefono=?, direccion=?, ciudad=?, codpostal=? WHERE id=");
    query.executeUpdate();
    transaction.commit();
} 
}
