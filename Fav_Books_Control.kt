package com.example.zadania_z_mobilnych_1

data class Book(val title: String, val author: String, val year: Int)

object BooksList{
    var booksList = mutableListOf(
        Book("Pride and Prejudice", "Jane Austen", 1813),
        Book("To Kill a Mockingbird", "Harper Lee", 1960),
        Book("1984", "George Orwell", 1949),
        Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
        Book("Harry Potter and the Sorcerer’s Stone", "J.K. Rowling", 1997),
        Book("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien", 1954),
        Book("The Catcher in the Rye", "J.D. Salinger", 1951),
        Book("The Alchemist", "Paulo Coelho", 1988),
        Book("The Hunger Games", "Suzanne Collins", 2008),
        Book("The Da Vinci Code", "Dan Brown", 2003)
    )

    fun GetTitles(): List<Book>{
        return booksList
    }
}

object BooksControl{
    var FavBooks = BooksList.GetTitles()
    var NumberOfBooks = FavBooks.size

    fun addBook(AddBook: Book){
        BooksList.booksList.add(AddBook)
    }

    fun getBooks(){


        for(Favbook in FavBooks){
            println("${Favbook.title},${Favbook.author}, ${Favbook.year}")
        }
    }

    fun SortBooks(){
        var sortedBooks = FavBooks.sortedBy { it.title }
        for(Favbook in sortedBooks){
            println("${Favbook.title},${Favbook.author}, ${Favbook.year}")
        }
    }

    fun FilterByAuthor(Author:String){
        var filtered = FavBooks.filter { it.author ==  Author}
        for(Favbook in filtered){
            println("${Favbook.title},${Favbook.author}, ${Favbook.year}")
        }
    }

    fun FilterByYear(Year: Int){
        var filtered = FavBooks.filter { it.year ==  Year}
        for(Favbook in filtered){
            println("${Favbook.title},${Favbook.author}, ${Favbook.year}")
        }
    }
}

fun main(){
    BooksControl.getBooks()
    BooksControl.SortBooks()
    BooksControl.FilterByAuthor("Harper Lee")
    BooksControl.FilterByYear(2008)
}