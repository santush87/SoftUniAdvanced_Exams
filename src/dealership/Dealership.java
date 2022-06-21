package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private final String name;
    private final int capacity;
    private final List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return this.data.remove(car);
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = new Car();
        for (Car currCar : this.data) {
            if (car.getYear() < currCar.getYear()) {
                car = currCar;
            }
        }
        if (car.getYear() > 0) {
            return car;
        } else {
            return null;
        }
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:", name));
        builder.append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            builder.append(this.data.get(i));
            if (i < this.data.size() - 1) {
                builder.append(System.lineSeparator());
            }
        }

        return builder.toString();
    }
}
