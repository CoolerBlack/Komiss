import java.util.ArrayList;
import java.util.Random;

class Car {
    private int value;
    private String brand;
    private int mileage;
    private String color;
    private String segment;
    private boolean[] repairsNeeded;


    public Car(int value, String brand, int mileage, String color, String segment, boolean[] repairsNeeded) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
        this.repairsNeeded = repairsNeeded;
    }

    public int getValue() {
        return value;
    }

    public String getBrand() {
        return brand;
    }

    public int getMileage() {
        return mileage;
    }

    public String getColor() {
        return color;
    }

    public String getSegment() {
        return segment;
    }

    public boolean[] getRepairsNeeded() {
        return repairsNeeded;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public void setRepairsNeeded(boolean[] repairsNeeded) {
        this.repairsNeeded = repairsNeeded;
    }

    public String repairsToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repairsNeeded.length; i++) {
            if (repairsNeeded[i]) {
                sb.append("Część ").append(i + 1).append(" wymaga naprawy.\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Cena: " + value + "\nMarka: " + brand + "\nPrzebieg: " + mileage + "\nKolor: " + color + "\nSegment: " + segment + "\nCzęści do naprawy:\n" + repairsToString();
    }
}