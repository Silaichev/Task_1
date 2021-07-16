package project.entities;

import java.util.Objects;

public class Chandelier extends Lighting {

    private int numLampHolders;

    public Chandelier() {
    }

    public Chandelier(String name, int price,int power, TypeLight typeLight, int numLampHolders) {
        super(name, price,power, typeLight);
        this.numLampHolders = numLampHolders;
    }

    public int getNumLampHolders() {
        return numLampHolders;
    }

    public void setNumLampHolders(int numLampHolders) {
        this.numLampHolders = numLampHolders;
    }

    @Override
    public String toString() {
        return "Chandelier{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", power=" + getPower()+
                ", numLampHolders=" + numLampHolders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chandelier)) return false;
        if (!super.equals(o)) return false;
        Chandelier that = (Chandelier) o;
        return getNumLampHolders() == that.getNumLampHolders();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumLampHolders());
    }

}
