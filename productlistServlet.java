package Servlet;

import Model.DBConnect;
import Model.product;
import Model.producttype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productlistServlet {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<product> getAllProduct() {
        List<product> list = new ArrayList<>();
        String query = "SELECT * FROM `product`";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String typeID = rs.getString("TypeID");
                double price = rs.getDouble("Price");
                String image = rs.getString("Image");
                boolean trend = rs.getBoolean("Trend");
                boolean popular = rs.getBoolean("Popular");
                boolean saleoff = rs.getBoolean("Saleoff");

                product product = new product(id, name, typeID, price, image, trend, popular, saleoff);
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }

    public List<producttype> getAllProducttype() {
        List<producttype> list = new ArrayList<>();
        String query = "SELECT * FROM `producttype`";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String typeID = rs.getString("TypeID");
                String typeName = rs.getString("TypeName");

                producttype productType = new producttype();
                productType.setTypeID(typeID);
                productType.setTypeName(typeName);
                
                list.add(productType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }

    public product getLast() {
        String query = "SELECT * FROM `product` ORDER BY ID DESC LIMIT 1";
        try (Connection connection = new DBConnect().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String image = resultSet.getString("Image");
                double price = resultSet.getDouble("Price");

                return new product(id, name, image, price, image, false, false, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<product> getProductBycID(String TypeID) {
        List<product> list = new ArrayList<>();
        String query = "SELECT * FROM `product` WHERE TypeID = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,TypeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String typeID = rs.getString("TypeID");
                double price = rs.getDouble("Price");
                String image = rs.getString("Image");
                boolean trend = rs.getBoolean("Trend");
                boolean popular = rs.getBoolean("Popular");
                boolean saleoff = rs.getBoolean("Saleoff");

                product product = new product(id, name, typeID, price, image, trend, popular, saleoff);
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }
    public List<product> searchByName(String txtSearch) {
        List<product> list = new ArrayList<>();
        String query = "SELECT * FROM `product` WHERE Name LIKE ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                // Thêm dòng lấy typeID từ cơ sở dữ liệu
                String typeID = rs.getString("TypeID");
                double price = rs.getDouble("Price");
                String image = rs.getString("Image");
                boolean trend = rs.getBoolean("Trend");
                boolean popular = rs.getBoolean("Popular");
                boolean saleoff = rs.getBoolean("Saleoff");

                product product = new product(id, name, typeID, price, image, trend, popular, saleoff);
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }

    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        productlistServlet servlet = new productlistServlet();
        List<product> list = servlet.getAllProduct();
        List<producttype> listC = servlet.getAllProducttype();
        // Tránh việc sử dụng từ khoá String làm tên biến
        List<product> listCC = servlet.getProductBycID("TypeID");
        for (product o : listCC) {
            System.out.println(o);
        }
    }
}
