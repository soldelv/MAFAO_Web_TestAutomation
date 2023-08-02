package apis;

public class OrderLines {
    private Product product;
    private int quantity;
    private double total_price;
    private String purchaseOrderId;
    private boolean isReceived;
    private double unit_price;
    private String uuid;
    private String status;

    public OrderLines() {
    }

    public OrderLines(Product product, int quantity,double total_price, String purchaseOrderId, boolean isReceived,
                      double unit_price, String uuid, String status) {
        this.product = product;
        this.quantity = quantity;
        this.total_price = total_price;
        this.purchaseOrderId = purchaseOrderId;
        this.isReceived = isReceived;
        this.unit_price = unit_price;
        this.uuid = uuid;
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }
    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    @Override
    public String toString() {
        return "OrderLines{" +
                "product=" + product +
                ", quantity='" + quantity + '\'' +
                ", purchaseOrderId=" + purchaseOrderId +
                '}';
    }


        /*
          {
            "order_lines": [
                {
                    "product": {
                        "description_sale": "Team payaman shirts from philippines",
                        "id": 179,
                        "list_price": 950.0,
                        "display_name": "TP assorted shirts",

                    },
                    "quantity": 1,
                    "total_price": 950.0,
                    "purchaseOrderId": "b9a5f6c5-fffc-48e7-af00-e296f1fe7782",
                    "isReceived": false,
                    "unit_price": 950.0,
                    "uuid": "ebc173a6-3502-4534-88ef-2859965bad71",
                    "status": "new"
                }
            ],
        },
     */
}
