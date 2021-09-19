package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarService {

    public List<Car> getOfCar(List<Car> list, int count) {
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
            default:
                result = list;

        }
        return result;
    }

}
