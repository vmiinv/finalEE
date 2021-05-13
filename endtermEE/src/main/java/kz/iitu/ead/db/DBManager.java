package kz.iitu.ead.db;

import kz.iitu.ead.entities.Coffee;
import kz.iitu.ead.entities.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class    DBManager {

    private static Connection connection;

    static {
        try{

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coffee", "postgres", "123");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean addUser(Users user){
        int rows = 0;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, fullname, picture ) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getPicture());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }

    public static boolean updateUserPicture(Users user){
        int rows = 0;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET picture = ? WHERE id = ?");

            statement.setString(1, user.getPicture());
            statement.setLong(2, user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }

    public static boolean updateUserProfile(Users user){
        int rows = 0;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET fullname = ? WHERE id = ?");

            statement.setString(1, user.getFullName());
            statement.setLong(2, user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }

    public static boolean updateUserPassword(Users user){
        int rows = 0;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET password = ? WHERE id = ?");

            statement.setString(1, user.getPassword());
            statement.setLong(2, user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }

    public static Users getUserByEmail(String em){

        Users user = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, em);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname"),
                        resultSet.getString("picture")
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static boolean addCoffee(Coffee coffee){
        int rows = 0;
        try{

            PreparedStatement statement = connection.prepareStatement("INSERT INTO coffees (name, description, price, user_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, coffee.getName());
            statement.setString(2, coffee.getDescription());
            statement.setInt(3, coffee.getPrice());
            statement.setInt(4,coffee.getUser_id());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }

    public static List<Coffee> getAllCoffee(){

        List<Coffee> coffees = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT h.id, h.name, h.description,  h.price, h.user_id, u.fullname, u.picture " +
                    "FROM coffees h " +
                    "INNER JOIN users u ON u.id = h.user_id " +
                    "ORDER BY h.price ASC");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                coffees.add(
                        new Coffee(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                new Users(
                                        resultSet.getLong("user_id"),
                                        null, null,
                                        resultSet.getString("fullname"),
                                        resultSet.getString("picture")
                                ),
                                resultSet.getString("description"),
                                resultSet.getInt("price")
                        )
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return coffees;
    }

    public static Coffee getCoffee(Long id){

        Coffee coffee = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT h.id, h.name, h.description,  h.price,  h.user_id, u.fullname, u.picture " +
                    "FROM coffees h " +
                    "INNER JOIN users u ON u.id = h.user_id " +
                    "WHERE h.id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                coffee = new Coffee(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        new Users(
                                resultSet.getLong("user_id"),
                                null, null,
                                resultSet.getString("fullname"),
                                resultSet.getString("picture")
                        ),
                        resultSet.getString("description"),
                        resultSet.getInt("price")
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return coffee;
    }

}
