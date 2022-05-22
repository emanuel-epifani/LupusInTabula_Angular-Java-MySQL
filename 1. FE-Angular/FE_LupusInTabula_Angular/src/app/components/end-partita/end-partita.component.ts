import { Component, OnInit } from '@angular/core';
import { Personaggio } from 'src/app/models/models';
import { PartitaService } from 'src/app/services/partita.service';

@Component({
  selector: 'app-end-partita',
  templateUrl: './end-partita.component.html',
  styleUrls: ['./end-partita.component.scss']
})
export class EndPartitaComponent implements OnInit {
  ruoloUtente = this.partita.ruoloUtente
  nomeUtente?: string = this.partita.nomeUtente
  personaggiVivi?: Personaggio[] = this.partita.personaggiVivi

  constructor(
    private partita : PartitaService
  ) { }

  ngOnInit(): void {
  }

}
