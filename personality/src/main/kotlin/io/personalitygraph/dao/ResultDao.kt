package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Result
import org.koin.core.component.KoinApiExtension

interface ResultDao : NodeDao<Result>

@KoinApiExtension
class ResultDaoImpl : GenericDao<Result>(), ResultDao {
    override fun getEntityType(): Class<Result> {
        return Result::class.java
    }
}