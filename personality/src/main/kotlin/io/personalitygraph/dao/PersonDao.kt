package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Person

interface PersonDao : NodeDao<Person>

class PersonDaoImpl : GenericDao<Person>(), PersonDao {
    override fun getEntityType(): Class<Person> {
        return Person::class.java
    }
}