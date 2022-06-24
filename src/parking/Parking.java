package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final String type;
    private final int capacity;
    private final List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        for (Car car : data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return data.remove(car);
            }
        }
        return false;
    }

    public Car getLatestCar(){
        if (this.data.isEmpty()){
            return null;
        }else {
            Car car = new Car();
            for (Car currCar : this.data){
                if (currCar.getYear() > car.getYear()){
                    car = currCar;
                }
            }
            return car;
        }
    }

    public Car getCar(String manufacturer, String model){
        for (Car car : data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                 return car;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are parked in %s:\n", this.type));

        for (int i = 0; i < this.data.size(); i++) {
            builder.append(this.data.get(i));
            if (i < this.data.size()-1){
                builder.append(System.lineSeparator());
            }
        }

        return builder.toString();
    }
}
