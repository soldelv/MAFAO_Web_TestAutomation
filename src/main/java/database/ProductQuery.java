package database;

import mafao.objects.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.fail;
import static utils.CommonMethods.parseStringToBoolean;

public class ProductQuery {

    /** Method to parse the result to a Product object */
    private static Product parseResultSetToProduct(ResultSet resultSet) {
        Product productQuery = new Product();
        try{
            productQuery.setId(Integer.parseInt(resultSet.getString("id")));
            productQuery.setDisplay_name(resultSet.getString("name"));
            productQuery.setDescription_sale(resultSet.getString("description_sale"));
            productQuery.setCategoryID(Integer.parseInt(resultSet.getString("categ_id")));
            productQuery.setList_price(Double.parseDouble(resultSet.getString("list_price")));
            productQuery.setIsActive(parseStringToBoolean(resultSet.getString("active")));
            productQuery.setIsPublished(parseStringToBoolean(resultSet.getString("is_published")));
            productQuery.setCreationDate(resultSet.getString("create_date"));
            productQuery.setSaleDelay(resultSet.getString("sale_delay"));
            productQuery.setStatus(resultSet.getString("status"));
            productQuery.setInitialQuantity(resultSet.getString("mp_qty"));
            productQuery.setSellerID(resultSet.getString("marketplace_seller_id"));
        }catch(SQLException e){
            fail("DATABASE ERROR: Not possible to parse Product");

        }
        return productQuery;

    }

    /** Method to retrieve Product information */

    public static Product getProductDetailByName(String name)  {
        Product productQuery = new Product();

        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.openConnection();

            String query = "SELECT * FROM product_template WHERE name = '"+name+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                productQuery = parseResultSetToProduct(resultSet);
            }

            resultSet.close();
            statement.close();
            databaseConnection.closeConnection();

        }catch(SQLException e){
            fail("DATABASE ERROR: Not possible to perform query");

        }
        return productQuery;
    }

    public static List<Product> getPublishedProducts()  {
        List<Product> productList = new ArrayList<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.openConnection();

            String query = "SELECT * FROM product_template WHERE is_published = 't'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product product = parseResultSetToProduct(resultSet);
                productList.add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

}
