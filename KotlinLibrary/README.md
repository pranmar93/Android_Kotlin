# KOTLIN LIBRARY

This project describes about how to create an Android Library (.aar) file to modularize the code, so as to re-use the module in other android projects.

## Things to learn from this project
  a) Using latest AndroidX libraries
  
  b) Create Android library (.aar) file
  
  c) Reading from a text file
  
  d) Writing to a text file
  
  
## Steps to follow for this Project
  1) Create an Android Project.
  
  2) Add a new **Module** to this Project -> Select "**Android Library**". --> This Module will be your library.
  
  > For this project, the module is **ddflibrary**.
  
  3) Now, add a **Class** which will hold the member functions for this library.
  
  > For this project, the class is **FileOperation**.
  
  4) Add the functions to the class. The functions can be directly within the *companion object* (as static) or as member functions.
  
  5) After writing the functions, **re-build** your code.
  
  6) On re-building, you can find your .aar file generated at *<your_module>/build/outputs/aar/<generated_aar_library>*.
  
  
Information on how to import and use the android library inside your project, check another project on [Using Android Library](https://github.com/pranmar93/Android_Kotlin/tree/master/UseKotlinLibrary)
