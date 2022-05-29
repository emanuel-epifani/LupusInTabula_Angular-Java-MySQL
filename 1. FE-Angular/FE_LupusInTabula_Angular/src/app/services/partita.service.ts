import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EsitoNotte, EsitoVoto, Personaggio, StartPartita } from '../models/models';

@Injectable({
  providedIn: 'root'
})

export class PartitaService {
  partitaFinita = false
  ruoloUtente?: string
  nomeUtente?: string
  personaggiVivi?: Personaggio[] = [] //array di oggetti (TIPO di personaggio)
  
  morto? :string
  indagato? :string 

  constructor(
    private http: HttpClient,
    private router : Router
  ) { }

  /** - invio il NOME dell'utente
   * - return RUOLO che gli è capitato e ARRAY di PERSONAGGI*/
  startPartita(nomeUtente: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8090/StartPartita?nome=${nomeUtente}`);  
}

  /** Notte: se sono: Lupo / Guardia del corpo / Veggente:
   * - passo il mio RUOLO e il GIOCATORE INDICATO
   * - return (eventuale) MORTO ed (eventuale) INDAGATO*/
  usaPotere(mioRuolo: string, giocatoreIndicato: string) : Observable<any> {
    return this.http.get<any>(`http://localhost:8090/usaPotere?ruolo=${mioRuolo}&nome=${giocatoreIndicato}`);
  }

  /** Notte: se sono: Contadino / Indemoniato:
   * - non passo niente, ma faccio eseguire la notte
   * - return */
  eseguiNotte() : Observable<any> {
    return this.http.get<any>('http://localhost:8090/eseguiNotte');
  }

  /** Giorno:
   * - return: MORTO */
  vota(personaVotata : string) :Observable<EsitoVoto> {
    return this.http.get<any>(`http://localhost:8090/vota?bersaglio=${personaVotata}`);
  }


  //controlle se la partita è finita
  checkIfEndPartita(){
    //la partita è finita se..
    //1. sn morto io -> ..redirect EndPartita
    for (let i = 0; i < this.personaggiVivi!.length; i++) {
      if(this.personaggiVivi![i].nome == this.nomeUtente){
        if(this.personaggiVivi![i].alive == false){
          this.partitaFinita = true
          console.log("La partita è finita, sei morto te");
          console.log("E' morto "+this.personaggiVivi![i].nome);
          //delay x far leggere esito votazione
          setTimeout(() => {
            this.router.navigateByUrl('/endPartita')
          }, 2500);
        }
      }
    }
    //2. è morto il lupo -> ..redirect EndPartita
    for (let i = 0; i < this.personaggiVivi!.length; i++) {
      if(this.personaggiVivi![i].ruolo == "Lupo"){
        if(this.personaggiVivi![i].alive == false){
          this.partitaFinita = true
          console.log("La partita è finita, è morto il lupo");
          console.log("Il "+this.personaggiVivi![i].ruolo+" è' morto");
          //delay x far leggere esito votazione
          setTimeout(() => {
            this.router.navigateByUrl('/endPartita')
          }, 2500);
        }
      }
      
    }
    //3. sn rimasti solo 2 buoni in vita -> ..redirect EndPartita
    let countBuoniVivi =0
    //conto il totale di buoniVivi
    for (let i = 0; i < this.personaggiVivi!.length; i++) {
      if(this.personaggiVivi![i].ruolo == "Contadino" ||
        this.personaggiVivi![i].ruolo == "Veggente" ||
        this.personaggiVivi![i].ruolo == "Guardia_del_corpo"||
        this.personaggiVivi![i].ruolo == "Giudice"){
        if(this.personaggiVivi![i].alive == true)
        countBuoniVivi++
      }
    }//se meno di 3 finita
    if(countBuoniVivi<3){
      this.partitaFinita = true
      console.log("La partita è finita, sono rimasti solo due buoni");
      //delay x far leggere esito votazione
      setTimeout(() => {
        this.router.navigateByUrl('/endPartita')
      }, 2500);
    }
  }

}
