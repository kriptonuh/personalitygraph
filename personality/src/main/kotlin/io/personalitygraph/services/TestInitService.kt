package io.personalitygraph.services

import io.personalitygraph.dao.*
import io.personalitygraph.models.nodes.*
import io.personalitygraph.models.relations.Affects

interface InitService {
    fun init()
}

class TestInitService(
    val personDao: PersonDao,
    val personalResultDao: PersonalResultDao,
    val questionDao: QuestionDao,
    val testDao: TestDao,
    val answerDao: AnswerDao,
    val resultDao: ResultDao,
    val questionTypeDao: QuestionTypeDao,
    val characteristicDao: CharacteristicDao,
    val affectsDao: AffectsDao
) : InitService {

    override fun init() {
        val questionTypeRadio = QuestionType("radio")
        val questionTypeCheck = QuestionType("check")
        questionTypeDao.createOrUpdate(questionTypeRadio, questionTypeCheck)

        val rootTest = Test("Humanity test", "Defines if you're human")
        val humanity = Characteristic("Humanity")
        characteristicDao.createOrUpdate(humanity)

        val rootQuestion1 = Question("Are you human?", questionTypeRadio)
        val rootQuestion1Answer1 = Answer("Yes")
        val rootQuestion1Answer2 = Answer("No")
        answerDao.createOrUpdate(rootQuestion1Answer1, rootQuestion1Answer2)
        rootQuestion1.addAnswers(rootQuestion1Answer1, rootQuestion1Answer2)
        affectsDao.createOrUpdate(
            Affects(rootQuestion1Answer1, humanity, 1),
            Affects(rootQuestion1Answer2, humanity, 0)
        )
        questionDao.createOrUpdate(rootQuestion1)

        rootTest.addQuestion(rootQuestion1)

        val test1Result1 = Result("You're human", humanity, 1, 1, "Pure creature")
        val test1Result2 = Result("You're not a human", humanity, 1, 1, "What are you?")
        resultDao.createOrUpdate(test1Result1, test1Result2)
        rootTest.addResults(test1Result1, test1Result2)
        testDao.createOrUpdate(rootTest)

        val childTest = Test("Introversion/Extraversion test", "Defines your personality type")
        val personalityType = Characteristic("Personality type")
        characteristicDao.createOrUpdate(personalityType)

        val childQuestion1 = Question("Are you extravert?", questionTypeRadio)
        val childQuestion1Answer1 = Answer("Yes")
        val childQuestion1Answer2 = Answer("No")
        answerDao.createOrUpdate(childQuestion1Answer1, childQuestion1Answer2)
        childQuestion1.addAnswers(childQuestion1Answer1, childQuestion1Answer2)
        affectsDao.createOrUpdate(
            Affects(childQuestion1Answer1, personalityType, 1),
            Affects(childQuestion1Answer2, personalityType, 0)
        )
        questionDao.createOrUpdate(childQuestion1)

        val childQuestion2 = Question("Are you sure you're extravert?", questionTypeRadio)
        val childQuestion2Answer1 = Answer("Yes, definitely")
        val childQuestion2Answer2 = Answer("NO!!!")
        answerDao.createOrUpdate(childQuestion2Answer1, childQuestion2Answer2)
        childQuestion2.addAnswers(childQuestion2Answer1, childQuestion2Answer2)
        affectsDao.createOrUpdate(
            Affects(childQuestion2Answer1, personalityType, 1),
            Affects(childQuestion2Answer1, personalityType, 0)
        )
        questionDao.createOrUpdate(childQuestion1)

        val test2Result1 = Result("You're extravert", personalityType, 2, 2, "ENERGYY")
        val test2Result2 = Result("You're introvert", personalityType, 0, 0, "Bruh")
        val test2Result3 = Result("You're something in between", personalityType, 1, 1, "What are you?")
        childTest.addResults(test2Result1, test2Result2, test2Result3)
        childTest.addQuestions(childQuestion1, childQuestion2)
        resultDao.createOrUpdate(test2Result1, test2Result2, test2Result3)
        childTest.addRequiredResult(test1Result1)
        testDao.createOrUpdate(childTest)

        val person = Person("Dimon")
        val personalResult = PersonalResult(person, rootTest, mutableSetOf(test1Result1))
        personDao.createOrUpdate(person)
        personalResultDao.createOrUpdate(personalResult)
    }

}