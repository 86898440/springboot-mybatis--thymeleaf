package com.yungo.entity;
import java.util.Date;
/**
 * Created by cx on 17-8-3.
 */
public class Commodity {
    int id;
    String name;
    int number;
    String url;
    Date createTime;
    Date StartTime;

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", StartTime=" + StartTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                '}';
    }

    Date endTime;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    int price;
    /*商品详情*/
    String detail;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
