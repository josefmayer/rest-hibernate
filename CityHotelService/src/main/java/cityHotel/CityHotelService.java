package cityHotel;

import appRest.CityJson;
import appRest.HotelJson;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josef Mayer on 30.05.2017.
 */

@Configuration
public class CityHotelService {

    public CityHotelService cityHotelService() {return new CityHotelService();}

    public CityHotelService (){
        this.dao = new Dao();
    }

    private Dao dao;

    public void insertCity(CityJson cityJson){
        City city = new City();
        city.setName(cityJson.getName()).setCountry(cityJson.getCountry());
        dao.persistCity(city);
    }

    public void insertHotel(HotelJson hotelJson){
        Hotel hotel = new Hotel();
        City city1 = findCityByName(hotelJson.getCityName());

        hotel.setCity(city1).setName(hotelJson.getName()).setStreet(hotelJson.getStreet()).setPostcode(hotelJson.getPostcode());
        dao.persistHotel(hotel);
    }

    public City findCityByName(String name){
        List<City> resultList = dao.findCityByName(name);
        City touristCity = resultList.get(0);
        //System.out.println("******" + touristCity.getName());
        return touristCity;
    }

    public CityJson findCityJsonByName (String name){
        City city = findCityByName(name);
        CityJson cityJson = new CityJson(city.getName(), city.getCountry());
        return cityJson;
    }

    public List<CityJson> findAllCityJson(){
        List<CityJson> listCityJson = new ArrayList<CityJson>();
        for (City city: dao.findAllCities()){
            listCityJson.add(new CityJson(city.getName(), city.getCountry()));
        }
        return  listCityJson;
    }

    public HotelJson findHotelByName(String name){
        List<Hotel> resultList = dao.findHotelByName(name);
        Hotel h = resultList.get(0);
        HotelJson hotelJson = new HotelJson(h.getCity().getName(), h.getName(), h.getStreet(), h.getPostcode());
        return hotelJson;
    }

}