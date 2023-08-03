package apis;

import java.util.List;

public class Order {
    private int orderId;
    private String uuid;
    private List<OrderLines> order_lines;;
    private double amount;
    private String paymentMethod;
    private double balanceBeforeOrder;
    private double bonusUsedAmount;
    private String paymentTransactionId;

    public Order() {
    }

    public Order(int orderId, String uuid,List<OrderLines> order_lines, double amount, String paymentMethod, double balanceBeforeOrder,
                 double bonusUsedAmount, String paymentTransactionId) {
        this.orderId = orderId;
        this.uuid = uuid;
        this.order_lines = order_lines;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.balanceBeforeOrder = balanceBeforeOrder;
        this.bonusUsedAmount = bonusUsedAmount;
        this.paymentTransactionId = paymentTransactionId;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public List<OrderLines> getOrderLines() {
        return order_lines;
    }
    public void setOrderLines(List<OrderLines> order_lines) {
        this.order_lines = order_lines;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", uuid='" + uuid + '\'' +
                ", order_lines='" + order_lines + '\'' +
                ", amount='" + amount + '\'' +
                ", balanceBeforeOrder='" + balanceBeforeOrder + '\'' +
                ", bonusUsedAmount='" + bonusUsedAmount + '\'' +
                ", paymentTransactionId='" + paymentTransactionId + '\'' +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

}
