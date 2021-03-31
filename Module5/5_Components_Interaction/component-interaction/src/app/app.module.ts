import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NameCardComponent } from './components/name-card/name-card.component';
import { ProgressBarComponent } from './components/progress-bar/progress-bar.component';
import { CountdownTimerComponent } from './components/countdown/countdown-timer/countdown-timer.component';
import { CountdownTimerAliasComponent } from './components/countdown/countdown-timer-alias/countdown-timer-alias.component';
import { CountdownTimerEventComponent } from './components/countdown/countdown-timer-event/countdown-timer-event.component';
import { CountdownTimerEventAliasComponent } from './components/countdown/countdown-timer-event-alias/countdown-timer-event-alias.component';
import { CountdownTimerGetSetComponent } from './components/countdown/countdown-timer-get-set/countdown-timer-get-set.component';
import { CountdownTimerOnchangesComponent } from './components/countdown/countdown-timer-onchanges/countdown-timer-onchanges.component';
import { RatingBarComponent } from './components/rating-bar/rating-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    NameCardComponent,
    ProgressBarComponent,
    CountdownTimerComponent,
    CountdownTimerAliasComponent,
    CountdownTimerEventComponent,
    CountdownTimerEventAliasComponent,
    CountdownTimerGetSetComponent,
    CountdownTimerOnchangesComponent,
    RatingBarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
