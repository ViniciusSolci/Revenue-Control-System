package database.commands;

import database.connection.ConnectDatabase;
import entities.students.BasicLevelStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicLevelStudentDAO {
    
    public static void insert(BasicLevelStudent basicLevelStudent){
        try(Connection conn = ConnectDatabase.getConnection()) { 
            String sql = "insert into basic_level_student (id, name, monthly_payment) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, basicLevelStudent.getId());
            preparedStatement.setString(2, basicLevelStudent.getName());
            preparedStatement.setDouble(3, basicLevelStudent.getMonthlyPayment());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void update(BasicLevelStudent basicLevelStudent) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "update basic_level_student set name = ?, monthly_payment = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, basicLevelStudent.getName());
            preparedStatement.setDouble(2, basicLevelStudent.getMonthlyPayment());
            preparedStatement.setInt(3, basicLevelStudent.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "delete from basic_level_student where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<BasicLevelStudent> getAllBasicLevelStudents() {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from basic_level_student";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            List<BasicLevelStudent> allBasicLevelStudents = new ArrayList<>();
            while(resultSet.next()) {
                BasicLevelStudent basicLevelStudents = new BasicLevelStudent(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3));
                allBasicLevelStudents.add(basicLevelStudents);
            }
            return allBasicLevelStudents;
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static BasicLevelStudent getSingleBasicLevelStudent(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from basic_level_student where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.close();
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new BasicLevelStudent(
                        resultSet.getInt(1), 
                        resultSet.getString(2),
                        resultSet.getDouble(3));
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}