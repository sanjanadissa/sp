package flight_traking.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int passengerCount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @NotNull
    private LocalDateTime arrivedTime;

    @NotNull
    private LocalDateTime departedTime;

    @ManyToOne
    @JoinColumn(name = "arrived_airport_id", nullable = false)
    @JsonManagedReference
    private Airport arrivedAirport;

    @ManyToOne
    @JoinColumn(name = "departed_airport_id", nullable = false)
    @JsonManagedReference
    private Airport departedAirport;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    @JsonManagedReference
    private Aircraft aircraft;

    @OneToMany(mappedBy = "flight")
    @JsonBackReference
    private List<Passenger> passengers = new ArrayList<>();


}
