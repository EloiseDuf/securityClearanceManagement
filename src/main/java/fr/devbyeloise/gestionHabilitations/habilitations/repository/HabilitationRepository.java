package fr.devbyeloise.gestionHabilitations.habilitations.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.devbyeloise.gestionHabilitations.habilitations.DataSourceProvider;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;

public class HabilitationRepository {
	
	public List<Habilitation> getAllHabilitations(){
        Connection conn = null;
        List<Habilitation> habilitations = new ArrayList<Habilitation>();
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT ID, NAME, DURATION, THEMES_ID FROM HABILITATIONS";
            
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {         	
            	Habilitation habilitation = new Habilitation();
            	habilitation.setName(rs.getString("NAME"));
            	habilitation.setFrequency(rs.getInt("DURATION"));
            	habilitations.add(habilitation);    	
            }
            rs.close();
            statement.close();            
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
		return habilitations;
	}
	
	public Habilitation getHabilitationById(long id) {

        Connection conn = null;
        Habilitation habilitation = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT ID, NAME, DURATION, THEMES_ID FROM HABILITATIONS WHERE ID = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            if(rs.next()) {   
            	habilitation=new Habilitation();
            	habilitation.setId(rs.getLong("ID"));
            	habilitation.setName(rs.getString("NAME"));
            	habilitation.setFrequency(rs.getInt("DURATION"));
            	habilitation.setSubdomain(rs.getInt("THEMES_ID"));
            } 
            rs.close();
            preparedStatement.close();            
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
		return habilitation;
	}
	
	public void updateHabilitation(Habilitation habilitation) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "UPDATE HABILITATIONS SET NAME=?, DURATION=?, THEMES_ID= ? WHERE ID = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	preparedStatement.setString(1,habilitation.getName());
        	preparedStatement.setInt(2,habilitation.getFrequency());
        	preparedStatement.setInt(3,habilitation.getSubdomain());
        	preparedStatement.setLong(4,habilitation.getId());
           
            preparedStatement.executeUpdate();

            preparedStatement.close();            
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

	public void createHabilitation (Habilitation habilitation) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
            String sql = "INSERT INTO HABILITATIONS (NAME, DURATION, THEMES_ID) VALUES (?,?,?)";
        	
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
      
            preparedStatement.setString(1,habilitation.getName());
            preparedStatement.setInt(2,habilitation.getFrequency());
            preparedStatement.setInt(3,habilitation.getSubdomain());

            
            preparedStatement.executeUpdate();
            

            System.out.println("Habilitation créee");
            
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
	
	public void deleteHabilitation(long id){
        Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "DELETE FROM HABILITATIONS WHERE ID = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	preparedStatement.setLong(1,id);
           
            preparedStatement.executeUpdate();
       
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