package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {
    private List<Car> carsList;
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        model.addAttribute("cars", carService.returnXCars(count));
        return "cars";
    }
}

