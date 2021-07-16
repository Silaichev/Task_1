package project.entities;

import java.util.Objects;

public class Lighting extends Electronic {


    public enum TypeLight{
        Led,
        Bulb_roll
    }

    private TypeLight typeLight;
    private int power;

    public Lighting() {
    }

    public Lighting(String name, int price, int power, TypeLight typeLight) {
        super(name, price);
        this.typeLight = typeLight;
        this.power = power;
    }

    public TypeLight getTypeLight() {
        return typeLight;
    }

    public void setTypeLight(TypeLight typeLight) {
        this.typeLight = typeLight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lighting)) return false;
        if (!super.equals(o)) return false;
        Lighting lighting = (Lighting) o;
        return getTypeLight() == lighting.getTypeLight()
                && getName().equals(lighting.getName())
                && getPrice()== lighting.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
