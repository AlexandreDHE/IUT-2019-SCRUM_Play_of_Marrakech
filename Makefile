

class = ./Bin/
source = ./src/
flag= -cp $(class) -d $(class)

default : comp

run : comp
	java -cp $(class) Main

comp : Bin $(class)Main.class

clean:
	rm -rf $(class)

Bin :
	mkdir $(class)

$(class)Main.class : $(source)*.java
	javac  $(source)*.java $(flag)

.PHONY : comp run clean default
