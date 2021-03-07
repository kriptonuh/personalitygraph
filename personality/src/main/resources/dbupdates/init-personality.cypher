//INIT TEST DB
CREATE (radioQuestion:QuestionType {id: 1, type: 'radio'})
CREATE (checkboxQuestion:QuestionType {id: 2, type: 'checkbox'})

CREATE (question1:Question {id: 1, questionText: 'Are you extravert?'})
CREATE (question2:Question {id: 2, questionText: 'Are you sure you\'re extravert?'})
CREATE (question1)-[:OF_TYPE]->(radioQuestion)
CREATE (question2)-[:OF_TYPE]->(radioQuestion)

CREATE (answer1:Answer {id: 1, text: 'Yes, I\'m extravert', value: 1})
CREATE (answer2:Answer {id: 2, text: 'No, I\'m introvert', value: 1})
CREATE (answer3:Answer {id: 3, text: 'Yes, absolutely', value: 1})
CREATE (answer4:Answer {id: 4, text: 'NO!!!', value: 1})
CREATE
  (question1)-[:POSSIBLE_ANSWER]->(answer1),
  (question1)-[:POSSIBLE_ANSWER]->(answer2),
  (question2)-[:POSSIBLE_ANSWER]->(answer3),
  (question2)-[:POSSIBLE_ANSWER]->(answer4)

CREATE (intro_extra:Characteristic {id: 1, name: 'Personality type'})
CREATE
  (answer1)-[:AFFECTS]->(intro_extra),
  (answer2)-[:AFFECTS]->(intro_extra),
  (answer3)-[:AFFECTS]->(intro_extra),
  (answer4)-[:AFFECTS]->(intro_extra)

CREATE (result1:Result {id: 1, text: 'You are extravert', min: 2, max: 2})
CREATE (result2:Result {id: 2, text: 'You are introvert', min: 0, max: 0})
CREATE (result3:Result {id: 3, text: 'You\'re strange', min: 1, max: 1})
CREATE
  (result1)-[:DEFINES]->(intro_extra),
  (result2)-[:DEFINES]->(intro_extra),
  (result3)-[:DEFINES]->(intro_extra)

CREATE (test:Test {id: 1, name: 'Introversion/Extraversion', description: 'Defines your personality type'})
CREATE
  (test)-[:CONTAINS]->(question1),
  (test)-[:CONTAINS]->(question2),
  (test)-[:ADMITS]->(result1),
  (test)-[:ADMITS]->(result2),
  (test)-[:ADMITS]->(result3)


CREATE (personalResult:PersonalResult {id: 1})
CREATE (personalResultRoot:PersonalResult {id: 2})
CREATE
  (personalResult)-[:FOR]->(test),
  (personalResult)-[:RECEIVED]->(result1),
  //(personalResult)-[:DEFINING]->(intro_extra),
  (personalResult)-[:EXPANDS]->(personalResultRoot)


CREATE (person:Person {id: 1, name: 'Dimon'})
CREATE
  (personalResult)-[:FOR_PERSON]->(person),
  (personalResultRoot)-[:FOR_PERSON]->(person)
