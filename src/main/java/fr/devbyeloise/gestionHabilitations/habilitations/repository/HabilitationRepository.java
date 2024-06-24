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
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Theme;

public class HabilitationRepository {
	
	public List<Habilitation> getAllHabilitations(){
        Connection conn = null;
        List<Habilitation> habilitations = new ArrayList<Habilitation>();
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT h.id, h.name, duration, t.id, t.name FROM HABILITATIONS h "
        			+ "join themes t on t.id = h.themes_id";
        	
    
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
            	Long habilitationId = rs.getLong("h.id");
            	String habilitationName=rs.getString("h.name");
            	int frequency = rs.getInt("duration");
            	
            	int themeId = rs.getInt("t.id");
            	String themeName = rs.getString("t.name");
            	
            	Theme theme = new Theme(themeId,themeName);
            	
            	Habilitation habilitation = new Habilitation(habilitationId, habilitationName, frequency, theme);
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
        	
        	String sql = "SELECT h.id, h.name, duration, t.id, t.name FROM HABILITATIONS h "
        			+ "JOIN themes t on t.id = h.themes_id "
        			+ "WHERE h.id = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            if(rs.next()) {  
            	long habilitationId=rs.getLong("ID");
            	String habilitationName=rs.getString("NAME");
            	int frequency = rs.getInt("DURATION");
            	int themeId = rs.getInt("t.id");
            	String themeName = rs.getString("t.name");
            	
            	Theme theme =new Theme(themeId, themeName);
            	
            	habilitation =new Habilitation(habilitationId, habilitationName, frequency, theme);
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
	
	public void updateHabilitation(Habilitation habilitation, Theme theme) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "UPDATE HABILITATIONS SET NAME=?, DURATION=?, THEMES_ID= ? WHERE ID = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	preparedStatement.setString(1,habilitation.getName());
        	preparedStatement.setInt(2,habilitation.getFrequency());
        	preparedStatement.setInt(3,theme.getId());
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

	public void createHabilitation (Habilitation habilitation, Theme theme) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
            String sql = "INSERT INTO HABILITATIONS (NAME, DURATION, THEMES_ID) VALUES (?,?,?)";
        	
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
      
            preparedStatement.setString(1,habilitation.getName());
            preparedStatement.setInt(2,habilitation.getFrequency());
            preparedStatement.setInt(3,theme.getId());

            
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