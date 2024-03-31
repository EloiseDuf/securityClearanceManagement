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

public class EmployeeRepository {
	public List<Employee> getAllEmployee(){
        Connection conn = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
        	String sql = "SELECT ID, NAME, FIRSTNAME FROM EMPLOYEE";
            
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {         	
            	Employee emp = new Employee();
            	emp.setName(rs.getString("NAME"));
            	emp.setFirstName(rs.getString("FIRSTNAME"));
                employees.add(emp);    	
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
		return employees;
	}
	
	public void createEmployee (Employee employee) {
		Connection conn = null;
        try {
        	
        	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
        	
        	conn=dataSource.getConnection();
        	
            String sql = "INSERT INTO EMPLOYEE (NAME, firstname, company, direction, team) VALUES (?,?,?,?,?)";
        	
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
      
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getCompany());
            preparedStatement.setString(4,employee.getDirection());
            preparedStatement.setString(5,employee.getTeam());
            
            preparedStatement.executeUpdate();
            

            System.out.println("Collaborateur crée");
            
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
        
        @SuppressWarnings("null")
		public Employee getEmployeeById(long id){
            Connection conn = null;
            Employee emp = null;
            try {
            	
            	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
            	
            	conn=dataSource.getConnection();
            	
            	String sql = "SELECT ID, NAME, FIRSTNAME FROM EMPLOYEE WHERE ID = ?";
                
            	PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setLong(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                
                
                if(rs.next()) {   
                	emp=new Employee();
                	emp.setId(rs.getLong("ID"));
                	emp.setName(rs.getString("NAME"));
                	emp.setFirstName(rs.getString("FIRSTNAME"));   	
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
    		return emp;
    	}
        
		public void updateEmployee(Employee employee){
            Connection conn = null;
            try {
            	
            	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
            	
            	conn=dataSource.getConnection();
            	
            	String sql = "UPDATE EMPLOYEE SET NAME=?, FIRSTNAME=? WHERE ID = ?";
                
            	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	preparedStatement.setString(1,employee.getName());
            	preparedStatement.setString(2,employee.getFirstName());
            	preparedStatement.setLong(3,employee.getId());
               
                int numberEmployeeSave = preparedStatement.executeUpdate();

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
		
		public void deleteEmployee(long id){
            Connection conn = null;
            try {
            	
            	DataSource dataSource=DataSourceProvider.getSingleDataSourceSingle();
            	
            	conn=dataSource.getConnection();
            	
            	String sql = "DELETE FROM EMPLOYEE WHERE ID = ?";
                
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
