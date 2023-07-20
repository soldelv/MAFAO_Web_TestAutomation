package apis;

class Product {

    private int id;
    private String display_name;
    private double list_price;


    public Product() {
    }

    public Product(int id, String display_name, double list_price) {
        this.id = id;
        this.display_name = display_name;
        this.list_price = list_price;

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

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", display_name='" + display_name + '\'' +
                ", list_price=" + list_price +
                '}';
    }
}