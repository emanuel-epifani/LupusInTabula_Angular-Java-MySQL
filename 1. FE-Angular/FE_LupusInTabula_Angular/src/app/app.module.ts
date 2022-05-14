import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StartPartitaComponent } from './components/start-partita/start-partita.component';
import { NotteComponent } from './components/notte/notte.component';
import { GiornoComponent } from './components/giorno/giorno.component';
import { EndPartitaComponent } from './components/end-partita/end-partita.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    StartPartitaComponent,
    NotteComponent,
    GiornoComponent,
    EndPartitaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
