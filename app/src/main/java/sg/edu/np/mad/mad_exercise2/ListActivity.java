package sg.edu.np.mad.mad_exercise2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    // Init user list
    ArrayList<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Get recyclerView from xml
        RecyclerView recyclerView = findViewById(R.id.UserRecyclerView);
        // Set up 20 users
        setUserList();
        // Create adapter and set recycler view
        User_RecyclerViewAdapter adapter = new User_RecyclerViewAdapter(this,userList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Method to add create and add users to list
    private void setUserList(){
        Random rand = new Random();
        for(int i=1 ; i <= 20; ++i){
            // Getting random integer
            int randInt1 = rand.nextInt();
            int randInt2 = rand.nextInt();
            String name = String.format("Name %s",randInt1);
            String description = String.format("Description %s",randInt2);
            userList.add(new User(name,description, i, false));
        }
    }
}