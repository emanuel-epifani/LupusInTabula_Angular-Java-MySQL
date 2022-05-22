import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EsitoNotte, Personaggio, StartPartita } from '../models/models';

@Injectable({
  providedIn: 'root'
})

export class PartitaService {
  partitaFinita = false
  ruoloUtente = ""
  personaggiVivi: Personaggio[] = [] //array di oggetti
  nomiPersonaggiVivi: String[] = [] //array di nomi

  constructor(
    private http: HttpClient
  ) { }

  /** - invio il NOME dell'utente
   * - return RUOLO che gli è capitato e ARRAY di PERSONAGGI*/
  startPartita(nomeUtente: String): Observable<StartPartita> {
    return this.http.post<StartPartita>('api/contacts', nomeUtente);
  }

  /** Notte: se sono: Lupo / Guardia del corpo / Veggente:
   * - passo il mio RUOLO e il GIOCATORE INDICATO
   * - return (eventuale) MORTO ed (eventuale) INDAGATO*/
  usaPotere(mioRuolo: String, giocatoreIndicato: String) : Observable<EsitoNotte> {
    return this.http.get<EsitoNotte>('api/contacts');
  }

  /** Notte: se sono: Contadino / Indemoniato:
   * - non passo niente, ma faccio eseguire la notte
   * - return */
  eseguiNotte() : Observable<EsitoNotte> {
    return this.http.get<EsitoNotte>('api/contacts');
  }

  /** Giorno:
   * - return: MORTO */
  vota(personaVotata : String) :Observable<String> {
    return this.http.post<String>('api/contacts',personaVotata);
  }


}
