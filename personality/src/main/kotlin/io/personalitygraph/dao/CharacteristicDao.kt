package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Characteristic

interface CharacteristicDao : NodeDao<Characteristic>

class CharacteristicDaoImpl : GenericDao<Characteristic>(), CharacteristicDao {
    override fun getEntityType(): Class<Characteristic> {
        return Characteristic::class.java
    }
}