package database.commands;

import database.connection.ConnectDatabase;
import entities.students.SuperiorLevelStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperiorLevelStudentDAO {
    private SuperiorLevelStudentDAO() {
    }

    public static void insert(SuperiorLevelStudent superiorLevelStudent){
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "insert into superior_level_student (id, name, totalCredits, credits_cost) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, superiorLevelStudent.getId());
            preparedStatement.setString(2, superiorLevelStudent.getName());
            preparedStatement.setDouble(3, superiorLevelStudent.getCreditsCost());
            preparedStatement.setDouble(4, superiorLevelStudent.getTotalCredits());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void update(SuperiorLevelStudent superiorLevelStudent) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "update superior_level_student set name = ?, total_credits = ?, credits_cost = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, superiorLevelStudent.getName());
            preparedStatement.setDouble(2, superiorLevelStudent.getCreditsCost());
            preparedStatement.setDouble(3, superiorLevelStudent.getTotalCredits());
            preparedStatement.setInt(4, superiorLevelStudent.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "delete from superior_level_student where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<SuperiorLevelStudent> getAllSuperiorLevelStudents() {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from superior_level_student";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<SuperiorLevelStudent> allSuperiorLevelStudents = new ArrayList<>();
            while(resultSet.next()) {
                SuperiorLevelStudent superiorLevelStudent = new SuperiorLevelStudent(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4));
                allSuperiorLevelStudents.add(superiorLevelStudent);
            }
            preparedStatement.close();
            return allSuperiorLevelStudents;
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static SuperiorLevelStudent getSingleSuperiorLevelStudent(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from superior_level_student where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                preparedStatement.close();
                return new SuperiorLevelStudent(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4));
            }
            preparedStatement.close();
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}