Instructuion

- open command prompt.
- change directory to project root.

1. Build the project.
	* mvn -Dmaven.test.skip=true clean install -fae
		
2. Run 
	* mvn exec:java -Dexec.mainClass="it.personal.exercise.Game"