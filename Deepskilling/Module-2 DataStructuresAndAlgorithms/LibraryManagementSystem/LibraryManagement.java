class LibraryManagement{
    public static void main(String [] args){
        Book[] book={new Book(1, "Algorithms", "CLRS"),
                new Book(2, "Data Structures", "Mark"),
                new Book(3, "Java Basics", "James"),
                new Book(4, "Operating Systems", "Galvin")
        };
        
        Library lib =new Library(book);
        System.out.println("Linear Search:");

        Book b1=lib.linearSearch("Algorithms");
        if(b1!=null)
            b1.display();

        System.out.println("Binary Search:");
        Book b2=lib.binarySearch("Java Basics");
        if(b2!=null)
            b2.display();

    }
} 