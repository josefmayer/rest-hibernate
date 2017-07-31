package cityHotel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Josef Mayer on 30.05.2017.
 */
public class Dao {

    public Dao(){
        //this.emf = Persistence.createEntityManagerFactory("jpa-example-mysql");
        //this.emf = Persistence.createEntityManagerFactory("jpa-example-mssqlserver");
        this.emf = Persistence.createEntityManagerFactory("jpa-example-postgres");
        //this.emf = Persistence.createEntityManagerFactory("jpa-example-hsqldb");
    }

    private EntityManagerFactory emf;

    public void persistCity(City city) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
    }

    public void persistHotel(Hotel hotel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();
        em.close();
    }

    //JPQL
    public List<City> findAllCities(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT city FROM City city");
        List<City> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    //JPQL
    public List<Hotel> findAllHotels(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT hotel FROM Hotel hotel");
        List<Hotel> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    //JPQL
    public List<City> findCityByName(String city){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery(
                "SELECT city FROM City city WHERE city.name = :cityName"
        ).setParameter("cityName", city);

        List<City> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return resultList;
    }


    //JPQL
    public List<Hotel> findHotelByName(String hotel){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery(
                "SELECT hotel FROM Hotel hotel WHERE hotel.name = :hotelName"
        ).setParameter("hotelName", hotel);

        List<Hotel> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return resultList;
    }



    public List<Hotel> queryJoin(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("select h from City tc inner join tc.hotels h ");
        List<Hotel> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }


}
