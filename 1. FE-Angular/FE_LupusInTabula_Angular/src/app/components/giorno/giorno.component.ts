import { Component, OnInit } from '@angular/core';
import { Personaggio } from 'src/app/models/models';

@Component({
  selector: 'app-giorno',
  templateUrl: './giorno.component.html',
  styleUrls: ['./giorno.component.scss']
})
export class GiornoComponent implements OnInit {
  ruoloUtente = ""
  personaggiVivi: Personaggio[] = []

  constructor() { }

  ngOnInit(): void {
  }

}
