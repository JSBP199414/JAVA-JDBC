package test;

import datos.Conexion;
import datos.IPersonaDAO;
import datos.PersonaDAOJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
            }
            IPersonaDAO personaDAO = new PersonaDAOJDBC(conexion);
            
           List<PersonaDTO> personas = personaDAO.seleccionar();
            for (PersonaDTO persona:personas) {
                System.out.println("Persona DTO: " + persona); 
            }  
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }


    }

}
