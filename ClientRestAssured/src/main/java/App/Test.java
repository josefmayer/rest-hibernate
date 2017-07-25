package App;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Josef Mayer on 18.07.2017.
 */
public class Test {

    void testAll(){
        addCity1();
        addCity2();
        addCity3();
        findCityByName();
        findAllCities();
        addHotel1();
        addHotel2();
        addHotel3();
        findHotelByName();

        findHotelJsonByName();

        addHotelJson();

    }

    void addCity1(){
        given().
                contentType("application/json").
                body(new File("data/city1.json")).
        when().
                post("/addCity").
        then().
                statusCode(200).
                body("name", equalTo("Lyon")).
                body("country", equalTo("France"));

    }

    void addCity2(){
        given().
                contentType("application/json").
                body(new File("data/city2.json")).
        when().
                post("/addCity").
        then().
                statusCode(200).
                body("name", equalTo("Utrecht")).
                body("country", equalTo("Netherlands"));
    }

    void addCity3(){
        given().
                contentType("application/json").
                body(new File("data/city3.json")).
        when().
                post("/addCity").
        then().
                statusCode(200).
                body("name", equalTo("Gent")).
                body("country", equalTo("Belgium"));
    }

    void findCityByName(){
        given().
                param("name", "Lyon").
        when().
                post("/findCityByName").
        then().
                statusCode(200).
                body("name", equalTo("Lyon")).
                body("country", equalTo("France"));
    }

    void findAllCities(){
        given().
        when().
                get("/findAllCities").
        then().
                statusCode(200);
    }

    void addHotel1(){
        given().
                contentType("application/json").
                body(new File("data/hotel1.json")).
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void addHotel2(){
        given().
                contentType("application/json").
                body(new File("data/hotel2.json")).
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void addHotel3(){
        given().
                contentType("application/json").
                body(new File("data/hotel3.json")).
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void findHotelByName(){
        given().
                param("name", "La Course").
        when().
                post("/findHotelByName").
        then().
                statusCode(200).
                body("cityName", equalTo("Lyon")).
                body("name", equalTo("La Course")).
                body("street", equalTo("Rue Laroche")).
                body("postcode", equalTo("1234"));
    }

    void findHotelJsonByName(){
        given().
                param("name", "La Course").
        when().
                post("/findHotelJsonByName").
        then().
                statusCode(200);
                //body("name", equalTo("Lyon")).
                //body("country", equalTo("France"));

    }

    void addHotelJson(){
        given().
                contentType("application/json").
                //body("{\"cityName\":\"Lyon\", \"name\":\"Gravensteen\", \"street\":\"Damstraat\", \"postcode\":\"5544\"}").
                body(new File("data/hoteljson2_1.json")).
        when().
                post("/addHotel2").
        then().
                statusCode(200);
    }

}
