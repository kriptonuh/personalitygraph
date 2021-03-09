package io.personalitygraph.dao

interface Dao<T> {

    fun findAll(): Iterable<T>
    fun find(id: Long): T
    fun delete(id: Long)
    fun createOrUpdate(vararg items: T)
    fun createOrUpdate(item: T)
}