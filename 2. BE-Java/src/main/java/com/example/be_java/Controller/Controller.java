package com.example.be_java.Controller;

import com.example.be_java.Model.Personaggio;
import com.example.be_java.Model.repository.StartRepository;
import com.example.be_java.Model.repository.UsaPotereRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {



    @PostMapping("/StartPartita")
    public String startPost(@RequestParam(value = "nome") String nometizio) {
        //ho solo spostato tutto il metodo in startRepository nel model per maggore chiarezza
        return StartRepository.start(nometizio);

    }

    //postmapping per la notte fa usare i poteri alle persone
    @PostMapping("/usaPotere")
    public String usaPotere(
            @RequestParam (value = "ruolo") String  ruoloUtente,
            @RequestParam(value = "id_partita") int id_partita,
            @RequestParam (value = "nome") String bersagioPotere
    ) {
        //faccio la stessa cosa qui creando il metodo nel repository
        return UsaPotereRepository.usapotere(id_partita, ruoloUtente, bersagioPotere);
    }

    @GetMapping ("/getVivi")
    public ArrayList<Personaggio> getVivi(@RequestParam(value = "id_partita") int id_partita){
        return UsaPotereRepository.getPersonaggiVivi(id_partita);
    }

}
