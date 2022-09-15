import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import { BookService } from '../book.service'

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.scss']
})
export class SearchbookComponent implements OnInit {
  todaysDate: Date = new Date();
  //author:Author = new Author (1,"Supriya",25,"sup123@gmail.com");
  book: Book = new Book("Bhagat", "2States", "Comic", "Rupa Publication", 134, "Chetan", this.todaysDate, true);
  books: any = [];
  categoryList: any = ['Comic','Drama', 'Science','Romance','Detective','Horror','Adventure'];
  //category: String = 'Comic';
  //author: String = 'Chetan';
  //price: number = 134;
  //publisher: String = 'Rupa Publication';
  constructor(public bookService: BookService) { }

  ngOnInit(): void {
  }
  search() {
    console.log("Book Searched");
    const observable = this.bookService.searchBooks(this.book.author, this.book.category, this.book.price, this.book.publisher);
    observable.subscribe((books) => {
      console.log(books);
      this.books = books;
    },
    (error) => {//error handler
      alert('something went wrong inside searchBook');
    })
    
  }

}
