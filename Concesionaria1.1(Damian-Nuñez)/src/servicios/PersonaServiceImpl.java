/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controlador.factoriaSesionesHibernateUtil;
import entidades.Persona;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Alejandro
 */
public class PersonaServiceImpl implements PersonaService {

    @Override
    public Persona getPersonaById(int id) {
         Persona persona = new Persona();
         SessionFactory session = factoriaSesionesHibernateUtil.getSessionFactory();
         Session sessionAcceso = session.openSession();
         
         Transaction transaction = sessionAcceso.beginTransaction();
         CriteriaQuery<Persona> query = (CriteriaQuery<Persona>) sessionAcceso.createSQLQuery("Select * from persona where id= " + id );
        
         
        return persona;
        
    }
    
    public Persona getPersonaByDni(String dni){
        Persona persona = new Persona();
        return persona;
    }
    
    
}
