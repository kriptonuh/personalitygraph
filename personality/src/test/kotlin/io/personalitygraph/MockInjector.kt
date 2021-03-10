package io.personalitygraph

import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module

object MockInjector {
    fun mockInjections(item: ModuleDeclaration) {
        GlobalContext.getOrNull()?.let { stopKoin() }

        startKoin {
            modules(
                module(createdAtStart = true) {
                    apply(item)
                }
            )
        }
    }
}