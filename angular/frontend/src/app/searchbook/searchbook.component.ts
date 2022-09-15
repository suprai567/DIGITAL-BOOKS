import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import { BookService } from   '../book.service'

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.scss']
})
export class SearchbookComponent implements OnInit {
  todaysDate: Date = new Date();
  //author:Author = new Author (1,"Supriya",25,"sup123@gmail.com");
  book:Book= new Book("Bhagat", "2States","comic","Rupa Publication",134,"Chetan",this.todaysDate,true);
  categoryList: any = ['comic', 'horror', 'action', 'drama', 'adventure'];
  books: any = []
  category: String ='Comic';
  author: String = 'Chetan';
  price: number = 134;
  publisher: String = 'Rupa Publication';
  constructor(public bookService:BookService) { }

  ngOnInit(): void {
  }
  search(){
    console.log("clicked");
    const observable = this.bookService.searchBooks(this.author, this.category, this.price, this.publisher);
    observable.subscribe((books)=>{
      console.log(books);
      this.books = books;
    })
  }

}
