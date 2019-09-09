# MVVM with DATA BINDING

This project describes about MVVM architecture along with Data binding.(using Live Data)

## Things to learn from this project
- *MVVM* architectural pattern.
- Using *Data Binding*
  - Binding for parameters. (one-way & two-way Data Binding)
  - Binding for methods/functions.
- Using *LiveData* datatype & Observing its state using Observer pattern.
- Using latest AndroidX libraries.

## Steps to follow for this Project
1) Create a new Project with an empty activity.

2) To enable Data Binding in your project, use these lines in your ***app's*** build.gradle
    > apply plugin: 'kotlin-kapt'
  
    In the same build.gradle, in the *android* section, add
    > android { \
    > &nbsp;&nbsp;dataBinding { \
    > &nbsp;&nbsp;&nbsp;&nbsp;enabled = true \
    > &nbsp;&nbsp;}
  
3) For using Live data in the project, add dependency in *dependencies* section of the same build.gradle.
    > implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
  
4) Enabling Databinding for the layout
    - The layout for which databinding is required should follow certain structure:
      - Layout file's first tag should be **\<layout\>** to define data binding for that layout.
      - Followed by **\<data\>** tag, and finally with **\<variable\>** tag to define the variable used for databinding.
      - The structure should look like : 
        > <layout \
        > &nbsp;&nbsp;&nbsp;&nbsp;xmlns:android="http://schemas.android.com/apk/res/android" \
        > &nbsp;&nbsp;&nbsp;&nbsp;xmlns:app="http://schemas.android.com/apk/res-auto"\> 
        >
        > &nbsp;&nbsp;\<data\> \
        > &nbsp;&nbsp;&nbsp;&nbsp;\<variable \
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name="viewmodel" \
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type="com.example.fruitsapp.MainViewModel" \/\> \
        > &nbsp;&nbsp;\</data\>

    - Now, to bind the variable in the .xml file, use like: (for one-way binding)
        > android:text="@{viewmodel.displayedEditTextContent}"
        
    - For, two-way binding in the .xml file, use like:
        > android:text="@={viewmodel.editTextContent}" \
        > The only difference is the "=" sign.
        
    - Also, the method is bind with the following line:
        > android:onClick="@{() -> viewmodel.onSelectRandomEditTextFruit()}"
        
5) Also, enabling two-way Data binding in View Model
    - For one-way Data binding, nothing is to be done in View Model. But for two-way Data binding, add ***@Binding*** annotation before the field which is two way Data binded.
      > @Bindable \
      > val editTextContent = MutableLiveData<String>()
      
6) Also whenever using Mutable Live Data, it is good practice to expose that variable as Live Data, so that it is immutable everywhere.
    > private val _displayedEditTextContent = MutableLiveData<String>()
    >
    > val displayedEditTextContent: LiveData<String> \
    > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;get() = _displayedEditTextContent
    
7) Initialize the layout.
      - To initialize the layout with Data Binding, use the following line:
        > val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
      - The system automatically creates a Binding class for the layout file (the one which starts with ***\<layout\>*** tag) for which you want to do Data binding. If the file is not created, try cleaning and re-building your project.
      - The naming convention for this file is *"\<your-layout-filename-in-camel-case\>Binding"*. Like in the example, *activity_main.xml* generated file was *"ActivityMainBinding"*.
      
8) Getting & Binding ViewModel Instance within View
      - To get view model instance, use:
        > mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
      - This will create an instance of the view model class.
      - To bind the instance,
        > activityMainBinding.viewmodel = mainViewModel
      - The name with activityMainBinding.**viewmodel** should be same as the variable name given in the layout file.
      
9) Set Observer for Live Data
      - To observe the state of the Live data object, which in our case is "*editTextContent*", we attach an observer with the object using
        > mainViewModel.editTextContent.observe(this, Observer { \
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Toast.makeText(this, it, Toast.LENGTH_SHORT).show() \
        > })
      - With this, we observe *editTextContent* object and call the Toast method whenever it changes.
