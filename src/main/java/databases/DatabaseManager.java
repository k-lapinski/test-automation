package databases;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertData(String column1, String column2) {
        String insertSQL = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, column1);
            preparedStatement.setString(2, column2);
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String column1, String column2) {
        String updateSQL = "UPDATE your_table SET column1 = ? WHERE column2 = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, column1);
            preparedStatement.setString(2, column2);
            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String column1) {
        String deleteSQL = "DELETE FROM your_table WHERE column1 = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, column1);
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectData() {
        String selectSQL = "SELECT * FROM your_table";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                System.out.println("Column1: " + column1 + ", Column2: " + column2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
