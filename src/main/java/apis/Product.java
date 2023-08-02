package apis;

public class Product {

    private int id;
    private String display_name;
    private String description_sale;
    private String expiration_date;
    private boolean superBonus;
    private double list_price;
    private double oldPrice;

    public Product() {
    }

    public Product(int id, String display_name, String description_sale, String expiration_date, boolean superBonus, double list_price, double oldPrice) {
        this.id = id;
        this.display_name = display_name;
        this.description_sale = description_sale;
        this.expiration_date = expiration_date;
        this.superBonus = superBonus;
        this.list_price = list_price;
        this.oldPrice = oldPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDescription_sale() {
        return description_sale;
    }

    public void setDescription_sale(String description_sale) {
        this.description_sale = description_sale;
    }
    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public boolean getSuperBonus() {
        return superBonus;
    }

    public void setSuperBonus(boolean superBonus) {
        this.superBonus = superBonus;
    }

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getFormattedListPrice(){
        String productPrice = String.valueOf(getList_price());
        productPrice = productPrice.substring(0, productPrice.length() - 2);
        return productPrice;
    }

    public String getFormattedOldPrice(){
        String productOldPrice = String.valueOf(getOldPrice());
        productOldPrice = productOldPrice.substring(0, productOldPrice.length() - 2);
        return productOldPrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", display_name='" + display_name + '\'' +
                ", description_sale='" + description_sale + '\'' +
                ", expiration_date='" + expiration_date + '\'' +
                ", superBonus='" + superBonus + '\'' +
                ", list_price=" + list_price +
                ", oldPrice=" + oldPrice +
                '}';
    }
}