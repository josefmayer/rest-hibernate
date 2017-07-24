package appRest;

public class HotelJson {

    public HotelJson(){}

    public HotelJson(String cityName, String name, String street, String postcode) {
        this.cityName = cityName;
        this.name = name;
        this.street = street;
        this.postcode = postcode;
    }

    private String cityName;
    private String name;
    private String street;
    private String postcode;

    public String getCityName() {
        return cityName;
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
