package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Test

interface TestDao : NodeDao<Test>

class TestDaoImpl : GenericDao<Test>(), TestDao {
    override fun getEntityType(): Class<Test> {
        return Test::class.java
    }
}