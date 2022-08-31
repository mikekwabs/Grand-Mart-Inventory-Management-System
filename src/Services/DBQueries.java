package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Models.Products;

public class DBQueries {

    Connection connection;
    PreparedStatement pst;

    public boolean insertProduct(Products myProduct) {
        boolean result = false;

        try {
            String sql = "insert into products(productName,price,quantity) values (?,?,?,?)";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");
            pst = connection.prepareStatement(sql);

            // insert values into the statement
            pst.setString(1, myProduct.getProductName());
            pst.setString(2, myProduct.getPrice());
            pst.setString(3, myProduct.getQuantity());

            // run sqlcommand
            int inserted = pst.executeUpdate();

            // for affected rows
            result = inserted >= 1;

            // close connection
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    // delete product
    public boolean deleteProduct(int proudctId) {
        boolean result = false;

        try {
            String sql = "delete from products where productId = ?";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");
            pst = connection.prepareStatement(sql);

            // exceute command
            int deleted = pst.executeUpdate();

            // rows affected
            result = deleted >= 1;

            // close connection
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    // update product using Id

    public boolean updateProduct(Products product) {
        boolean result = false;

        try {
            // parameterize SQL statement to stop SQL injections
            String sql = "UPDATE products SET productName = ?, quantity = ?, price = ? WHERE productId = ?";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");
            PreparedStatement stmt = connection.prepareStatement(sql);

            // insert values into prepared statement
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getQuantity());
            stmt.setString(3, product.getPrice());
            stmt.setString(4, product.getProductId());

            // execute SQL command
            int rowsUpdated = stmt.executeUpdate();

            // were there any affected rows?
            result = rowsUpdated >= 1;

            // disconnect
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // get product by id
    public Products getProductById(int id) {
        Products foundProduct = null;

        try {
            // parameterize SQL statement to deter SQL injection attacks
            String sql = "SELECT * FROM products WHERE productId = ?";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/grandmart_db", "root", "");
            PreparedStatement stmt = connection.prepareStatement(sql);

            // insert values into prepared statement
            stmt.setInt(1, id);

            // execute SQL command and record results
            ResultSet results = stmt.executeQuery();

            // iterate through ResultSet, adding each product to list
            while (results.next()) {
                // foundProduct = new Products(results.getString(1), results.getString(2),
                // results.getDouble(3),
                // results.getInt(4));
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundProduct;
    }

}
