import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { delay } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { NewsModalComponent } from '../news-modal/news-modal.component';

export interface Category {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  categories: Category[] = [
    { value: 'science', viewValue: 'science' },
    { value: 'entertainment', viewValue: 'entertainment' },
    { value: 'general', viewValue: 'general' },
    { value: 'health', viewValue: 'health' },
    { value: 'business', viewValue: 'business' },
    { value: 'sports', viewValue: 'sports' },
    { value: 'technology', viewValue: 'technology' }
  ]

  private API_KEY = "47f7a1ea42de4ac0a95e5c606fd56904";
  showResultsDiv: boolean = false;
  data = [];
  ghosts = [];
  public passTheURL: any;

  constructor(private httpClient: HttpClient, public dialog: MatDialog) { }

  makeTheRequestAndGetData(formValue) {
    return this.httpClient.get(`https://newsapi.org/v2/top-headlines?category=${formValue}&
   language=en&country=us&sortBy=publishedAt&apiKey=${this.API_KEY}`).pipe(delay(3000)).subscribe((data) => {
      console.log(data['articles']);
      this.data = data['articles'];
      this.showResultsDiv = false;
    });

  }

  searchButtonClicked(formValue) {
    this.ghosts = new Array(30);
    this.showResultsDiv = true;
    this.makeTheRequestAndGetData(formValue);
  }

  ngOnInit() {

  }

  openDialog(urlObject) {

    const dialogRef = this.dialog.open(NewsModalComponent, {
      data: { url: urlObject.url },
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

}
