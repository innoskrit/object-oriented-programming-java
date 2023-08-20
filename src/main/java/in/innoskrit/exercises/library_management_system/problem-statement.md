## Library Management System

### Problem Statement:
Create a Library Management System that can handle books and patrons. The system should allow librarians to add, remove, and update books in the library. Patrons can borrow and return books. Each book has attributes like title, author, ISBN, and availability status. Patrons have attributes like name, membership ID, and a list of borrowed books.

### Functionality:

- Librarians can add new books to the library with details.
- Librarians can remove books from the library.
- Librarians can update book information.
- Patrons can borrow available books.
- Patrons can return books they've borrowed.
- Display a list of all available books.
- Display a list of borrowed books for each patron.

### Input and Output:
```java
Librarian librarian1 = new Librarian("L1", "John", true);
Librarian librarian2 = new Librarian("L2", "Sam", false);
Librarian librarian3 = new Librarian("L3", "Sam", false);

librarianService.addLibrarian(librarian1);
--> Librarian Added Successfully
        
librarianService.addLibrarian(librarian2);
--> Librarian Added Successfully

Book book1 = new Book("B1", "OOPs in Java", "O-Reilly", true);
Book book2 = new Book("B2", "Multithreading & Concurrency", "O-Reilly", true);

bookService.addBook(book1, librarian1);
--> Book Added Successfully
bookService.addBook(book2, librarian1);
--> Book Added Successfully

bookService.getAvailableBooks();
--> [Book{id='B2', title='Multithreading & Concurrency', author='O-Reilly', available=true}, Book{id='B1', title='OOPs in Java', author='O-Reilly', available=true}]

Patron patron1 = new Patron("P1", "Rick", new ArrayList<>());
Patron patron2 = new Patron("P2", "Clark", new ArrayList<>());

patronService.addPatron(patron1);
--> Patron Added Successfully
patronService.addPatron(patron2);
--> Patron Added Successfully

patronService.borrowBook("P1", "B1");
--> Book Borrowed Successfully
patronService.borrowBook("P1", "B2");
--> Book Borrowed Successfully

patronService.getBorrowedBooksByPatron("P1")
--> [Book{id='B1', title='OOPs in Java', author='O-Reilly', available=false}, Book{id='B2', title='Multithreading & Concurrency', author='O-Reilly', available=false}]

patronService.returnBook("P1", "B1");
--> Book Returned Successfully

bookService.getAvailableBooks();
--> [Book{id='B1', title='OOPs in Java', author='O-Reilly', available=true}]

patronService.borrowBook("P2", "B1");
--> Book Borrowed Successfully
patronService.borrowBook("P2", "B2");
--> Book Borrowed Failed

bookService.getAvailableBooks();
--> []
```