package cityHotel;

import javax.persistence.*;

/**
 * Created by Josef Mayer on 30.05.2017.
 */

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TOURIST_CITY_ID", nullable = false)
    private City city;

    private String name;
    private String street;
    private String postcode;

    public Integer getId() {
        return id;
    }

    public Hotel setCity(City city){
        this.city = city;
        return this;
    }

    public City getCity(){
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public Hotel setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Hotel setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hotel setName(String name) {
        this.name = name;
        return this;
    }

}
