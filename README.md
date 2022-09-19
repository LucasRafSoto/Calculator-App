![Open in Codespaces](https://classroom.github.com/assets/open-in-codespaces-abfff4d4e15f9e1bd8274d9a39a0befe03a0632bb0f153d0ec72ff541cedbe34.svg)

# Assignment 1 Documentation

Author: `Lucas Soto`

## Source Code Links

`UPDATE THIS SECTION WITH ANY CLASSES OR PACKAGES YOU ADD`

- :open_file_folder: [evaluator](../evaluator)
  - :spiral_notepad: [Evaluator.java](../evaluator/Evaluator.java)
  - :spiral_notepad: [EvaluatorUI.java](../evaluator/EvaluatorUI.java)
- :open_file_folder: [operand](../operand/)
  - :spiral_notepad: [Operand.java](../operand/Operand.java)
- :open_file_folder: [operator](../operator)
  - :spiral_notepad: [Operator.java](../operator/Operator.java)

## Project Introduction

`The Goal of this project was to create an evaluator object that can evaluate any expression with the correct order of operations and return the result. I then implemented this object into a Graphical User Interface that utilized buttons to create a user inputted expression. This expression is entered into the evaluator object and returns the answer in the text field.`

## Execution and Development Environment

- IDE: `Visual Studio Code`
- Java version: `JDK 18 (NOTE THAT WE USE OPENJDK 18.0.1 FOR GRADING)`

## System Design

`THIS SECTION SHOULD INCLUDE A GRAPHICAL REPRESENTATION OF THE SYSTEM THAT DISPLAYS PACKAGES, CLASSES, AND RELEVANT INFORMATION DETAILS`


## Scope of Work

`Tasks: Operand class, Operator class, Evaluator class, EvaluatorUI class`

### Task 1

`The operand class takes in a string token and evaluates whether it is a number or not, then creates an instance of an operand if the token is a number.`

### Task 2

`The operator class takes in a string token and evaluates whether it is a valid operator or not, then adds the operator to a hashmap of operators. From there a new operator is created as an instance of a subclass based on the type of operation. The subclasses have differing methods, which are associated with their operation.`

### Task 3

`The evaluator class takes in a string and tokenizes that string. It creates a stack for operands and a stack for operators; then utilizes the operand and operator classes to create instances of each which are added to the stacks. The stacks get popped based on certain parameters and uses the specific execute method of the popped operation. The class completes running by returning the answer to the given string.`

### Task 4

`THIS SECTION SHOULD DESCRIBE A TASK, AND ANY IMPLEMENTATION DETAILS RELEVANT TO THAT TASK. REFERENCE THE SYSTEM DESIGN (AND PROVIDE AN EXCERPT FROM IT FOR THIS SPECIFIC TASK). The evaluatorUI class extends JFrame and implements actionListener. This class creates a GUI with 20 buttons for each operand, operator, and additional actions; as well as a text field displaying the user inputted expression. The buttons use action event listeners to create a string from the inputted buttons, then creates an instance of the evaluator class with the given string. Finally returning the answer to the expression in the text field.`

## Results and Conclusions

### What I Learned

`I learned a lot from this assignment. Specifically how to implement an abstract class from another class to create instances of a subclass. Also how to utilize a GUI and instances of objects together.`

### What I Could Do Better

`I already did some optimization for the classes, but there is always more to do. I could also make the calculator GUI look prettier. I think I did a pretty good job other than that, but that is just my opinion.`

### Challenged I Encountered

`Most aspects of this assignment I found very difficult, but over time I was able to understand how to make the code do what I intended it to. By far the most helpful thing was to visualize the problem on a whiteboard, then I could figure out what I had to do for each step.I'd say the most difficult part of the assignment for me was getting the operator class to work properly with the evaluator class, but the whiteboard help me so much.`
