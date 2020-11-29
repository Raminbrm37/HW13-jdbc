package service;

import model.Master;
import util.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MasterService {
    private ResultSet resultSet = null;

    public void saveMas(Master master) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into Master(MID,MFname,MLname) values (?,?,?)")) {
            preparedStatement.setInt(1, master.getMID());
            preparedStatement.setString(2, master.getMFname());
            preparedStatement.setString(3, master.getMLname());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletedMas(int MasterID) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from Master where MID=?  ")) {
            preparedStatement.setInt(1, MasterID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Master> loadAllMas() {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from Master");
             ResultSet resultSet = preparedStatement.executeQuery();) {
            List<Master> masters = new ArrayList<>();
            while (resultSet.next()) {
                Master master = new Master();
                master.setMID(resultSet.getInt("MID"));
                master.setMFname(resultSet.getNString("MFname"));
                master.setMLname(resultSet.getNString("MLname"));
                masters.add(master);
            }
            return masters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Master nameMaster(int MasterID) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from master \n" +
                             "where mid=?");
        ) {
           preparedStatement.setInt(1, MasterID);
            resultSet = preparedStatement.executeQuery();
            Master master = new Master();
            while (resultSet.next()) {
                master.setMID(resultSet.getInt(1));
                master.setMFname(resultSet.getNString(2));
                master.setMLname(resultSet.getNString(3));

            }
            return master;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }
}
