package web.service;

import model.Car;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarDAO carDAO;

    public CarServiceImp(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> returnXCars(Integer count) {
        return carDAO.returnXCars(count);
    }

    @Override
    public Car getCarDyId(Integer id) {
        return carDAO.getCarDyId(id);
    }
}
