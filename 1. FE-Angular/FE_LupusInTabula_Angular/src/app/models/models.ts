
export interface Personaggio {
  nome: String,
  ruolo: String,
  isAlive: boolean
}

export interface EsitoNotte {
  morto?: String,
  indagato?: String
}

export interface StartPartita {
  ruolo?: String,
  personaggi?: Personaggio[]
}
