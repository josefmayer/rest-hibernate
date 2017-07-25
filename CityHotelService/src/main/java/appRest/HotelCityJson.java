package appRest;

public class HotelCityJson {
    public HotelCityJson(){}

    public HotelCityJson(CityJson cityJson, String name, String street, String postcode) {
        this.cityJson = cityJson;
        this.name = name;
        this.street = street;
        this.postcode = postcode;
    }

    //private String cityName;
    private CityJson cityJson;
    private String name;
    private String street;
    private String postcode;

    public CityJson getCityJson() {
        return cityJson;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

}
