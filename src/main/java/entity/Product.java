package entity;

public class Product {
    private Integer id;
    private String name;
    private String createDate;
    private Integer category_id;
    private Integer brand_id;

    public Product(Integer id, String name, String createDate, Integer category_id, Integer brand_id) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }
}
