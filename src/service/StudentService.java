package service;

import model.Students;
import util.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public void saveStu(Students students) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("" +
                     "insert into Students(SID,SFname,SLname) values (?,?,?)")) {
            preparedStatement.setInt(1, students.getSID());
            preparedStatement.setString(2, students.getSFname());
            preparedStatement.setString(3, students.getSLname());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delet(int studentID) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from  students where SID=?");
        ) {
            preparedStatement.setInt(1,studentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Students> loadStu() {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Students");
             ResultSet resultSet = preparedStatement.executeQuery();) {
            List<Students> students = new ArrayList<>();
            while (resultSet.next()) {
                Students students1 = new Students();
                students1.setSID(resultSet.getInt("SID"));
                students1.setSFname(resultSet.getNString("SFname"));
                students1.setSLname(resultSet.getNString("SLname"));
                students.add(students1);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
