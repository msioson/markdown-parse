classpath := .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar

test: MarkdownParse.class MarkdownParseTest.class
	java -cp $(classpath) org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp $(classpath) MarkdownParseTest.java
