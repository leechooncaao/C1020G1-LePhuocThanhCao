import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelinesComponent } from './components/timelines/timelines.component';
import { YoutubePlaylistComponent } from './components/youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './components/youtube-player/youtube-player.component';
import { DictionaryDetailComponent } from './components/dictionary-detail/dictionary-detail.component';
import { DictionaryPageComponent } from './components/dictionary-page/dictionary-page.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    DictionaryDetailComponent,
    DictionaryPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
