package com.crudoperations.kotlincrudoperations.entities

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Books")
class Book(
    var id: String? = ObjectId().toHexString(),
    var serialno: String,
    var title: String
)
