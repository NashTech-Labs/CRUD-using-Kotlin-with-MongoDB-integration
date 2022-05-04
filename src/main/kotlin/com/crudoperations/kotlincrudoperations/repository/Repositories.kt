package com.crudoperations.kotlincrudoperations.repository

import com.crudoperations.kotlincrudoperations.entities.Book
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepositories : MongoRepository<Book,String>