package flight_traking.demo.repository;

import flight_traking.demo.model.Aircraft;
import flight_traking.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findByAircraft_Id(Long id);

    List<Flight> findByArrivedTimeBetween(LocalDateTime start,LocalDateTime end);

    @Query("SELECT DISTINCT a.id, a.aircraft.model FROM flights a WHERE a.departedTime < :time")
    List<Object[]> findAircraftsBefore(@Param("time") LocalDateTime time);

}
