# RECYCLERVIEW WITHOUT DATABINDING

This Project describes on how to use RecyclerView and how to bind each item in RecyclerView without Data Binding. So, each object has to be bind separately.

## Things to learn from this project
  - Incorporating RecyclerView into the layout and organizing separate layout for its items.
  - Data binding the items with the view without databinding.
  
## Steps to follow for this Project
1. Create a new Project with an empty activity.

2. To define RecyclerView in the layout, use:
 > \<androidx.recyclerview.widget.RecyclerView \
 > &nbsp;&nbsp;android:id="@+id/recyclerView" \
 > &nbsp;&nbsp;android:layout_width="match_parent" \
 > &nbsp;&nbsp;android:layout_height="match_parent" \/\>
 
3. Set RecyclerView Layout Manager and Adapter in MainActivity
    - To set Layout Manager
    > recyclerView.layoutManager = LinearLayoutManager(this) 
    
    We can use different layout manager according to our requirements.
    
    - To declare and set Adapter in Activity
    > val adapter = UserAdapter(users)  --> To declare Adapter
    
      User Adapter is a separate class which creates, binds the items together and performs everything related to RecyclerView. It takes *users* list which are the items of RecyclerView.
    > recyclerView.adapter = adapter   --> To set Adapter 
    
4. **Now the main part, Creating the RecyclerView Adapter Class**
    1. This class consists of majorly three methods, which we need to override 
        - onCreateViewHolder() method --> This will create and return the view for binding. 
        - onBindViewHolder() method --> Binds the item with the view. 
          > holder.bind(userList[position])
        - getItemCount() method --> Returns the item count of the list passed.
        
    2. With this class, we need one more class, ViewHolder class which will hold the view and pass it to the onBindViewHolder() method for Data Binding. Implement the bind() method under this class to bind each field.

This is the most Simple type of RecyclerView without data binding. Many more modifications can be made to achieve different configurations with RecyclerView.

For other Recycler View projects, see [Recycler View with Data binding](https://github.com/pranmar93/Android_Kotlin/tree/master/RecyclerView%20Databinding)
 
