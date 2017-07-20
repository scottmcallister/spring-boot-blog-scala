package com.example.microblogscala.repository

import com.example.microblogscala.domain.Entry
import org.springframework.data.repository.CrudRepository

trait EntryRepository extends CrudRepository[Entry, java.lang.Long]
