package web.service;

import model.Car;

import java.util.List;

public interface CarService {
    List<Car> returnXCars(Integer count);

    Car getCarDyId(Integer id);
}
