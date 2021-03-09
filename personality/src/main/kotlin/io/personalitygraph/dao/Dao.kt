package io.personalitygraph.dao

import io.personalitygraph.models.DomainModel

interface Dao<T : DomainModel> {

    fun findAll(): Iterable<T>
    fun find(id: Long): T
    fun delete(id: Long)
    fun createOrUpdate(vararg items: T)
    fun createOrUpdate(item: T): T
}