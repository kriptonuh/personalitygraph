package io.personalitygraph.models

import io.personalitygraph.models.relations.*

object RelationTypes {
    const val AFFECTS = "AFFECTS"
    const val ACCEPTS = "ACCEPTS"
    const val ADMITS = "ADMITS"
    const val CONFLICTS = "CONFLICTS"
    const val CONTAINS_QUESTION = "CONTAINS"
    const val DESCRIBES = "DESCRIBES"
    const val EXPANDS = "EXPANDS"
    const val FOR_PERSON = "FOR_PERSON"
    const val HAS_OPTION = "HAS_OPTION"
    const val OF_TYPE = "OF_TYPE"
    const val RECEIVED = "RECEIVED"
    const val REQUIRES = "REQUIRES"
    const val RESULT_FOR = "RESULT_FOR"
    const val FOR_TEST = "FOR_TEST"

    val RELATION_TYPES_MAP = mapOf(
        Affects::class to AFFECTS,
        Accepts::class to ACCEPTS,
        Admits::class to ADMITS,
        Conflicts::class to CONFLICTS,
        ContainsQuestion::class to CONTAINS_QUESTION,
        Describes::class to DESCRIBES,
        Expands::class to EXPANDS,
        ForPerson::class to FOR_PERSON,
        HasOption::class to HAS_OPTION,
        OfType::class to OF_TYPE,
        Received::class to RECEIVED,
        Requires::class to REQUIRES,
        ResultFor::class to RESULT_FOR
    )
}
