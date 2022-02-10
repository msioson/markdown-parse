classpath := .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar
MarkdownParseTest.java: MarkdownParse.java MarkdownParse.class
    javac -cp $(classpath) MarkdownParseTest.java
    java -cp $(classpath) org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParse.java:
    javac MarkdownParse.java
