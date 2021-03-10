package io.personalitygraph.dao

import io.personalitygraph.models.DomainModel

interface NodeDao<T : DomainModel> {
    var defaultDepth: Int

    fun findAll(depth: Int = defaultDepth): Iterable<T>
    fun find(id: Long, depth: Int = defaultDepth): T
    fun delete(id: Long, depth: Int = defaultDepth)
    fun createOrUpdate(vararg items: T, depth: Int = defaultDepth)
    fun createOrUpdate(item: T, depth: Int = defaultDepth): T
}