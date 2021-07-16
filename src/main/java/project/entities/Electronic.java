package project.entities;

import java.util.Objects;
import java.util.Random;

public class Electronic {

    private String name;
    private int price;


    public Electronic() {
    }

    public Electronic(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic)) return false;
        Electronic that = (Electronic) o;
        return getPrice() == that.getPrice() && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
