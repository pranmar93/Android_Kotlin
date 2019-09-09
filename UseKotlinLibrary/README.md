# USE KOTLIN LIBRARY

This project describes about how to import already generated android (.aar) library and use it within your android project.

## Things to learn from this project
  - Initial setup for importing the library.
  - Importing android library into a project.
  - Using the imported libary.
  - Granting permission for external storage read and write in Android Manifest file. 
  
## Steps to follow for this Project
  - Create a new Android Project.
  - For adding a library into your project, there are two ways:
  
    ### FIRST WAY
    1) Adding the library into the *libs* folder directly under app module. (Simply Copy the library and paste it into this folder)
    2) Modify a line in **dependencies** section of your ***app's*** build.gradle.
    
        >  dependencies {<br/>
        >  &nbsp;&nbsp;implementation fileTree(dir: 'libs', include: ['*.jar', '*.aar']) 
      
        This command will include all the .aar and .jar files you include into your ***app's*** *libs* folder.
        
    ### SECOND WAY
    1) Creating a *libs* folder under *app/src/main/java* path.
    2) Adding the library into the created *libs* folder. (Simply Copy the library and paste it into this folder)
    3) Modify a line in **allprojects** section of ***project's*** build gradle.
    
        > allprojects \
        > &nbsp;&nbsp;flatDir {<br/>
        > &nbsp;&nbsp;&nbsp;&nbsp;dirs 'src/main/libs'<br/>
        > &nbsp;&nbsp;}
        
    4) Modify a line in **dependencies** section of ***app's*** build gradle.
    
        > dependencies { \
        > &nbsp;&nbsp;implementation(name: 'ddflibrary-debug', ext: 'aar')
        
        > The library used in this project is **'ddflibrary-debug.aar'**
        
  - *Sync the gradle* once, so that the library is available for use inside the project.
  - Now, we can use the imported library inside our project.
  
  > For this project, you will generate a folder structure in your phone storage as Storage/TestApp/Input/{ABC}.txt \
  > And output will be under Storage/TestApp/Output/{DEF}.txt
  
For example on how to create a Android Library, visit my other project on [Creating a Android (.aar) Library](https://github.com/pranmar93/Android_Kotlin/tree/master/UseKotlinLibrary)
