package io.personalitygraph.dao

import io.personalitygraph.models.nodes.PersonalResult
import org.koin.core.component.KoinApiExtension

interface PersonalResultDao : NodeDao<PersonalResult>

@KoinApiExtension
class PersonalResultDaoImpl : GenericDao<PersonalResult>(), PersonalResultDao {
    override fun getEntityType(): Class<PersonalResult> {
        return PersonalResult::class.java
    }
}