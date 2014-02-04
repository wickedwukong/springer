springer
========

springer

There is a screen shot file called springer-interview.png under the source code root directory. It shows you how to run the application.

See here: https://github.com/wickedwukong/springer/blob/master/springer-interview.png

for a screen shot of how to run the application. The entry point for the application is Application.scala


1. How to build the project:

use the sbt.sh under the root directory

supported tasks: test, run. The test tasks run all tests. The run task start the application.

2. IntelliJ

If you are an IntelliJ user, you can use gen-idea to generate Intellij project file. 

3. Implmented features:

All commands: C, L, R, B and Q

Report a friendly message when unsupported commands are entered.

Prevent lines from going outside canvas, and over the edges of the canvas

4. What are NOT implemented:

Edge cases: e.g lines run out of canvas etc
Invalid input handling: e.g non-integer values for coordinates etc




