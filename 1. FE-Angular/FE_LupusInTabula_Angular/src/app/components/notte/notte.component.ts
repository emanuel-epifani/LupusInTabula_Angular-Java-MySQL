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
personaggiVivi?: Personaggio[] = this.partita.personaggiVivi
//voto utente
bersaglio =""
// x esitoNotte
morto? : string= ""
indagato?: string = ""
//x mostrare o meno la view con il risultato della votazione post "click"
esitoNotte?: boolean

router: any;
  

  constructor(
    private partita : PartitaService
  ) { }

  ngOnInit(): void {
    //check se partita finita
    if(this.partita.partitaFinita == true){
      this.router.navigateByUrl('endPartita');
    }

    //nasconodo il div con scritto l'esito della notte
    this.esitoNotte = false 
    this.morto = ""
    this.indagato =""
    this.bersaglio =""

    //..se sono un contadino/indemoniato -> faccio votare random e invio al "Giorno"
    if(this.partita.ruoloUtente == "contadino"|| "indemoniato"){
      this.eseguiNotte()
    }
  }

  // se sono.. Lupo / Veggente / Guardia del corpo
  usaPotere(mioRuolo: string, giocatoreIndicato: string) {
    return this.partita.usaPotere(mioRuolo, giocatoreIndicato).subscribe( response => {
      this.morto= response.morto
      this.indagato = response.indagato
      //mostro il div con l'esito della notte
      this.esitoNotte = true 
      //delay x dar tempo far leggere esito votazione note
       delay(4000)
       this.router.navigateByUrl('giorno')
    })
  }

  //..se sono un contadino/indemoniato -> faccio votare random e invio al "Giorno"
  eseguiNotte() {
    this.partita.eseguiNotte().pipe(delay(3000)).subscribe( response => {
      this.router.navigateByUrl('giorno');
    })
  }

}
