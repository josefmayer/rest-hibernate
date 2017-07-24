package cityHotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Josef Mayer on 30.05.2017.
 */

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;

    @OneToMany (mappedBy = "city")
    private Set<Hotel> hotels = new HashSet<>();

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public City setCountry(String country) {
        this.country = country;
        return this;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

}
