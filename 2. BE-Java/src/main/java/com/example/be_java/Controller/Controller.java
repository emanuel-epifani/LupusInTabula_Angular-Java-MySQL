package com.example.be_java.Controller;

import com.example.be_java.Model.EsitoNotte;
import com.example.be_java.Model.OutputStart;
import com.example.be_java.Model.Partita;
import com.example.be_java.Model.Personaggio;
import com.example.be_java.Model.repository.EseguiNotteRepository;
import com.example.be_java.Model.repository.StartRepository;
import com.example.be_java.Model.repository.UsaPotereRepository;
import com.example.be_java.Model.repository.VotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class Controller {

    @CrossOrigin(origins = "https//:localhost:4200")
    @PostMapping("/StartPartita")
    public OutputStart startPost(@RequestParam(value = "nome") String nometizio) {
        //ho solo spostato tutto il metodo in startRepository nel model per maggore chiarezza
        return StartRepository.start(nometizio);
    }

    //NOTTE - fa usare i poteri alle persone
    @PostMapping("/usaPotere")
    public EsitoNotte usaPotere(
            @RequestParam (value = "ruolo") String  ruoloUtente,
            @RequestParam (value = "nome") String bersagioPotere
    ) {
        return UsaPotereRepository.usapotere( ruoloUtente, bersagioPotere);
    }

    @GetMapping ("/getVivi")
    public ArrayList<Personaggio> getVivi(){
        return UsaPotereRepository.getPersonaggiVivi();
    }

    @GetMapping ("/eseguiNotte")
    public EsitoNotte eseguiNotte(){
        return EseguiNotteRepository.esegui();
    }

    @PostMapping("/vota")
    public String vota(@RequestParam(value = "bersaglio") String bersagio) {
        //ho solo spostato tutto il metodo in startRepository nel model per maggore chiarezza
        return VotaRepository.vota(bersagio);
    }

}
