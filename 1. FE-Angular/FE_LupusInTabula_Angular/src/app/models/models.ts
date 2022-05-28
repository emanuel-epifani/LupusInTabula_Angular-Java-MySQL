
export interface StartPartita {
  ruolo: string,
  arrayPersonaggi?: Personaggio[]
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


