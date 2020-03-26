# General

The purpose of this project is to the Second Assignment of SEIP - AUEB!

It demostrate the usage of Maven tools and the way to create a funtional project through it.

What it does is receiving a text file from a specific path and analyze it.
In the end a cool graphich chart will be appeared!


# Requirements 

* Java 1.8.x
* Maven 3.6.3

# Building - Running

* Clone this project with `git clone https://github.com/iasonasma/seipassignment`
* Browse the folder with `cd seipassignment`
* Build the project with Maven using ` mvn install`
* After the maven is done with building the project browse into the target folder of `seipassignment\gradeshistogram\target`
* Use java-jar to run your file `java -jar gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <your path>` where `<your path>` is the path for the text file
eg if my text file is on my Downloads folder,my path should be `C:/Users/Username/Downloads/grades.txt`

