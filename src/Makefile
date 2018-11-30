class = ./Bin/
source = ./

default : comp

run : comp
	java Main

comp : Bin $(class)Main.class

clean:
	rm -rf */*.class
	rm -rf *.class

Bin :
	mkdir $(class)

$(class)Main.class :
	javac *.java

.PHONY : comp run clean default
