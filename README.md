Quizmaster
==================================================

A Quizmaster game written in Java.
This project is part of my apprenticeship as a software developer.



ToDo
==================================================
* <del>Questions with multiple text answers (the user selects an answer)</del>
* <del>Questions with numeric answers (the user enters a digit)</del>
* <del>Multi-user</del>
* <del>Display whether the answer was correct or not</del>
* <del>Displaying a small statistic: How much % of the questions have been answered correctly?</del>
* <del>Display the correct answer upon submitting the wrong answer</del>
* <del>Follow-up display of the wrong questions</del>
* <del>Import / Export for questions and answers</del>
* Evaluating the corret and wrong answers per category
* Generating PDF for the evaluations

* <del>Programming language: Java</del>
* <del>GUI</del>
* <del>Data storage by serialization</del>
* <del>Data storage by relational database via Hibernate</del>
* JUnit Tests



Changelog
==================================================
*28 June 2012*:
* Fixed answers now being fetched according to answerId instead of id
* Fixed / adjusted lots of JavaDoc
* Fixed case sensitive files not being removed upon refactoring
* Import & Export is now working correctly
* Result screen looks better now (using HTML as jLabel text)
* Updated the README

*27 June 2012*:
* Added support for digit questions
* Import & Export functionality added in the admin panel
* Removed the limit of 2 when using getAllQuestions()

*24 June 2012*:
* Verifying the selected answers
* Added result page
* Added JavaDoc

*23 June 2012*:
* Added MySQL Schema
* Fixed line endings
* Added the project to GitHub
