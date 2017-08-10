package com.yungo.entity;

/**
 * Created by cx on 17-8-4.
 */
public class ShopCar {


    private Integer id;
    private int count;
    private Commodity commodity;

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShopCar(Integer id, int count) {
        this.id = id;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", count=" + count +
                ", commodity=" + commodity +
                '}';
    }
}
