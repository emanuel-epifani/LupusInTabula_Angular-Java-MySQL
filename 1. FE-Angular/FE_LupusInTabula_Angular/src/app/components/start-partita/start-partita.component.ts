import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StartPartita } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';


@Component({
  selector: 'app-start-partita',
  templateUrl: './start-partita.component.html',
  styleUrls: ['./start-partita.component.scss']
})
export class StartPartitaComponent implements OnInit {

  constructor(
    private partita : PartitaService
  ) { }

  ngOnInit(): void {
  }


  startPartita(nomeUtente: String) : Observable<StartPartita> {
    return this.partita.startPartita(nomeUtente)
  }

}
