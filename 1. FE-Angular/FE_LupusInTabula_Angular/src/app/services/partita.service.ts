import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EsitoNotte, Personaggio, StartPartita } from '../models/models';

@Injectable({
  providedIn: 'root'
})

export class PartitaService {
  partitaFinita = false
  ruoloUtente = ''
  nomeUtente?: string
  personaggiVivi?: Personaggio[] //array di oggetti (TIPO di personaggio)
  
  morto = ''
  indagato = ''
  
  constructor(
    private http: HttpClient
  ) { }

  /** - invio il NOME dell'utente
   * - return RUOLO che gli è capitato e ARRAY di PERSONAGGI*/
  startPartita(nomeUtente: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/StartPartita?nome=${nomeUtente}`, nomeUtente);  
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
  vota(personaVotata : string) :Observable<any> {
    return this.http.post<any>(`http://localhost:8090/vota?bersaglio=${personaVotata}`,personaVotata);
  }


}
