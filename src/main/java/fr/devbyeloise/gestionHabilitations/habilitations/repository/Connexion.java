package fr.devbyeloise.gestionHabilitations.habilitations.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Connexion {
    public static void main(String... args){
        Connection conn = null;
        try {
        	
        	MysqlDataSource dataSource = new MysqlDataSource();
//        	dataSource.setUrl("jdbc:mysql://localhost:3306/habilitations?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
        	dataSource.setServerName("localhost");
        	dataSource.setPort(3306);
        	dataSource.setDatabaseName("habilitations");
        	dataSource.setUseSSL(false);
        	dataSource.setUser("root");
        	dataSource.setPassword("biBip");
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
            System.out.println("success");
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

