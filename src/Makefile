default : comp

run : comp
	java Main

comp : clean Main

clean:
	rm -rf */*.class
	rm -rf *.class

Main :
	javac *.java

.PHONY : comp run clean default
