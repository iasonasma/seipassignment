## Analyzermetrics

Our third assignment is about working on the principles of a good way programming a new project
What it does is  types of metrics (lines of code, number of classes, number of methods) with 
two different ways; using regular expressions or string comparison.

## Changes on project
* A new Factory has been made.We have now clearly dependancy on every class.We can now make a new class on each interface without ruining the other class or methods
	* Why you selected a specific pattern?
		* With Factory we are now able to have a independancy between classes.The new subclass which is now gonna be made, can choose which instance to make. For example in this project we can choose between the local instance,which has methods of reading a local file or web instance which downloads and analyze the file.Also there is a possibility now that changes on a instance won't affect other instances.
	* How it affects your system? 
		* Subclasses can choose what type of object to create
		* Eliminates the bind between classes.
	* Which classes participate in the pattern, serving what role? 
		* MetricsAnalyzerDemo: This class includes the main of the project.The role is to recieve the arguments of user and pass them to MetricsAnalyzer 
		* MetricsAnalyzer: Η συγκεκριμένη κλάση περιλαμβάνει τις δυο μεθόδους οι οποίες είναι υπεύθυνες για τη επεξεργασία και δημιουργία αρχείου που σχετίζονται με τις μετρικές.Συγκεκριμένα η calculateMetrics,έχοντας τις παραμέτρους δημιουργεί μέσω του Factory τις μεθόδους που είναι αναγκαίες σύμφωνα με αυτά που έχει δώσει ο χρήστης,ενώ η writeToList ως βοηθητική καθώς δημιουργεί μια λίστα με τις μετρικές που δημιουργούντε.Η κλάση αυτή βοηθάει στο να έχουμε ενα καθαρό Client το οποίο το μόνο που θα ζητάει είναι να εκτελεστεί στο παρασκήνιο ΄όλο το σύστημα
		* AnalyzeFactory: To συγκεκριμένο Factory περιέχει 3ς μεθόδους τις οποίες ανάλογα με το input , το οποίο πρόκυται για τον τύπο του object που θέλουμε,θα επιστρέφει-φτιάχνει το κατάλληλο αντικείμενο.
		* JsonParser: This class includes method to write our result to a JSON file
		* CsvParser: This class includes method to write our result to a CSV file
		* AnalyzeRegex: This class includes methods to calculate LOC,NOM,NOC.It implements the methods from the interface and overides them.The input is a list of strings which through loop compares it each time with the correct pattern
		* AnalyzeString:This class includes methods to calculate LOC,NOM,NOC.It implements the methods from the interface and overides them.The input is a list of strings which through loop compares it each time with the correct string
		* FileReadLocal:This class is to read a local file and return a list of code to be used,in string.
		* FileReadWeb:This class  is to download file from web,analyze it and return a list of code to be used,in string.
		* SourceCodeAnalyze : A interface which includes the methods which AnalyzeString and AnalyzeRegex implements
		* FileReadIO: A interface which includes the methods of FileReading 
		* FileParser : A interface which includes the methods which CsvParser implements.
* Other changes that have been made:
	* readFileIntoString : this methods has been deleted from both of Local and Web class,there is no use of it.The benefit is that it uses less resources for creating items and analyze the file.
	* On AnalyzeRegex and AnalyzeString , the methods now recieve a list of Strings and on each loop it checks its pattern.With this, we remove dependancy on the FileRead class,since we only use a list instead.
	* Implemented json parser.Now user can also export a json file
	* cSV parser and JSON parser now use a PrintWriter.Changed the way it works,since it now recieves only a list of metrics to save.With this method we have a better organization and also it's much more simply to export our metrics


## Getting started
1. Fork this repository to your account
2. Clone your forked repository to your machine using `git clone https://github.com/YOURUSERNAME/seipassignment` 
3. Browse into the repository `cd seipassignment/analyzermetrics`  
4. Build the executable Java application with: `mvn package jacoco:report`
5. When the build is done, go to the target folder 
6. Run the executable by executing:
	 * java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
   * were args translate to: 	
	 *  arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	 *  arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	 *  arg2 = “SourceCodeLocationType” [local|web]
	 *  arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	 *  arg4 = “OutputFileType” [csv|json]
   *  example: 
	  * java –jar analyzermetrics-0.0.1-SNAPSHOT-jar-with-dependencies.jar ../src/test/resources/TestClass.java regex local metrics_results csv
  
  ## UML Class Diagram
  ![diagram](classdiagram.png)
