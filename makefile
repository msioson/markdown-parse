classpath := .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar

test: MarkdownParseTest.class MarkdownParse.class
    echo $(classpath)
    java -cp $(classpath) org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
    javac -cp $(classpath) MarkdownParseTest.java

MarkdownParse.class: MarkdownParse.java
    java MarkdownParse.java