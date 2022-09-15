export default class Book{
    constructor(public title:string, public logo: string,  
        public category:string, public publisher:string, public price:number, public author: String, public publishedDate:Date,
        public active:boolean){}
}