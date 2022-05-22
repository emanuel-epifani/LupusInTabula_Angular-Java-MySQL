
export interface StartPartita {
  ruolo: string,
  personaggi?: Personaggio[]
}


export interface Personaggio {
  nome: string,
  ruolo: string,
  isAlive: boolean
}

export interface EsitoNotte {
  morto?: string,
  indagato?: string
}

