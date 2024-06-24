package fr.devbyeloise.gestionHabilitations.habilitations.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.devbyeloise.gestionHabilitations.habilitations.DataSourceProvider;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.HabilitationEmployee;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Theme;

public class HabilitationEmployeeRepository {

	public List<HabilitationEmployee> getAllEmployeeHabilitations(){
        Connection conn = null;
        List<HabilitationEmployee> habilitationsAllEmployee = new ArrayList<HabilitationEmployee>();
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT emp.name, emp.firstname, emp.company, emp.direction, emp.team, h.name, h.themes_id, t.id, t.name, habEmp.employee_id, habEmp.habilitations_id, habEmp.training_date, habEmp.expiration_date "
        			+ "FROM EMPLOYEE_HABILITATION habEmp "
        			+ "JOIN EMPLOYEE emp ON emp.id = habEmp.employee_id "
        			+ "JOIN HABILITATIONS h ON h.id = habEmp.habilitations_id "
        			+ "JOIN THEMES t ON t.id = h.themes_id";
            
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {  
            	long employeeId=rs.getLong("habEmp.employee_id");
            	String name = rs.getString("emp.name");
            	String firstName = rs.getString("emp.firstname");
            	String company = rs.getString("emp.company");
            	String direction = rs.getString("emp.direction");
            	String team = rs.getString("emp.team");
            	
            	long habilitationId=rs.getLong("habEmp.habilitations_id");
            	String habilitationName=rs.getString("h.name");
            	
            	int themeId= rs.getInt("t.id");
            	String themeName = rs.getString("t.name");
            	
            	LocalDate trainingDate=rs.getDate("habEmp.training_date").toLocalDate();
            	LocalDate expirationDate= rs.getDate("habEmp.expiration_date").toLocalDate();
            	      	
            	Employee employee = new Employee(employeeId, name, firstName, company, direction, team);
            	Theme theme = new Theme (themeId,themeName);
            	Habilitation habilitation = new Habilitation(habilitationId, habilitationName,theme);
            	
            	
            	HabilitationEmployee habilitationEmployee = new HabilitationEmployee(employee, habilitation, trainingDate, expirationDate);
            	

            	habilitationsAllEmployee.add(habilitationEmployee);    	
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
		return habilitationsAllEmployee;
	}
	
	public List<HabilitationEmployee> getHabilitationEmployeeByIdEmployeeWithFullInformations(Long employeeId) {

		Connection conn = null;
        List<HabilitationEmployee> habilitationsEmployee = new ArrayList<HabilitationEmployee>();
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT emp.name, emp.firstname, emp.company, emp.direction, emp.team, h.name, h.themes_id, t.id, t.name, habEmp.employee_id, habEmp.habilitations_id, habEmp.training_date, habEmp.expiration_date "
        			+ "FROM EMPLOYEE_HABILITATION habEmp "
        			+ "JOIN EMPLOYEE emp ON emp.id = habEmp.employee_id "
        			+ "JOIN HABILITATIONS h ON h.id = habEmp.habilitations_id "
        			+ "JOIN THEMES t ON t.id = h.themes_id "
        			+ "WHERE habEmp.employee_id = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	String name = rs.getString("emp.name");
            	String firstName = rs.getString("emp.firstname");
            	String company = rs.getString("emp.company");
            	String direction = rs.getString("emp.direction");
            	String team = rs.getString("emp.team");
            	
            	long habilitationId=rs.getLong("habEmp.habilitations_id");
            	String habilitationName=rs.getString("h.name");
            	
            	int themeId= rs.getInt("t.id");
            	String themeName = rs.getString("t.name");
            	
            	LocalDate trainingDate=rs.getDate("habEmp.training_date").toLocalDate();
            	LocalDate expirationDate= rs.getDate("habEmp.expiration_date").toLocalDate();
            	      	
            	Employee employee = new Employee(employeeId, name, firstName, company, direction, team);
            	Theme theme = new Theme (themeId,themeName);
            	Habilitation habilitation = new Habilitation(habilitationId, habilitationName,theme);
            	
            	
            	HabilitationEmployee habilitationEmployee = new HabilitationEmployee(employee, habilitation, trainingDate, expirationDate);
            	

            	habilitationsEmployee.add(habilitationEmployee);    	
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
		return habilitationsEmployee;
	}
	
	public List<HabilitationEmployee> getHabilitationEmployeeByIdEmployeeWithLessInformations(Long employeeId) {

		Connection conn = null;
        List<HabilitationEmployee> habilitationsEmployee = new ArrayList<HabilitationEmployee>();
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT emp.name, emp.firstname,h.name,t.name,habEmp.training_date, habEmp.expiration_date "
        			+ "FROM EMPLOYEE_HABILITATION habEmp "
        			+ "JOIN EMPLOYEE emp ON emp.id = habEmp.employee_id "
        			+ "JOIN HABILITATIONS h ON h.id = habEmp.habilitations_id "
        			+ "JOIN THEMES t ON t.id = h.themes_id "
        			+ "WHERE habEmp.employee_id = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	String name = rs.getString("emp.name");
            	String firstName = rs.getString("emp.firstname");
            	
            	String habilitationName=rs.getString("h.name");
            	
            	String themeName = rs.getString("t.name");
            	
            	LocalDate trainingDate=rs.getDate("habEmp.training_date").toLocalDate();
            	LocalDate expirationDate= rs.getDate("habEmp.expiration_date").toLocalDate();
            	      	
            	Employee employee = new Employee(employeeId, name, firstName);
            	Theme theme = new Theme (themeName);
            	Habilitation habilitation = new Habilitation(habilitationName,theme);
            	
            	
            	HabilitationEmployee habilitationEmployee = new HabilitationEmployee(employee, habilitation, trainingDate, expirationDate);
            	

            	habilitationsEmployee.add(habilitationEmployee);    	
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
		return habilitationsEmployee;
	}
	
	public HabilitationEmployee getHabilitationEmployeeByIdEmployeeAndIdHabilitation(Long employeeId, Long habilitationId) {

		Connection conn = null;
		HabilitationEmployee habilitationEmployee= null;
        
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT h.name,t.name,habEmp.training_date, habEmp.expiration_date "
        			+ "FROM EMPLOYEE_HABILITATION habEmp "
        			+ "JOIN EMPLOYEE emp ON emp.id = habEmp.employee_id "
        			+ "JOIN HABILITATIONS h ON h.id = habEmp.habilitations_id "
        			+ "JOIN THEMES t ON t.id = h.themes_id "
        			+ "WHERE habEmp.employee_id = ? AND h.id = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,employeeId);
            preparedStatement.setLong(2,habilitationId);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {            	
            	String habilitationName=rs.getString("h.name");
            	
            	String themeName = rs.getString("t.name");
            	
            	LocalDate trainingDate=rs.getDate("habEmp.training_date").toLocalDate();
            	LocalDate expirationDate= rs.getDate("habEmp.expiration_date").toLocalDate();
            	      	
            	Employee employee = new Employee(employeeId);
            	Theme theme = new Theme (themeName);
            	Habilitation habilitation = new Habilitation(habilitationName,theme);
            	
            	
            	habilitationEmployee = new HabilitationEmployee(employee, habilitation, trainingDate, expirationDate);   	
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
		return habilitationEmployee;
	}
	
	public void updateHabilitationEmployee(HabilitationEmployee habilitationEmployee) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "UPDATE employee_habilitation SET habilitations_id = ?, training_date=?, expiration_date= ? WHERE employee_id = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	preparedStatement.setLong(1,habilitationEmployee.getHabilitation().getId());
        	preparedStatement.setObject(2,habilitationEmployee.getTrainingDate());
        	preparedStatement.setObject(3,habilitationEmployee.getExpirationDate());
        	preparedStatement.setLong(4,habilitationEmployee.getEmployee().getId());
           
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

	public void createHabilitationEmployee (HabilitationEmployee habilitationEmployee) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
            String sql = "INSERT INTO employee_habilitation (employee_id, habilitations_id, training_date, expiration_date) VALUES (?,?,?,?)";
        	
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
      
            preparedStatement.setLong(1,habilitationEmployee.getEmployee().getId());
            preparedStatement.setLong(2,habilitationEmployee.getHabilitation().getId());
        	preparedStatement.setObject(3,habilitationEmployee.getTrainingDate());
        	preparedStatement.setObject(4,habilitationEmployee.getExpirationDate());

            
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
	
	public void deleteHabilitationEmployee(long habilitationId, long employeeId){
        Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "DELETE FROM employee_habilitation WHERE employee_id = ? AND habilitations_id = ?";
            
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	preparedStatement.setLong(1,habilitationId);
        	preparedStatement.setLong(2,employeeId);
           
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
