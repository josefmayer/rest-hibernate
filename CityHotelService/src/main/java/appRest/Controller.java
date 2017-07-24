package appRest;

import cityHotel.CityHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    CityHotelService cityHotelService; // = new CityHotelService();


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    //******************
    @RequestMapping(value = "/addCity", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public CityJson addCity(@RequestBody CityJson cityJson){
        cityHotelService.insertCity(cityJson);
        return cityJson;
    }

    @RequestMapping(value = "/addHotel", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public void addHotel(@RequestBody HotelJson hotelJson){
        cityHotelService.insertHotel(hotelJson);
    }


    @RequestMapping(value = "/findCityByName", method = RequestMethod.POST, produces="application/json")
    public CityJson findCityByName(@RequestParam(value="name") String name){
        CityJson cityJson = cityHotelService.findCityJsonByName(name);
        return cityJson;
    }

    @RequestMapping(value = "/findAllCities", method = RequestMethod.GET, produces="application/json")
    public List<CityJson> findAllCities(){
        List<CityJson> cityJsonList = cityHotelService.findAllCityJson();
        return  cityJsonList;
    }

    @RequestMapping(value = "/findHotelByName", method = RequestMethod.POST, produces="application/json")
    public HotelJson findHotelByName(@RequestParam(value="name") String name){
        HotelJson hotelJson = cityHotelService.findHotelByName(name);
        return hotelJson;
    }

}
