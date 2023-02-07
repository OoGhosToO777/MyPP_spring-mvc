package web.service;

import model.Car;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.dao.CarDAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    CarDAO carDAO = new CarDAOImpl();

    public List<Car> returnXCars(Integer count) {
        return carDAO.returnXCars(count);
    }

    @Override
    public Car getCarDyId(Integer id) {
        return carDAO.getCarDyId(id);
    }
}
