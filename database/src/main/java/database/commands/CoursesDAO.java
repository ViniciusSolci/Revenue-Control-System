package database.commands;

import database.connection.ConnectDatabase;
import entities.courses.Courses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesDAO {
    private CoursesDAO() {
    }

    public static void insert(Courses courses){
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "insert into courses (id, name, credits_cost) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, courses.getId());
            preparedStatement.setString(2, courses.getName());
            preparedStatement.setDouble(3, courses.getCreditsCost());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void update(Courses courses) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "update courses set name = ?, credits_cost = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, courses.getName());
            preparedStatement.setDouble(2, courses.getCreditsCost());
            preparedStatement.setInt(3, courses.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "delete from courses where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Courses> getAllCourses() {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from courses";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            List<Courses> allCourses = new ArrayList<>();
            while(resultSet.next()) {
                Courses courses = new Courses(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3));
                allCourses.add(courses);
            }
            return allCourses;
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static Courses getSingleCourses(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from courses where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.close();
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Courses(
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

