package apis;

public class Order {
    private int orderId;
    private String uuid;
    private OrderLines orderLines;
    private double amount;
    private String paymentMethod;
    private double balanceBeforeOrder;
    private double bonusUsedAmount;
    private String paymentTransactionId;

    public Order() {
    }

    public Order(int orderId, String uuid,OrderLines orderLines, double amount, String paymentMethod, double balanceBeforeOrder,
                 double bonusUsedAmount, String paymentTransactionId) {
        this.orderId = orderId;
        this.uuid = uuid;
        this.orderLines = orderLines;
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
                ", amount='" + amount + '\'' +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

}
