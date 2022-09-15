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
  book:Book= new Book("Bhagat", "2States","Comic","Rupa Publication",134,"Chetan",this.todaysDate,true);
  categoryList: any = ['Comic','Drama', 'Science','Romance','Detective','Horror','Adventure'];  
  constructor(public bookService:BookService) { }
  ngOnInit(): void {
  }
  save() {
    console.log('Book Saved');
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
