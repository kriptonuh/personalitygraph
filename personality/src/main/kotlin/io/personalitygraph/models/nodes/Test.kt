package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import org.neo4j.ogm.annotation.*

/**
 * example - "IQ test"
 */
@NodeEntity
class Test(
    @Property var name: String? = "",
    @Property var description: String? = "",
    @Relationship(type = "CONTAINS", direction = Relationship.OUTGOING)
    var questions: MutableSet<Question> = mutableSetOf(),
    @Relationship(type = "ADMITS", direction = Relationship.OUTGOING)
    var possibleResults: MutableSet<Result> = mutableSetOf(),
    @Relationship(type = "REQUIRES", direction = Relationship.OUTGOING)
    var requiredResults: MutableSet<Result> = mutableSetOf()
) : DomainModel() {


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

    data class Builder(
        private var name: String? = "",
        private var description: String? = "",
        private var questions: MutableSet<Question> = mutableSetOf(),
        private var possibleResults: MutableSet<Result> = mutableSetOf(),
        private var requiredResults: MutableSet<Result> = mutableSetOf(),
    ) {
        fun name(name: String) = apply { this.name = name }
        fun description(description: String) = apply { this.description = description }
        fun question(question: Question) = apply { this.questions.add(question) }
        fun questions(vararg questions: Question) = apply { this.questions.addAll(questions) }
        fun possibleResult(result: Result) = apply { this.possibleResults.add(result) }
        fun possibleResults(vararg results: Result) = apply { this.possibleResults.addAll(results) }
        fun requires(result: Result) = apply { this.requiredResults.add(result) }
        fun requires(vararg results: Result) = apply { this.requiredResults.addAll(results) }

        fun build(): Test {
            return Test(name, description, questions, possibleResults, requiredResults)
        }
    }
}
