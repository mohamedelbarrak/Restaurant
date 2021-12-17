package com.example.restaurant.ui.drink;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.Adapter.MyAdaptor;
import com.example.restaurant.Model.ListItem;
import com.example.restaurant.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private List<ListItem> listitems;
    private RecyclerView.Adapter adapter;
    //private ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dessert1);

        //imageView1 = findViewById(R.id.imageView1);
        recyclerView1 = findViewById(R.id.recycleView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager( this));

        listitems = new ArrayList<>();
        //for (int x = 1; x < 12; x++){
        //    ListItem listitem = new ListItem("name" + (x+1), "Dtails", "23");
        //    listitems.add(listitem);
        //}
        ListItem item1 = new ListItem("Mohamed", "4IIR2", "23", R.drawable.a);//getResources().getResourceEntryName(R.drawable.a)
        //listitems.add(item1);
        ListItem item2 = new ListItem("amina", "2IIR2", "22", R.drawable.b);//R.drawable.b return id c'est un int
        ListItem item3 = new ListItem("amine", "4IIR1", "21", R.drawable.c);
        //ListItem item4 = new ListItem("maria", "4IIR2", "20", R.drawable.ic_launcher_foreground);
        ListItem item5 = new ListItem("hajar", "3IIR4", "23", R.drawable.e);
        ListItem item6 = new ListItem("hamza", "4IFA2", "24", R.drawable.f);
        //ListItem item7 = new ListItem("ayman", "3IIR1", "23", getResources().getResourceEntryName(R.drawable.j));
        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        //listitems.add(item4);
        listitems.add(item5);
        listitems.add(item6);
        //listitems.add(item7);
        adapter = new MyAdaptor(this, listitems);
        recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter
    }
}