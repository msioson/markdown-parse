CLASSPATH = lib/*:.

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java

TryCommonMark: TryCommonMark.class
	java -cp $(CLASSPATH) TryCommonMark
