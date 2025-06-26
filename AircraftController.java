package flight_traking.demo.controller;

import flight_traking.demo.model.Aircraft;
import flight_traking.demo.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        return ResponseEntity.of(aircraftService.getAircraftById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Aircraft>> searchAircraftByModel (@RequestParam String model) {
        return ResponseEntity.ok(aircraftService.getAircraftByModel(model));
    }

    @GetMapping("/search/count")
    public int findCountByModel(@RequestParam String model){
        return aircraftService.findCountByModel(model);
    }

    @GetMapping("/getallcounts")
    public List<Object[]> CountPerModel(){
        return aircraftService.CountPerModel();
    }

    @GetMapping()
    public List<Aircraft> fildAllClass(){
        return aircraftService.fildAllClass();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        aircraftService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Aircraft updateCraft(
            @PathVariable Long id,
            @RequestBody Aircraft aircraft
    ){
        return  aircraftService.updateCraft(id,aircraft);
    }

}