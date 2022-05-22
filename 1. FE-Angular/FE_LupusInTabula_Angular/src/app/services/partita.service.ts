import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EsitoNotte, Personaggio, StartPartita } from '../models/models';

@Injectable({
  providedIn: 'root'
})

export class PartitaService {
  partitaFinita = false
  ruoloUtente = "contadino"
  personaggiVivi?: Personaggio[] = [] //array di oggetti (TIPO di personaggio)
  morto = ''
  indagato = ""
  
  constructor(
    private http: HttpClient
  ) { }

  /** - invio il NOME dell'utente
   * - return RUOLO che gli è capitato e ARRAY di PERSONAGGI*/
  startPartita(nomeUtente: string): Observable<StartPartita> {
    return this.http.post<StartPartita>('api/contacts', nomeUtente);
  }

  /** Notte: se sono: Lupo / Guardia del corpo / Veggente:
   * - passo il mio RUOLO e il GIOCATORE INDICATO
   * - return (eventuale) MORTO ed (eventuale) INDAGATO*/
  usaPotere(mioRuolo: string, giocatoreIndicato: string) : Observable<EsitoNotte> {
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
  vota(personaVotata : string) :Observable<string> {
    return this.http.post<string>('api/contacts',personaVotata);
  }


}
