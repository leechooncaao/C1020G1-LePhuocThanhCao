import { Component, Input, OnInit } from '@angular/core';
import { IArticle } from './../../models/Article';

@Component({
  selector: 'article-item',
  templateUrl: './article-item.component.html',
  styleUrls: ['./article-item.component.css']
})
export class ArticleItemComponent implements OnInit {
  @Input() article : IArticle;

  constructor() { }

  ngOnInit(): void {
  }

}
