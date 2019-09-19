# RECYCLERVIEW WITH DATABINDING

This Project describes on how to use RecyclerView and how to bind each item in RecyclerView with Data Binding.

## Things to learn from this project
  - Incorporating RecyclerView into the layout and organizing separate layout for its items.
  - Data binding the items with the view.
  
## Steps to follow for this Project
  1. Create a new Project with an empty activity.
  
  2. To enable Data Binding in your project, use these lines in your ***app's*** build.gradle
  > apply plugin: 'kotlin-kapt'
  
  In the same build.gradle, in the *android* section, add
  > android { \
  > &nbsp;&nbsp;dataBinding { \
  > &nbsp;&nbsp;&nbsp;&nbsp;enabled = true \
  > &nbsp;&nbsp;} 
  
  3. Enabling Databinding for the layout (this will be the layout of the item of RecyclerView)
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
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name="user" \
        > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type="com.example.firstapp.User" \/\> \
        > &nbsp;&nbsp;\</data\>

   - Now, to bind the variable in the .xml file, use like: (for one-way binding)
   > android:text='@{user.name}' 
   
   name attribute is defined in the User Model
   
 4. To define RecyclerView in the layout, use:
 > \<androidx.recyclerview.widget.RecyclerView \
 > &nbsp;&nbsp;android:id="@+id/recyclerView" \
 > &nbsp;&nbsp;android:layout_width="match_parent" \
 > &nbsp;&nbsp;android:layout_height="match_parent" \/\>
 
 5. Initialize the layout.
      - To initialize the layout with Data Binding, use the following line:
        > val mainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
      - The system automatically creates a Binding class for the layout file (the one which starts with ***\<layout\>*** tag) for which you want to do Data binding. If the file is not created, try cleaning and re-building your project.
      - The naming convention for this file is "\<your-layout-filename-in-camel-case\>Binding". Like in the example, *activity_main.xml* generated file was *"ActivityMainBinding"*. 
      
 6. Set RecyclerView Layout Manager and Adapter
    - To set Layout Manager
    > mainBinding.recyclerView.layoutManager = LinearLayoutManager(this) 
    
    We can use different layout manager according to our requirements.
    
    - To declare and set Adapter in Activity
    > val adapter = UserAdapter(users)  --> To declare Adapter
    
      User Adapter is a separate class which creates, binds the items together and performs everything related to RecyclerView. It takes *users* list which are the items of RecyclerView.
    > mainBinding.recyclerView.adapter = adapter   --> To set Adapter
    
 7. **Now the main part, Creating the RecyclerView Adapter Class**
    1. This class consists of majorly three methods, which we need to override 
        - onCreateViewHolder() method --> This will create and return the view for binding. 
        - onBindViewHolder() method --> Binds the item with the view. 
          > holder.userListBinding.user = userList[position]
        - getItemCount() method --> Returns the item count of the list passed.
        
    2. With this class, we need one more class, ViewHolder class which will hold the view and pass it to the onBindViewHolder() method for Data Binding.

This is the most Simple type of RecyclerView. Many more modifications can be made to achieve different configurations with RecyclerView.

For other Data binding projects, see [Tic-Tac-Toe Project](https://github.com/pranmar93/Android_Kotlin/tree/master/TicTacToe) and [MVVM Databinding](https://github.com/pranmar93/Android_Kotlin/tree/master/MVVM%20Databinding)

For other Recycler View projects, see [Recycler View without Data binding]()
