
export interface StartPartita {
  ruolo: string,
  arrayPersonaggi?: Personaggio[]
}


export interface Personaggio {
  nome: string,
  ruolo: string,
  alive: boolean
}

export interface EsitoNotte {
  morto?: string,
  indagato?: string
}

export interface EsitoVoto {
  piùvotato?: string
}


