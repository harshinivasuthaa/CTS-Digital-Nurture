class Book{
    int bookId;
    String title;
    String author;

    Book(int Id, String title, String author){
        this.bookId=Id;
        this.title=title;
        this.author=author;
    }

    void display(){
        System.out.println(bookId+" "+title+" "+author);
    }
}