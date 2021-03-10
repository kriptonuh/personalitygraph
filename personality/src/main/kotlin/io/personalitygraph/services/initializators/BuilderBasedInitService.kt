package io.personalitygraph.services.initializators

import io.personalitygraph.dao.*
import io.personalitygraph.models.nodes.*
import io.personalitygraph.services.InitService
import org.slf4j.LoggerFactory


class BuilderBasedInitService(
    private val testDao: TestDao
) : InitService {

    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)

    override fun init() {
        val radioQuestion = QuestionType.Builder().typeName("radio").build()

        val humanity = Characteristic.Builder().name("Humanity").build()
        val personalityType = Characteristic.Builder().name("Introversion/Extraversion").build()

        val rootTestResult1 = Result.Builder()
            .resultText("You are human")
            .resultDescription("Pure creature...")
            .describesCharacteristic(humanity)
            .valueInterval(1, 1).build()

        val rootTestResult2 = Result.Builder()
            .resultText("You are not a human")
            .resultDescription("Congratulations")
            .describesCharacteristic(humanity)
            .valueInterval(0, 0)
            .conflictsWith(rootTestResult1).build()


        val rootTest = Test.Builder()
            .name("Humanity test")
            .description("Defines if you're human")
            .possibleResults(rootTestResult1, rootTestResult2)
            .question(
                Question.Builder()
                    .questionText("Are you human?")
                    .questionType(radioQuestion)
                    .applicableAnswers(
                        Answer.Builder()
                            .answerText("Yes")
                            .characteristic(humanity)
                            .value(1).build(),
                        Answer.Builder()
                            .answerText("No")
                            .characteristic(humanity)
                            .value(0).build()
                    ).build()
            ).build()


        val introvertResult = Result.Builder()
            .resultText("You are introvert")
            .resultDescription("Congratulations")
            .describesCharacteristic(personalityType)
            .valueInterval(0, 0).build()

        val extravertResult = Result.Builder()
            .resultText("You are extravert")
            .resultDescription("Why?")
            .describesCharacteristic(personalityType)
            .valueInterval(2, 2)
            .conflictsWith(introvertResult).build()

        val intermediateResult = Result.Builder()
            .resultText("You're mixed type")
            .resultDescription("You took the best from both")
            .describesCharacteristic(personalityType)
            .valueInterval(1, 1)
            .conflictsWith(introvertResult).build()

        val childTest = Test.Builder()
            .name("Personality type test")
            .description("Defines if you're introvert or extravert")
            .possibleResults(introvertResult, extravertResult, intermediateResult)
            .requires(rootTestResult1)
            .questions(
                Question.Builder()
                    .questionText("Are you extravert?")
                    .questionType(radioQuestion)
                    .applicableAnswers(
                        Answer.Builder()
                            .answerText("Yes, I am")
                            .characteristic(personalityType)
                            .value(1).build(),
                        Answer.Builder()
                            .answerText("No, I'm Introvert")
                            .characteristic(personalityType)
                            .value(0).build()
                    ).build(),
                Question.Builder()
                    .questionText("Are you sure you're extravert?")
                    .questionType(radioQuestion)
                    .applicableAnswers(
                        Answer.Builder()
                            .answerText("Definitely yes!")
                            .characteristic(personalityType)
                            .value(1).build(),
                        Answer.Builder()
                            .answerText("NO!!!")
                            .characteristic(personalityType)
                            .value(0).build()
                    ).build(),
            )
            .build()
        childTest.questions.forEach {
            logger.info("tetete $it")
        }

        testDao.createOrUpdate(rootTest, childTest)

        val dimon = Person.Builder()
            .name("Dimon")
            .personalResult(
                PersonalResult.Builder()
                    .forTest(rootTest)
                    .result(rootTestResult1)
                    .build()
            ).build()

        //personDao.createOrUpdate(dimon)
        //println(answerDao.createOrUpdate())
        //personDao.createOrUpdate(Person("Banzai"))
    }

}