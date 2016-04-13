Utility classes and helper methods to support other Bots4J components
====================================================

Work in progress.



Key Features
------------
	
-	Some useful Gson stuff like FlexibleMap which supports converting values with getAs
 
	
Maven Config
============

Add this repo:

    <repositories>
        <repository>
            <id>bintray-bots4j-maven-repo</id>
            <name>bintray</name>
            <url>http://dl.bintray.com/bots4j/maven-repo</url>
        </repository>
    </repositories>

Add this dependency:

    <dependency>
      <groupId>org.bots4j</groupId>
      <artifactId>bots4j-utils</artifactId>
      <version>0.1</version>
    </dependency>
    


Questions and Issues
--------------------
If you have a question about this project, or are experiencing a problem you're not sure is a bug please post a message to the
[Bots4J mailing list](https://groups.google.com/forum/#!forum/bots4j).

On the other hand if you're pretty certain you've found a bug please open an issue.

Contributing
------------
We welcome bug fixes and new features in the form of pull requests. If you'd like to contribute, please be mindful of the
following guidelines:
* All changes should include suitable tests, whether to demonstrate the bug or exercise and document the new feature.
* Please make one change per pull request.
* If the new feature is significantly large/complex/breaks existing behaviour, please first post a summary of your idea
on the mailing list to generate a discussion. This will avoid significant amounts of coding time spent on changes that ultimately get rejected.
* Try to avoid reformats of files that change the indentation, tabs to spaces etc., as this makes reviewing diffs much
more difficult.
