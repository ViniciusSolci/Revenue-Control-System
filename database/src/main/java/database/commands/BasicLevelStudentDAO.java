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
    private BasicLevelStudentDAO() {
    }

    public static void insert(BasicLevelStudent basicLevelStudent){
        try(Connection conn = ConnectDatabase.getConnection()) { 
            String sql = "insert into basic_level_student (id, name, monthly_payment) values (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, basicLevelStudent.getId());
                preparedStatement.setString(2, basicLevelStudent.getName());
                preparedStatement.setDouble(3, basicLevelStudent.getMonthlyPayment());
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void update(BasicLevelStudent basicLevelStudent) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "update basic_level_student set name = ?, monthly_payment = ? where id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, basicLevelStudent.getName());
                preparedStatement.setDouble(2, basicLevelStudent.getMonthlyPayment());
                preparedStatement.setInt(3, basicLevelStudent.getId());
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "delete from basic_level_student where id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<BasicLevelStudent> getAllBasicLevelStudents() {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from basic_level_student";
            ResultSet resultSet;
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                resultSet = preparedStatement.executeQuery();
            }
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
            ResultSet resultSet;
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
            }
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

    public static double getMonthlyPayment() {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select monthly_payment from basic_level_student where id = 1";
            ResultSet resultSet;
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                resultSet = preparedStatement.executeQuery();
            }
            if(resultSet.next()) {
                return resultSet.getDouble(1);
            }
            return 50;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateMonthlyPayment(double newMonthlyPayment) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "update basic_level_student set monthly_payment = ? where id >= 1";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setDouble(1, newMonthlyPayment);
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}