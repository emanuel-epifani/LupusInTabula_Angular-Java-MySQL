import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { StartPartita } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';


@Component({
  selector: 'app-start-partita',
  templateUrl: './start-partita.component.html',
  styleUrls: ['./start-partita.component.scss']
})
export class StartPartitaComponent implements OnInit {
  


  constructor(
    private partita : PartitaService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  startPartita(nomeUtente: string) {
    return this.partita.startPartita( nomeUtente).subscribe( response => {
      this.partita.nomeUtente = nomeUtente
      this.partita.ruoloUtente = response.ruolo
      this.partita.personaggiVivi = response.arrayPersonaggi

      console.log("------------START PARTITA-----------");
      console.log("SP--NOME utente =" + nomeUtente)
      console.log("SP--RUOLO utente= "+this.partita.ruoloUtente)
      console.log("SP--partita FINITA= " +this.partita.partitaFinita);
      console.log(this.partita.personaggiVivi)
      this.router.navigateByUrl('/notte')

    })
  }

}
