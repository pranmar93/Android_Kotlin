## TIC TAC TOE (MVVM with DATA BINDING)

This Project describe about how to manage MVVM architecture inside an Android Project with Data Binding (using LiveData). In this project, a Tic-Tac-Toe game is developed.

## Things to learn from this project
- *MVVM* architectural pattern.
- Using *Data Binding*
  - Binding for parameters. (one-way Data Binding)
  - Binding for methods/functions.
- Using *LiveData* datatype & Observing its state using Observer pattern.
- Inflating custom views using Layout Inflater.
- Creating custom Grid layout.
- Creating custom Alert Dialogs.
- Using latest AndroidX libraries.

## Model Concept
    The Models created are like building blocks which will hold the value for each entity.
    
## View Concept
    This is the class which represents the UI visible to the user. It is simply, presentation of model data.

## ViewModel Concept
    This ViewModel is a class that is responsible for preparing and managing the data for Activity class. It also handles the communication of the Activity(views) with the Models.

## Steps to follow for this Project
1) Create a new Project with an empty activity.
    > Name the Activity as *GameActivity* as in the example. 
  
This is the main launcher activity for your app.

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
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name="gameViewModel" \
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type="com.example.tictactoe.viewmodels.GameViewModel" \/\> \
        > &nbsp;&nbsp;\</data\>

    - Now, to bind the variable in the .xml file, use like: (for one-way binding)
        > android:text='@{gameViewModel.cells["00"]}'
    - Also, the method is bind with the following line: 
        > android:onClick="@{() -> gameViewModel.onClickedCellAt(0, 0)}"

5) In the *GameActivity* class created before, we will perform following activities:
    1) Prompt user for Username for both the players.
        - For prompting the user for username, create a custom alert dialog which will have two text fields and a button. 
        - Create a instance of *GameBeginDialog* class for having a alert dialog.
          > val dialog: GameBeginDialog? = GameBeginDialog.newInstance(this) \
          > dialog?.isCancelable = false \
          > dialog?.show(supportFragmentManager, GAME_BEGIN_DIALOG_TAG) 
        - Use the layout *game_begin_dialog.xml* for this alert dialog.
        - Inflate this layout using Layout Inflater in *GameBeginDialog* class.
          > LayoutInflater.from(context).inflate(R.layout.game_begin_dialog, null, false) 
        - Specify a click listener for the button on which game wil begin.
          > positiveButton.setOnClickListener { onDoneClicked(); } 
          
   2) Initialize the layout.
      - To initialize the layout with Data Binding, use the following line:
        > val activityGameBinding: ActivityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game)
      - The system automatically creates a Binding class for the layout file (the one which starts with ***\<layout\>*** tag) for which you want to do Data binding. If the file is not created, try cleaning and re-building your project.
      - The naming convention for this file is "\<your-layout-filename-in-camel-case\>Binding". Like in the example, *activity_game.xml* generated file was *"ActivityGameBinding"*.
      
   3) Getting & Binding ViewModel Instance within View
      - To get view model instance, use:
        > gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
      - This will create an instance of the view model class.
      - To bind the instance,
        > activityGameBinding.gameViewModel = gameViewModel
      - The name with activityGameBinding.**gameViewModel** should be same as the variable name given in the layout file.
        
   4) Set listener for the game end and knowing the winner.
      - To observe the state of the Live data object, which in our case is "*winner*", we attach an observer with the object using
        > gameViewModel!!.getWinner().observe(this, Observer<Player?> { winner -> onGameWinnerChanged(winner) })
      - With this, we observe *winner* object returned by ***getWinner()*** and call the function ***onGameWinnerChanged(winner)*** whenever it changes.
      
   5) Finally, displaying the winner.
      - So as the winner changes, the ***onGameWinnerChanged(winner)*** function is called, which displays the winner on a custom dialog box, same as how it was created for prompting user for username.
      
      
      
      
For other Data binding projects, see [MVVM Databinding](https://github.com/pranmar93/Android_Kotlin/tree/master/MVVM%20Databinding) and [RecyclerView Databinding](https://github.com/pranmar93/Android_Kotlin/tree/master/RecyclerView%20Databinding)
    
