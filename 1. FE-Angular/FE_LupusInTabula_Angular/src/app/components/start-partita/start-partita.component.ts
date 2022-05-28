import { Component, OnInit } from '@angular/core';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { StartPartita } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';


@Component({
  selector: 'app-start-partita',
  templateUrl: './start-partita.component.html',
  styleUrls: ['./start-partita.component.scss']
})
export class StartPartitaComponent implements OnInit {
  router: AppRoutingModule | null | undefined;
  


  constructor(
    private partita : PartitaService
  ) { }

  ngOnInit(): void {
  }


  startPartita(nomeUtente: string) {
    return this.partita.startPartita( nomeUtente).subscribe( response => {
      this.partita.nomeUtente = nomeUtente
      this.partita.ruoloUtente = response.ruolo
      this.partita.personaggiVivi = response.arrayPersonaggi

      console.log("NOME utente =" + nomeUtente)
      console.log("RUOLO utente= "+this.partita.ruoloUtente)
      console.log(this.partita.personaggiVivi)

      //this.router.navigateByUrl('notte');
      //window.location.replace('notte')
      //this.router!.navigateByUrl('giorno')
    })
  }

}
