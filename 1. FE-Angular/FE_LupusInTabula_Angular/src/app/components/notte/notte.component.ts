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
bersaglio =""
// x esitoNotte
morto? : string= ""
indagato?: string = ""
//x mostrare o meno la view con il risultato della votazione post "click"
esitoNotte?: boolean
//rotte
router: AppRoutingModule | null | undefined;
  

  constructor(
    public partita : PartitaService,
    private location: Location
  ) { }

  ngOnInit(): void {
    console.log("NOME utente =" + this.partita.nomeUtente)
    console.log("RUOLO utente= "+this.partita.ruoloUtente)
    //check se partita finita
    if(this.partita.partitaFinita == true){
      //this.router!.navigateByUrl('endPartita');
    }

    //nasconodo il div con scritto l'esito della notte
    this.esitoNotte = false 
    this.morto = ''
    this.indagato =''
    this.bersaglio =''

    setTimeout(() => {
     //..se sono un contadino/indemoniato -> faccio votare random e invio al "Giorno"
     if(this.partita.ruoloUtente == "Contadino" || this.partita.ruoloUtente =="Indemoniato" ){
      this.eseguiNotte()
    }
    console.log("ruolo utente ", this.partita.ruoloUtente);
    }, 4000);


    
  }

  // se sono.. Lupo / Veggente / Guardia del corpo
  usaPotere(mioRuolo: string, giocatoreIndicato: string) {
    return this.partita.usaPotere(mioRuolo, giocatoreIndicato).subscribe( response => {
      this.morto= response.morto
      this.indagato = response.indagato
      //mostro il div con l'esito della notte
      this.esitoNotte = true 
      //delay x dar tempo far leggere esito votazione note
      console.log("sono nella rx dell'usaPotere")
      window.location.replace('http://localhost:4200/giorno')
    })
  }

  //..se sono un contadino/indemoniato -> faccio votare random e invio al "Giorno"
  eseguiNotte() {
    this.partita.eseguiNotte().subscribe( response => {
      console.log("sono nella rx dell'esegui notte")
      //delay x dar tempo far leggere esito votazione note      
      setTimeout(() => {
        //this.router.navigateByUrl('giorno');
        window.location.replace('http://localhost:4200/giorno')
      }, 5000);
    })
  }

}
