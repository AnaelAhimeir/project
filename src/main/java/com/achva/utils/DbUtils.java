package com.achva.utils;


import com.achva.entities.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class DbUtils {

    private Connection connection;

    @PostConstruct
    public void init () {
        createDbConnection(Constants.DB_USERNAME, Constants.DB_PASSWORD);
    }

    private void createDbConnection(String username, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", username, password);
            System.out.println("Connection successful!");
            System.out.println();
        }catch (Exception e){
            System.out.println("Cannot create DB connection!");
        }
    }

    public boolean checkIfUsernameAvailable (String username) {
        boolean available = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username FROM users WHERE username = ?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.next()) {
                 available = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return available;
    }

    public boolean addUser (User user) {
        boolean success = false;
        try {
            if (checkIfUsernameAvailable(user.getUsername())) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES ( ? , ? )");
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.executeUpdate();
                success = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }
//
    public List<User> getAllUsers () {
        List<User> allUsers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username,password);
                allUsers.add(user);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }
//
//    public void addProduct(Product product) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (description, price, count) VALUES ( ? , ? , ?)");
//            preparedStatement.setString(1, product.getDescription());
//            preparedStatement.setFloat(2, product.getPrice());
//            preparedStatement.setInt(3, product.getCount());
//            preparedStatement.executeUpdate();
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /*public boolean checkCredentials (String username, String password) {
//        boolean ok = false;
//        if (checkIfUsernameAvailable(username)) {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE password = ? and username = ?");
//            preparedStatement.setString(1,username);
//            preparedStatement.setString(2,password);
//        }
//    }*/
//
    public User login (String username, String password) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id, secret FROM users WHERE username = ? AND password = ? ");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String secret = resultSet.getString("secret");
                user = new User();
                user.setId(id);
                user.setSecret(secret);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }


}
