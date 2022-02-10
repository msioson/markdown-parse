test: MarkdownParseTest.class MarkdownParse.class
    java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
    javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar MarkdownParseTest.java

MarkdownParse.class: MarkdownParse.java
    javac MarkdownParse.java