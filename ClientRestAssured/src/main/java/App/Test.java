package App;

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
    }

    void addCity1(){
        given().
                contentType("application/json").
                body("{\"name\":\"Lyon\", \"country\":\"France\"}").
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
                body("{\"name\":\"Utrecht\", \"country\":\"Netherlands\"}").
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
                body("{\"name\":\"Gent\", \"country\":\"Belgium\"}").
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
                body("{\"cityName\":\"Lyon\", \"name\":\"La Course\", \"street\":\"Rue Laroche\", \"postcode\":\"1234\"}").
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void addHotel2(){
        given().
                contentType("application/json").
                body("{\"cityName\":\"Utrecht\", \"name\":\"Hotel Balneario\", \"street\":\"Av del Cid\", \"postcode\":\"2356\"}").
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void addHotel3(){
        given().
                contentType("application/json").
                body("{\"cityName\":\"Lyon\", \"name\":\"Gravensteen\", \"street\":\"Damstraat\", \"postcode\":\"5544\"}").
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

}
