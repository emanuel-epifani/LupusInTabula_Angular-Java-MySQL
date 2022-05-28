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
  nomeUtente?: string = this.partita.nomeUtente
  personaggiVivi?: Personaggio[] = this.partita.personaggiVivi
  //voto utente
  bersaglio =""
  //rotte
  router: any;

  constructor(
    public partita : PartitaService
  ) { }

  ngOnInit(): void {
        //check se partita finita
        if(this.partita.partitaFinita == true){
          this.router.navigateByUrl('endPartita');
        }
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
