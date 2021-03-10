package io.personalitygraph.dao

import io.personalitygraph.models.DomainModel
import kotlin.reflect.KClass

interface RelationDao {

    fun <T : DomainModel, S : DomainModel, E : DomainModel> findRelationshipBetween(
        resultType: KClass<T>,
        start: S,
        end: E
    ): T?

    fun <T : DomainModel> createOrUpdate(item: T, depth: Int = 0)
}

