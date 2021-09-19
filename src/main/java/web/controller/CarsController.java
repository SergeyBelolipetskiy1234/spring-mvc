package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        Car car1 = new Car("Kia", 3, "black");
        Car car2 = new Car("Ford", 2, "white");
        Car car3 = new Car("Toyota", 3, "red");
        Car car4 = new Car("Honda", 4, "gray");
        Car car5 = new Car("Heyndai", 3, "black");
        List<Car> list = new ArrayList<Car>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);

        List<Car> result = null;
        if(count == null) {
            result = list;
        } else if (count != null) {
            result = carService.getOfCar(list, count);
        }

        model.addAttribute("cars", result);
        return "cars";

    }
}
