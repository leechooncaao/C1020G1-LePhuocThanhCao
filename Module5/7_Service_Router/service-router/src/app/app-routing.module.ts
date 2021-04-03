import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { DictionaryDetailComponent } from './components/dictionary-detail/dictionary-detail.component';
import { DictionaryPageComponent } from './components/dictionary-page/dictionary-page.component';
import { YoutubePlayerComponent } from './components/youtube-player/youtube-player.component';
import { YoutubePlaylistComponent } from './components/youtube-playlist/youtube-playlist.component';


const routes: Routes = [
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
        path: ':id',
        component: YoutubePlayerComponent
    }]
},
{
  path: 'dictionary',
  component: DictionaryPageComponent,
  children: [
    {
      path: ':key',
      component: DictionaryDetailComponent
    }
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
