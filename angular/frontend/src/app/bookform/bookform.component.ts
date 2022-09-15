import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import { BookService } from   '../book.service'
@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})
export class BookformComponent implements OnInit {
  todaysDate: Date = new Date();
  //author:Author = new Author (1,"Supriya",25,"sup123@gmail.com");
  book:Book= new Book("Bhagat", "2States","comic","Rupa Publication",134,"Chetan",this.todaysDate,true);
  categoryList: any = ['comic', 'horror', 'action', 'drama', 'adventure'];
  constructor(public bookService:BookService) { }
  ngOnInit(): void {
  }
  save() {
    console.log('clicked');
    //Ajax call
    const observable = this.bookService.saveBook(this.book);
    observable.subscribe((response) => {//success handler
      console.log(response);
    },
      (error) => {//error handler
        alert('something went wrong');
      }
    )
  }
  

}
