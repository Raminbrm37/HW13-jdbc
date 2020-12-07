package service;

import model.Master;
import model.Students;
import model.stu_mas;
import util.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuMasService {
    private ResultSet resultSet = null;

    public void save(stu_mas stuMas) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("" +
                     "insert into stu_mas(SID_m,MID_m) values (?,?)")) {
            preparedStatement.setInt(1, stuMas.getSID_m());
            preparedStatement.setInt(2, stuMas.getMID_m());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int studentID, int masterID) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from stu_mas where SID_m=? and MID_m=?")) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setInt(2, masterID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteViaStudentID(int studentID) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from stu_mas where SID_m=? ")) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteViaMasterID(int masterID) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from stu_mas where MID_m=? ")) {
            preparedStatement.setInt(1, masterID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<stu_mas> loadAll() {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from stu_mas");
             ResultSet resultSet = preparedStatement.executeQuery();) {
            List<stu_mas> stuMas = new ArrayList<>();
            while (resultSet.next()) {
                stu_mas stuMas1 = new stu_mas();
                stuMas1.setSID_m(resultSet.getInt("SID_m"));
                stuMas1.setMID_m(resultSet.getInt("MID_m"));
                stuMas.add(stuMas1);
            }
            return stuMas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Students> listOfStuForMaster(int input) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * from students s\n" +
                             "join stu_mas sm\n" +
                             "on s.SID=sm.SID_m\n" +
                             "where sm.MID_m=?");

        ) {
            preparedStatement.setInt(1, input);
            resultSet = preparedStatement.executeQuery();
            Master master = new Master();
            MasterService masterService = new MasterService();
            System.out.println("Students for MasterName:" + (masterService.nameMaster(input)).getMLname());
            List<Students> students = new ArrayList<>();
            while (resultSet.next()) {
                Students students1 = new Students();
                students1.setSID(resultSet.getInt(1));
                students1.setSFname(resultSet.getNString(2));
                students1.setSLname(resultSet.getNString(3));
                students.add(students1);

            }
            return students;
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
