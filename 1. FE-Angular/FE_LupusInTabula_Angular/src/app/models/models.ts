
export interface StartPartita {
  ruolo?: String,
  personaggi?: Personaggio[]
}


export interface Personaggio {
  nome: String,
  ruolo: String,
  isAlive: boolean
}

export interface EsitoNotte {
  morto?: string,
  indagato?: string
}

