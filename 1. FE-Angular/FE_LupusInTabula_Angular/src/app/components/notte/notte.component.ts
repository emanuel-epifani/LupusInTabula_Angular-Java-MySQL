import { Component, OnInit } from '@angular/core';
import { Personaggio } from 'src/app/models/models';

@Component({
  selector: 'app-notte',
  templateUrl: './notte.component.html',
  styleUrls: ['./notte.component.scss']
})
export class NotteComponent implements OnInit {
ruoloUtente = ""
personaggiVivi: Personaggio[] = []


  constructor() { }

  ngOnInit(): void {
  }

}
