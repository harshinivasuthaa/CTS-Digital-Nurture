class Library{
    Book[] book;

    Library(Book[] book){
        this.book=book;
    }

    Book linearSearch(String title){
        for(Book b:book){
            if(b.title.equalsIgnoreCase(title))
                return b;
        }
        return null;
    }

    Book binarySearch(String title){

        int low = 0;
        int high = book.length - 1;

        while (low <= high){

            int mid = (low + high) / 2;

            int compare = book[mid].title.compareToIgnoreCase(title);

            if (compare == 0) {
                return book[mid];
            }

            if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
