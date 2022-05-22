import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Personaggio, StartPartita } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';


@Component({
  selector: 'app-start-partita',
  templateUrl: './start-partita.component.html',
  styleUrls: ['./start-partita.component.scss']
})
export class StartPartitaComponent implements OnInit {
  router: any;


  constructor(
    private partita : PartitaService
  ) { }

  ngOnInit(): void {
  }


  startPartita(nomeUtente: string) {
    return this.partita.startPartita(nomeUtente).subscribe( response => {
      this.partita.ruoloUtente = response.ruolo
      this.partita.personaggiVivi = response.personaggi
      this.router.navigateByUrl('notte');
    })
  }

}
