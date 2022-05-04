package com.crudoperations.kotlincrudoperations.controller
import com.crudoperations.kotlincrudoperations.repository.BookRepositories
import com.crudoperations.kotlincrudoperations.entities.Book
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController (val repo : BookRepositories)
{
    @PostMapping("/save")
    fun addBooks(@RequestBody book: Book): Book {
        return repo.save(book)
    }
    @GetMapping("/netbooks")
    fun getAllBooks() : List<Book>
    {
        return repo.findAll().toList()
    }
    @DeleteMapping("/delete/{Id}")
    fun deleteBooks(@PathVariable (value = "Id") Id: String): HttpStatus {
        repo.deleteById(Id)
        return HttpStatus.MOVED_PERMANENTLY
    }
    @PutMapping("/update/{Id}")
    fun updateBooks(@RequestBody book : Book, @PathVariable(value = "Id") Id: String): HttpStatus {

        val task = repo.findById(Id).orElse(null)
        val updatedCompany = repo.save(
        task.apply {
            serialno = book.serialno
            title = book.title
        }
    )
        return HttpStatus.CREATED
}

}

