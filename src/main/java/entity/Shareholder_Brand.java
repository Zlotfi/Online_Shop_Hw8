package entity;

public class Shareholder_Brand {
    private Integer brand_id;
    private Integer shareholder_id;

    public Shareholder_Brand(Integer brand_id, Integer shareholder_id) {
        this.brand_id = brand_id;
        this.shareholder_id = shareholder_id;
    }

    public Shareholder_Brand() {
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getShareholder_id() {
        return shareholder_id;
    }

    public void setShareholder_id(Integer shareholder_id) {
        this.shareholder_id = shareholder_id;
    }
}
