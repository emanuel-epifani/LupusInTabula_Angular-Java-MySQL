package com.example.be_java.Controller;

import com.example.be_java.Model.*;
import com.example.be_java.Model.repository.EseguiNotteRepository;
import com.example.be_java.Model.repository.StartRepository;
import com.example.be_java.Model.repository.UsaPotereRepository;
import com.example.be_java.Model.repository.VotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"http://localhost:4200"})

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller {

    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/StartPartita")
    public OutputStart startPost(@RequestParam(value = "nome") String nometizio) {
        //ho solo spostato tutto il metodo in startRepository nel model per maggore chiarezza
        return StartRepository.start(nometizio);
    }

    //NOTTE - fa usare i poteri alle persone
    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/usaPotere")
    public EsitoNotte usaPotere(
            @RequestParam (value = "ruolo") String  ruoloUtente,
            @RequestParam (value = "nome") String bersagioPotere
    ) {
        return UsaPotereRepository.usapotere( ruoloUtente, bersagioPotere);
    }

    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/getVivi")
    public ArrayList<Personaggio> getVivi(){
        return UsaPotereRepository.getPersonaggiVivi();
    }

    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/eseguiNotte")
    public EsitoNotte eseguiNotte(){
        return EseguiNotteRepository.esegui();
    }

    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/vota")
    public EsitoVoto vota(@RequestParam(value = "bersaglio") String bersaglio) {
        //ho solo spostato tutto il metodo in startRepository nel model per maggore chiarezza
        return VotaRepository.vota(bersaglio);
    }

}
