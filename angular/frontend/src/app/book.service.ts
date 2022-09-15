import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Book from './entity/Book';
import BookDetails from './entity/BookDetails';
const API_URL ="http://localhost:8082/digitalbooks";
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(public client:HttpClient) { }

  saveBook(book: Book){
    return this.client.post(API_URL,book);
  }

  searchBooks(author: String, category: String, price: number, publisher: String){
    return this.client.get(API_URL + "/books/search?category=" + category + 
    "&author=" + author + "&price=" + price + "&publisher=" + publisher);
  }
  // buyBook(bookDetails: BookDetails){
  //   return this.client.get(API_URL + "/books/buy");
  // }
  getAllPurchaseBooks(emailId: String){
    return this.client.get(API_URL + "/reader/books");
  }

  
}
