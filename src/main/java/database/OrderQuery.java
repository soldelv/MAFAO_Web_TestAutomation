package database;

import mafao.objects.Order;
import mafao.objects.OrderLines;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.fail;
import static utils.CommonMethods.parseStringToBoolean;
import static utils.CommonMethods.print;

public class OrderQuery {

    /** Method to parse the result to an OrderLine object */
    private static OrderLines parseResultSetToOrderLines(ResultSet resultSet) {
        OrderLines orderLinesQuery = new OrderLines();
        try{
            orderLinesQuery.setId(Integer.parseInt(resultSet.getString("id")));
            orderLinesQuery.setOrderId(Integer.parseInt(resultSet.getString("order_id")));
            orderLinesQuery.setProductByID(resultSet.getString("product_id"));
            orderLinesQuery.setPriceTax(Double.parseDouble(resultSet.getString("price_tax")));
            orderLinesQuery.setPriceTotal(resultSet.getString("price_total"));
            orderLinesQuery.setPriceSubtotal(Double.parseDouble(resultSet.getString("price_subtotal")));
            orderLinesQuery.setIsDelivery(parseStringToBoolean(resultSet.getString("is_delivery")));
            orderLinesQuery.setCreate_date(resultSet.getString("create_date"));
            orderLinesQuery.setMarketplaceState(resultSet.getString("marketplace_state"));
            orderLinesQuery.setMarketplace_seller_id(resultSet.getString("marketplace_seller_id"));
            orderLinesQuery.setName(resultSet.getString("name"));
            orderLinesQuery.setPriceUnit(Double.parseDouble(resultSet.getString("price_unit")));
            orderLinesQuery.setPickupDate(resultSet.getString("pickup_date"));


        }catch(SQLException e){
            fail("DATABASE ERROR: Not possible to parse Sale Order Line");

        }
        return orderLinesQuery;

    }

    /** Method to parse the result to an Order object */
    private static Order parseResultSetToOrder(ResultSet resultSet) {
        Order orderQuery = new Order();
        try{
            int order_id = Integer.parseInt(resultSet.getString("id"));
            orderQuery.setOrderId(order_id);
            orderQuery.setAmount_total(Double.parseDouble(resultSet.getString("amount_total")));
            orderQuery.setAccess_token(resultSet.getString("access_token"));
            orderQuery.setAccess_token(resultSet.getString("name"));
            orderQuery.setAccess_token(resultSet.getString("reference"));
            orderQuery.setAccess_token(resultSet.getString("state"));
            orderQuery.setAccess_token(resultSet.getString("date_order"));
            orderQuery.setAccess_token(resultSet.getString("user_id"));
            orderQuery.setOrderLines(getSaleOrderLineByOrderId(order_id));

        }catch(SQLException e){
            fail("DATABASE ERROR: Not possible to parse Sale Order");

        }
        print("ORDER-----------");
        print(String.valueOf(orderQuery));
        return orderQuery;
        /*
        Order{
        orderId=88,
        uuid='null',
        order_lines='[
            OrderLines{
                product=null,
                quantity='0',
                total_price='null',
                purchaseOrderId='null',
                isReceived='false',
                unit_price='100.0',
                uuid='null',
                price_subtotal='100.0',
                price_tax='15.0',
                create_date='2023-02-07 14:17:14.135486',
                is_delivery='false', marketplace_seller_id='54',
                marketplace_state='canceled',
                pickup_date='2023-02-21 00:00:00',
                name='[GE944PF0M2LUUNAFAMZ] Generic Parfum Elite Oud Orchid premium edition Fragrance World Brown Orchid est un parfum luxueux et sensuel, qui évoque les parfums emblématiques du passé. Les codes de l’élégance masculine ont été bousculés. Vous pouvez vous délecter selon votre caractère et votre sensibilité, vous habiller et vous soigner pour révéler qui vous êtes vraiment.',
                status=null}
                ]',
          amount='115.0',
          balanceBeforeOrder='0.0',
          bonusUsedAmount='0.0',
          paymentTransactionId='null',
          paymentMethod='null',
          access_token='2',
          name='null',
          reference='null',
          state='null',
          date_order='null',
          user_id=0}
         */

    }

    /** Method to retrieve Order Line information */
    public static void getSaleOrderLine()  {
        OrderLines orderLinesQuery = new OrderLines();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.openConnection();

            String query = "SELECT * FROM sale_order_line WHERE id = 607";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                orderLinesQuery = parseResultSetToOrderLines(resultSet);
                //orderList.add(order);
                print(String.valueOf(orderLinesQuery));
                print("result Set-------------");
                print(String.valueOf(resultSet));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return orderLinesQuery;
    }

    /** Method to retrieve Order Line information by order_id */
    public static List<OrderLines> getSaleOrderLineByOrderId(int order_id)  {
        List<OrderLines> orderLinesQuery = new ArrayList<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.openConnection();

            String query = "SELECT * FROM sale_order_line WHERE order_id = "+order_id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                OrderLines orderLines = parseResultSetToOrderLines(resultSet);
                orderLinesQuery.add(orderLines);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderLinesQuery;
    }

    /** Method to retrieve Order information */
    public static Order getSaleOrder()  {
        Order order = new Order();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.openConnection();

            String query = "SELECT * FROM sale_order WHERE id = 88";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                order = parseResultSetToOrder(resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }


}
