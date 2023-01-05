default:cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/DequeApp.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ListDeque.java cpsc2150/MyDeque/AbsDeque.java cpsc2150/MyDeque/CharacterDequeApp.java
	javac -Xlint cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/DequeApp.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ListDeque.java cpsc2150/MyDeque/AbsDeque.java cpsc2150/MyDeque/CharacterDequeApp.java

runDouble:cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/DequeApp.class cpsc2150/MyDeque/ListDeque.class cpsc2150/MyDeque/IDeque.class cpsc2150/MyDeque/AbsDeque.class
	java cpsc2150.MyDeque.DequeApp

runChar:cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/CharacterDequeApp.class cpsc2150/MyDeque/ListDeque.class cpsc2150/MyDeque/IDeque.class cpsc2150/MyDeque/AbsDeque.class
	java cpsc2150.MyDeque.CharacterDequeApp

test:cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/DequeApp.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ListDeque.java cpsc2150/MyDeque/AbsDeque.java cpsc2150/MyDeque/CharacterDequeApp.java cpsc2150/MyDeque/TestArrayDeque.java cpsc2150/MyDeque/TestListDeque.java
	javac -Xlint -cp .:/usr/share/java/junit4.jar cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/DequeApp.java cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ListDeque.java cpsc2150/MyDeque/AbsDeque.java cpsc2150/MyDeque/CharacterDequeApp.java cpsc2150/MyDeque/TestArrayDeque.java cpsc2150/MyDeque/TestListDeque.java

testArr:cpsc2150/MyDeque/ArrayDeque.class cpsc2150/MyDeque/AbsDeque.class cpsc2150/MyDeque/IDeque.class cpsc2150/MyDeque/TestArrayDeque.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyDeque.TestArrayDeque

testList:cpsc2150/MyDeque/ListDeque.class cpsc2150/MyDeque/AbsDeque.class cpsc2150/MyDeque/IDeque.class cpsc2150/MyDeque/TestListDeque.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyDeque.TestListDeque

clean:
	rm -f cpsc2150/MyDeque/*.class
