package fr.devbyeloise.gestionHabilitations.habilitations.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import fr.devbyeloise.gestionHabilitations.habilitations.DataSourceProvider;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;

public class EmployeeRepository {
	public void readAll (Employee employee){
        Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
            //MySQL driver MySQL Connector
//        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/habilitations?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","biBip");
        
            
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT ID, NAME, FIRSTNAME FROM EMPLOYEE");
            
            while (rs.next()) {
            	final String name = rs.getString("NAME");
            	final String firstname = rs.getString("FIRSTNAME");
            	final long id =rs.getLong("ID");
            	System.out.println( name +" "+ firstname);
            	
            }
            rs.close();
            statement.close();
            System.out.println("Collaborateur affichés");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
