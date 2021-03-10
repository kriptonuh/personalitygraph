package io.personalitygraph.dao

import io.personalitygraph.models.nodes.PersonalResult

interface PersonalResultDao : NodeDao<PersonalResult>

class PersonalResultDaoImpl : GenericDao<PersonalResult>(), PersonalResultDao {
    override fun getEntityType(): Class<PersonalResult> {
        return PersonalResult::class.java
    }
}