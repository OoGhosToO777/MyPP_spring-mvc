package web.dao;

import model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> returnXCars(Integer count);

    Car getCarDyId(Integer id);
}
