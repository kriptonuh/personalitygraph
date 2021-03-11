package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Test
import org.koin.core.component.KoinApiExtension

interface TestDao : NodeDao<Test>

@KoinApiExtension
class TestDaoImpl : GenericDao<Test>(), TestDao {
    override fun getEntityType(): Class<Test> {
        return Test::class.java
    }
}