package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBConnect {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlykinhdoanhgiayonline", "root", "");
        return con;
    }

    public void fetchDataFromDatabase() {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM `product`";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Process each row of the result set
                    // Example: Retrieve values by column name
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String typeID = resultSet.getString("TypeID");
                    double price = resultSet.getDouble("Price");
                    String image = resultSet.getString("Image");
                    boolean trend = resultSet.getBoolean("Trend");
                    boolean popular = resultSet.getBoolean("Popular");
                    boolean saleoff = resultSet.getBoolean("Saleoff");

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("TypeID: " + typeID);
                    System.out.println("Price: " + price);
                    System.out.println("Image: " + image);
                    System.out.println("Trend: " + trend);
                    System.out.println("Popular: " + popular);
                    System.out.println("Saleoff: " + saleoff);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();
        dbConnect.fetchDataFromDatabase();
    }

	public List<product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
