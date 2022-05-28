import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Personaggio } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';

@Component({
  selector: 'app-giorno',
  templateUrl: './giorno.component.html',
  styleUrls: ['./giorno.component.scss']
})
export class GiornoComponent implements OnInit {
  nomeUtente?: String = this.partita.nomeUtente
  ruoloUtente?: String = this.partita.ruoloUtente
  personaggiVivi?: Personaggio[] = this.partita.personaggiVivi
  //voto utente
  bersaglio =""
  //rotte
  router: any;

  constructor(
    public partita : PartitaService
  ) { 
    //this.nomeUtente = this.partita.ruoloUtente?.subscribe()

  }

  ngOnInit(): void {
    console.log("PRIMA,nell'oninit");
    console.log("NOME utente =" + this.nomeUtente)
    console.log("RUOLO utente= "+this.partita.ruoloUtente)
    console.log("PARTITA FINITA =" + this.partita.partitaFinita)

    setTimeout(() => {
      console.log("DOPO,nel settimeout");
      console.log("NOME utente =" + this.nomeUtente)
      console.log("RUOLO utente= "+this.partita.ruoloUtente)
      console.log("PARTITA FINITA =" + this.partita.partitaFinita)
      //check se partita finita
      if(this.partita.partitaFinita == true){
        window.location.replace('http://localhost:4200/endPartita')
      }
    }, 200);

  }

  vota(personaVotata  : string){
    return this.partita.vota(personaVotata).subscribe( response => {
      this.partita.morto = response
      if(response!= ''){
      //togli il morto dall'array dei personaggi vivi

      }

      //se con qst in meno la partita risulta finita, manda a "endPartita"
    })
  }

}
