package database.commands;

import database.connection.ConnectDatabase;
import entities.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesDAO {
    private ServicesDAO() {
    }

    public static void insert(Services services){
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "insert into services (id, description, total_hours, hour_cost) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, services.getId());
            preparedStatement.setString(2, services.getDescription());
            preparedStatement.setDouble(3, services.getTotalHours());
            preparedStatement.setDouble(4, services.getHourCost());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void update(Services services) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "update services set description = ?, total_hours = ?, hour_cost = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, services.getDescription());
            preparedStatement.setDouble(2, services.getTotalHours());
            preparedStatement.setDouble(3, services.getHourCost());
            preparedStatement.setInt(4, services.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "delete from services where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Services> getAllServices() {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from services";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            List<Services> allServices = new ArrayList<>();
            while(resultSet.next()) {
                Services services = new Services(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4));
                allServices.add(services);
            }
            return allServices;
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Services getSingleServices(int id) {
        try(Connection conn = ConnectDatabase.getConnection()) {
            String sql = "select * from services where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.close();
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Services(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4));
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

