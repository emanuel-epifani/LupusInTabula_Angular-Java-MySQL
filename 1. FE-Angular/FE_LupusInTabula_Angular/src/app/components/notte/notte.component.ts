import { Component, OnInit } from '@angular/core';
import { delay } from 'rxjs';
import { EsitoNotte, Personaggio } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';

@Component({
  selector: 'app-notte',
  templateUrl: './notte.component.html',
  styleUrls: ['./notte.component.scss']
})
export class NotteComponent implements OnInit {
ruoloUtente = this.partita.ruoloUtente
personaggiVivi: Personaggio[] = this.partita.personaggiVivi //array di oggetti
nomiPersonaggiVivi: String[] = this.partita.nomiPersonaggiVivi //array di nomi
morto? : string=""
indagato?: string = ""
router: any;

arrayProva: String[] = ["frfr","htht","juju"]
  

  constructor(
    private partita : PartitaService
  ) { }

  ngOnInit(): void {
    this.morto = ""
    this.indagato =""
    //check se sono un contadino/indemoniato o altro
    if(this.partita.ruoloUtente == "contadino"|| "indemoniato"){
      this.partita.eseguiNotte().pipe(delay(3000)).subscribe(response => {
        this.router.navigateByUrl('giorno');
      })
    }
    //check se partita finita
    
  }

  // se sono.. Lupo / Veggente / Guardia del corpo ->
  usaPotere(ruoloUtente: String, giocatoreIndicato: String) {
    ruoloUtente = this.ruoloUtente
    return this.partita.usaPotere(ruoloUtente,giocatoreIndicato).subscribe( response => {
       this.morto= response.morto
       this.indagato = response.indagato
    })
  }



}
