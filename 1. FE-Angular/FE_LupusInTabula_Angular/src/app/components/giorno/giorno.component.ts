import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { async } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Personaggio } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';

@Component({
  selector: 'app-giorno',
  templateUrl: './giorno.component.html',
  styleUrls: ['./giorno.component.scss']
})
export class GiornoComponent implements OnInit {  
  //x mostrare la view con la votazione o con il risultato della votazione
  votazioneGiorno?: boolean
  esitoGiorno?: boolean
  // x esitoNotte
  morto?:string
  //voto utente
  bersaglio?:string
 

  constructor(
    public partita : PartitaService,
    private router : Router
  ) { }

  ngOnInit(): void {
    //check se partita finita
    this.partita.checkIfEndPartita()
    //mostro la votazione e nascondo l'esito
    this.votazioneGiorno = true
    this.esitoGiorno = false
    this.morto = ''

      console.log("--------------------- GIORNO -----------------------");
      console.log("Giorno--NOME utente = " + this.partita.nomeUtente)
      console.log("Giorno--RUOLO utente = "+this.partita.ruoloUtente)
      console.log("Giorno--partita FINITA= " +this.partita.partitaFinita);
      console.log(this.partita.personaggiVivi)
  }

  vota(personaVotata  : string)  {
    //nascondo la votazione e mostro l'esito
    this.votazioneGiorno = false
    this.esitoGiorno = true

    return this.partita.vota(personaVotata).subscribe( response => {
      this.morto = response.piùvotato
      console.log(response);
      console.log("Durante il giorno è stato ucciso "+this.morto);
      
      //..togli il morto dall'array dei personaggi vivi
      for (let i = 0; i < this.partita.personaggiVivi!.length; i++) {
        if(this.partita.personaggiVivi![i].nome==this.morto){
          this.partita.personaggiVivi![i].alive= false
        }
      }
      
      setTimeout(() => {
        //altrimenti continuo a giocare
        this.router.navigateByUrl('/notte')
      }, 2800);


    })
  }




}


