package jp.co.kiramex.dbSample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Review05 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/kadaidb";
        String user = "root";
        String password = "mtM-0415";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("検索キーワードを入力してください > ");
            int id = Integer.parseInt(scanner.nextLine());

            String query = "SELECT name, age FROM person WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(name);
                System.out.println(age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}