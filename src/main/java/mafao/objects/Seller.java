package mafao.objects;

public class Seller {
    private int id;
    private String name;
    private String display_name;

    /*
    "user_ids": [
        204
    ],
    * */
    public Seller() {
    }

    public Seller(int id, String name, String display_name) {
        this.id = id;
        this.name = name;
        this.display_name = display_name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDisplay_name() {
        return display_name;
    }
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", display_name=" + display_name +
                '}';
    }

}
