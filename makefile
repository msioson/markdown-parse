test: MarkdownParse.java MarkdownParse.class
    javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar MarkdownParseTest.java
    java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParse.class: MarkdownParse.java
    javac MarkdownParse.java
