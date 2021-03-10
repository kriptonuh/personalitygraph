package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Result

interface ResultDao : NodeDao<Result>

class ResultDaoImpl : GenericDao<Result>(), ResultDao {
    override fun getEntityType(): Class<Result> {
        return Result::class.java
    }
}