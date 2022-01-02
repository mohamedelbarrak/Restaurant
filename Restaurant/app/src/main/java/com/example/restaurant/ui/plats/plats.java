package com.example.restaurant.ui.plats;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.Adapter.MyAdaptor;
import com.example.restaurant.MainActivity;
import com.example.restaurant.Model.ListItem;
import com.example.restaurant.R;

import java.util.ArrayList;
import java.util.List;

public class plats extends Fragment {
    private RecyclerView recyclerView1;
    private List<ListItem> listitems;
    private RecyclerView.Adapter adapter;
    private GalleryViewModel galleryViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.dessert1, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        Log.d(MainActivity.class.getSimpleName(),"A01234");
/*
        Intent intent = new Intent(GalleryFragment.this.getActivity(), com.example.restaurant.ui.dessert.MainActivity6.class);
        intent.putExtra("welcomMSG", "data back from activiyu3");
        startActivity(intent);
*/

        //imageView1 = findViewById(R.id.imageView1);
        recyclerView1 = root.findViewById(R.id.recycleView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(plats.this.getActivity()));

        listitems = new ArrayList<>();
        //for (int x = 1; x < 12; x++){
        //    ListItem listitem = new ListItem("name" + (x+1), "Dtails", "23");
        //    listitems.add(listitem);
        //}
        ListItem item1 = new ListItem("Riz pilaf", "100 DH", "", R.drawable.riz_pilaf);//getResources().getResourceEntryName(R.drawable.a)
        //listitems.add(item1);
        ListItem item2 = new ListItem("Rosbeef", "80 DH", "", R.drawable.rosbeef);//R.drawable.b return id c'est un int
        ListItem item3 = new ListItem("Daube provençale", "90 DH", "", R.drawable.daube_proven_ale);
        //ListItem item4 = new ListItem("maria", "4IIR2", "20", R.drawable.ic_launcher_foreground);
        ListItem item5 = new ListItem("Aubergines", "55 DH", "", R.drawable.aubergines);
        ListItem item6 = new ListItem("Filet mignon", "80 DH", "", R.drawable.filet_mignon);
        //ListItem item7 = new ListItem("ayman", "3IIR1", "23", getResources().getResourceEntryName(R.drawable.j));
        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        //listitems.add(item4);
        listitems.add(item5);
        listitems.add(item6);
        //listitems.add(item7);
        adapter = new MyAdaptor(plats.this.getActivity(), listitems);
        recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter



        //GalleryFragment.this.getActivity().finish();
        return root;
    }
}