package appRest;

public class CityJson {

    public CityJson(){}

    public CityJson(String name, String country){
        this.name = name;
        this. country = country;
    }

    private String name;
    private String country;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }


}
