package web.service;

import model.Car;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.dao.CarDAOImpl;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    final CarDAO carDAO = new CarDAOImpl();

    public List<Car> returnXCars(Integer count) {
        return carDAO.returnXCars(count);
    }

    @Override
    public Car getCarDyId(Integer id) {
        return carDAO.getCarDyId(id);
    }
}
