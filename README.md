CMSI-281 - Assignment #2
========
      This project represents assignment number 2 of CMSI 281. For this project class TwoDPoint was created to represent a two dimensional point in (x,y) space.  All TwoDPoints must be positive and will throw an exception for badly constructed points. 
All TwoDPoints have private variable of x and y with getters and setters for the values.

For the construction of other shapes, it was by intentional design to force all shapes to be created by the TwoDPoint class, therefore forcing all shapes to have positive points, excluding the special case of circle. The shapes were initially organized with an abstract class Shape which was extended to the sub-classes of Circle, Square, Rectangle, and RightTriangle -- and thus they share the same method headers. However, since this Assignment is not about polymorphism, I deleted the super class. 
      

All variables for a class that represent intrinsic things about the object (e.g - a circle's radius), is hidden from the outside world and can only be get.
    
The tests are by no means exhaustive, only 45 in total. I played around with JUnit4 learning about how to catch exceptions especially using the @RULE annotation as well as using @BEFORECLASS and @BEFORE.
      
Building the project with maven with eclipse was easier than expected after watching a tutorial.
      
This project will continue to be update as a learning experience for JUnit testing.
