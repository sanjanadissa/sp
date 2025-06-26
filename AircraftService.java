package flight_traking.demo.service;

import flight_traking.demo.model.Aircraft;
import flight_traking.demo.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public List<Aircraft> getAircraftByModel(String model){
        return aircraftRepository.findByModel(model);
    }

    public int findCountByModel(String model){
        return aircraftRepository.countByModel(model);
    }

    public List<Object[]> CountPerModel(){
        return aircraftRepository.CountPerModel();
    }

    public List<Aircraft> fildAllClass(){
        return aircraftRepository.findAll();
    }

    public void deleteById(Long id){
        aircraftRepository.deleteById(id);
    }

    public Aircraft updateCraft(Long id,Aircraft aircraft){
        Optional<Aircraft> existopt = aircraftRepository.findById(id);
        if(existopt!=null){

            Aircraft existing = existopt.get();
            existing.setModel(aircraft.getModel());
            existing.setFlightList(aircraft.getFlightList());
            return aircraftRepository.save(existing);


        }else{
            throw new IllegalArgumentException("aijsNDSNIA");
        }
    }


}
