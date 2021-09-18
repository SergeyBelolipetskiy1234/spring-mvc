package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/cars")
public class CarsController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) int count, Model model) {
        Car car1 = new Car("Kia", 3, "black");
        Car car2 = new Car("Ford", 3, "white");
        Car car3 = new Car("Toyota", 3, "red");
        Car car4 = new Car("Honda", 3, "gray");
        Car car5 = new Car("Heyndai", 3, "black");
        List<Car> list = new ArrayList<Car>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);

        List<Car> result;

        switch (count) {
            case 1:
                result = list.subList(0, 1);
                break;
            case 2:
                result = list.subList(0, 2);
                break;
            case 3:
                result = list.subList(0, 3);
                break;
            case 4:
                result = list.subList(0, 4);
                break;
            case 5:
                result = list;
                break;
            default:
                result = list;

        }

        model.addAttribute("cars", result);
        return "cars";

    }
}
