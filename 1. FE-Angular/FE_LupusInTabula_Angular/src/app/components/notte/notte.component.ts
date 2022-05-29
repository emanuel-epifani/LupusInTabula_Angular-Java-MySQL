import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { delay } from 'rxjs';
import { Location } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { EsitoNotte, Personaggio } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';

@Component({
  selector: 'app-notte',
  templateUrl: './notte.component.html',
  styleUrls: ['./notte.component.scss']
})
export class NotteComponent implements OnInit {
//voto utente
bersaglio?:string
// x esitoNotte
morto?:string
indagato? = this.partita.indagato
//x mostrare la view con la votazione o con il risultato della votazione
votazioneNotte?: boolean
esitoNotte?: boolean
//rotte
  

  constructor(
    public partita : PartitaService,
    private router: Router
  ) { }

  ngOnInit(): void {
    //check se partita finita
    this.partita.checkIfEndPartita()
    //mostro la votazione e nascondo l'esito
    this.votazioneNotte = true 
    this.esitoNotte = false 
    this.morto = ''
    this.indagato =''
    this.bersaglio =''

    console.log("--------------------- NOTTE -----------------------");
    console.log("Notte--NOME utente =" + this.partita.nomeUtente)
    console.log("Notte--RUOLO utente= "+this.partita.ruoloUtente)
    console.log("Notte--partita FINITA= " +this.partita.partitaFinita);
    console.log(this.partita.personaggiVivi)
    
    //..se sono un Contadino/Indemoniato -> faccio votare random e invio al "Giorno"
    if(this.partita.ruoloUtente == "Contadino" || this.partita.ruoloUtente =="Indemoniato" ){
      this.eseguiNotte()
    }
  }

  // se sono.. Lupo / Veggente / Guardia del corpo
  usaPotere(mioRuolo: string, giocatoreIndicato: string) {
    return this.partita.usaPotere(mioRuolo, giocatoreIndicato).subscribe( response => {
      this.morto= response.morto
      console.log("Durante la notte è stato ucciso "+this.morto);
      //..tolgo il morto dall'array dei personaggi vivi
      for (let i = 0; i < this.partita.personaggiVivi!.length; i++) {
        if(this.partita.personaggiVivi![i].nome==this.morto){
          this.partita.personaggiVivi![i].alive= false
        }
      }
      this.indagato = response.indagato
      //mostro il div con l'esito della notte
      this.votazioneNotte= false
      this.esitoNotte = true 
      //delay x dar tempo far leggere esito votazione note
      setTimeout(() => {
        //altrimenti continuo a giocare
        this.router.navigateByUrl('/giorno')
      }, 2800);
    })
  }

  //se sono.. un Contadino/Indemoniato -> faccio votare random e invio al "Giorno"
  eseguiNotte() {
    this.partita.eseguiNotte().subscribe( response => {
      this.morto= response.morto
      console.log("Durante la notte è stato ucciso "+this.morto);
      //..tolgo il morto dall'array dei personaggi vivi
      for (let i = 0; i < this.partita.personaggiVivi!.length; i++) {
        if(this.partita.personaggiVivi![i].nome==this.morto){
          this.partita.personaggiVivi![i].alive= false
        }
      }
      //delay x dar tempo far leggere esito votazione note      
      setTimeout(() => {
        //altrimenti continuo a giocare
        this.router.navigateByUrl('/giorno')
      }, 2800);
    })
  }





}
