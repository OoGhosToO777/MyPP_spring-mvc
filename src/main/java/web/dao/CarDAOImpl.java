package web.dao;

import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDAOImpl implements CarDAO {

    final List<Car> carsList = new ArrayList<>();

    public List<Car> returnXCars(Integer count) {
        if (count == null || count > 5) {
            return Car.createFiveCars();
        }
        return Car.createFiveCars().stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public Car getCarDyId(Integer id) {
        return carsList.get(id);
    }
}
