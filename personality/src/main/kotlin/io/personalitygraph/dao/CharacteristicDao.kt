package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Characteristic
import org.koin.core.component.KoinApiExtension

interface CharacteristicDao : NodeDao<Characteristic>

@KoinApiExtension
class CharacteristicDaoImpl : GenericDao<Characteristic>(), CharacteristicDao {
    override fun getEntityType(): Class<Characteristic> {
        return Characteristic::class.java
    }
}