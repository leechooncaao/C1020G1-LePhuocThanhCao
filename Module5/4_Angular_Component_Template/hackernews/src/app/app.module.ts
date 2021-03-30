import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { AddArticleComponent } from './components/add-article/add-article.component';
import { ArticleItemComponent } from './components/article-item/article-item.component';
import { LikeComponent } from './components/like/like.component';
import { AboutComponent } from './components/pages/about/about.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { AppRoutingModule } from './app-routing.module';
import { FooterComponent } from './components/layout/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticlesComponent,
    AddArticleComponent,
    ArticleItemComponent,
    LikeComponent,
    AboutComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
