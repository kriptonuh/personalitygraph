package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Person
import org.koin.core.component.KoinApiExtension

interface PersonDao : NodeDao<Person>

@KoinApiExtension
class PersonDaoImpl : GenericDao<Person>(), PersonDao {
    override fun getEntityType(): Class<Person> {
        return Person::class.java
    }
}