package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "IQ test"
 */
@NodeEntity
class Test(
    @Property var name: String,
    @Property var description: String? = ""
) {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Relationship(type = "CONTAINS", direction = Relationship.OUTGOING)
    var questions: MutableSet<Question> = mutableSetOf()

    @Relationship(type = "ADMITS", direction = Relationship.OUTGOING)
    var possibleResults: MutableSet<Result> = mutableSetOf()

    @Relationship(type = "REQUIRES", direction = Relationship.OUTGOING)
    var requiredResults: MutableSet<Result> = mutableSetOf()

    @Relationship(type = "RESULT_FOR", direction = Relationship.INCOMING)
    var personalResults: MutableSet<PersonalResult> = mutableSetOf()


    override fun toString(): String {
        return "Test(id=$id, name='$name'"
    }

    fun addQuestion(question: Question) {
        questions.add(question)
    }

    fun addQuestions(vararg newQuestions: Question) {
        questions.addAll(newQuestions)
    }

    fun addQuestions(newQuestions: Collection<Question>) {
        questions.addAll(newQuestions)
    }

    fun addResult(result: Result) {
        possibleResults.add(result)
    }

    fun addResults(vararg results: Result) {
        possibleResults.addAll(results)
    }

    fun addResults(results: Collection<Result>) {
        possibleResults.addAll(results)
    }
    fun addRequiredResult(result: Result) {
        requiredResults.add(result)
    }

    fun addRequiredResults(vararg results: Result) {
        requiredResults.addAll(results)
    }

    fun addRequiredResults(results: Collection<Result>) {
        requiredResults.addAll(results)
    }

}
