import { Component, OnInit } from '@angular/core';
import { Personaggio } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';

@Component({
  selector: 'app-end-partita',
  templateUrl: './end-partita.component.html',
  styleUrls: ['./end-partita.component.scss']
})
export class EndPartitaComponent implements OnInit {


  constructor(
    public partita : PartitaService
  ) { }

  ngOnInit(): void {
    console.log("--------------------- GIORNO -----------------------");
    console.log("Giorno--NOME utente = " + this.partita.nomeUtente)
    console.log("Giorno--RUOLO utente = "+this.partita.ruoloUtente)
    console.log("Giorno--partita FINITA= " +this.partita.partitaFinita);
    console.log(this.partita.personaggiVivi)
  }

}
