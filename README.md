Exercise-Resolvit
======================

Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word is any form of a word often communicated with essentially the same meaning. For example, fish and fishes could be defined as a unique word by using their stem fish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what unique sentence index position or positions the word is found. The following words should not be included in your analysis or result set: "a", "the", "and", "of", "in", "be", "also" and "as".  Your final result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.

### My solution:
  - I did the exercice in Java, with a Maven Project, using JRE 1.7 and Eclipse Mars as IDE.
  - I added two dependencies, Snowball v1.0.0 to stem the words and Jackson v0.9.1 to get the output in JSON format.
  - I decided to use a Maven Project because it seemed the easiest way to manage this dependencies.
  - For the correct use of the stemming depency I followed the steps found in the following github link: https://github.com/abh1nav/libstemmer
  - You should have get installed Java and Maven.

### PACKAGE THE PROJECT 

Clicking on the project, with the right button we have the options "Run as / Debug as" of Maven, then you have to click on "Run Configurations". A screen will open and you have to choose “New launch configuration”, there you have to give a name to the configuration, indicate the base directory and in "Goals" write: "clean package site". Finally by clicking "Run" button, in the target folder a jar is generated (ExerciseResolvit-0.0.1-SNAPSHOT.jar).

### STEPS FOR RUNNING THE JAR BY CONSOLE

You have to the go to your project location, find the "target" folder and there it must be the jar: ExerciseResolvit-0.0.1-SNAPSHOT.jar, then use: java -jar ExerciseResolvit-0.0.1-SNAPSHOT.jar
