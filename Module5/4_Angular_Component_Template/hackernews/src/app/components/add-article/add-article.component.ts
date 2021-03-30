import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { IArticle } from './../../models/Article';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {
  title : string;
  url : string;
  @Output() addArticle : EventEmitter<IArticle> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    const article : IArticle = {
      title : this.title,
      url : this.url
    }

    this.addArticle.emit(article);

  }

}
