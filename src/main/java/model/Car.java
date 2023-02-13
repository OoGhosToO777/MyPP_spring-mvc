package model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int year;

    public Car() {
    }

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    static final List<Car> list = new ArrayList<>();

    static {
        list.add(new Car("MBW", "X7", 2022));
        list.add(new Car("Audi", "Q7", 2022));
        list.add(new Car("MBW", "M3", 2022));
        list.add(new Car("Mercedes", "GLC", 2022));
        list.add(new Car("Lexus", "LX", 2022));
    }

    public static List<Car> createFiveCars() {
        return list;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
