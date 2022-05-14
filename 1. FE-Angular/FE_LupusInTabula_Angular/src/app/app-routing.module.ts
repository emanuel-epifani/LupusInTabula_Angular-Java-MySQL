import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EndPartitaComponent } from './components/end-partita/end-partita.component';
import { GiornoComponent } from './components/giorno/giorno.component';
import { NotteComponent } from './components/notte/notte.component';
import { StartPartitaComponent } from './components/start-partita/start-partita.component';

const routes: Routes = [
  {path:'', redirectTo:'/startPartita', pathMatch:'full'},
  {path:'startPartita', component:StartPartitaComponent},
  {path:'giorno', component:GiornoComponent},
  {path:'notte', component:NotteComponent},
  {path:'endPartita', component:EndPartitaComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
