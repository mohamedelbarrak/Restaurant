package com.example.restaurant.ui.slideshow;

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
import com.example.restaurant.ui.plats2.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

public class slideshow extends Fragment {
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
        recyclerView1.setLayoutManager(new LinearLayoutManager(com.example.restaurant.ui.slideshow.slideshow.this.getActivity()));

        listitems = new ArrayList<>();
        //for (int x = 1; x < 12; x++){
        //    ListItem listitem = new ListItem("name" + (x+1), "Dtails", "23");
        //    listitems.add(listitem);
        //}
        ListItem item1 = new ListItem("César au poulet", "70 DH", "4 escalopes de poulet, quelques croutons, 1 échalote, 7 biscottes, sel, poivre ...", R.drawable.c_sar_au_poulet);//getResources().getResourceEntryName(R.drawable.a)
        //listitems.add(item1);
        ListItem item2 = new ListItem("Pâtes au thon", "33 DH", "1 boîte de thon, 1 tomate, 200 g de penne, 40 g d'olive noires dénoyautées, sel, poivre", R.drawable.p_tes_au_thon);//R.drawable.b return id c'est un int
        ListItem item3 = new ListItem("Grecque simple", "30 DH", "500 g de tomates cerise, poivron vert, olives noires, Sel et poivre, feta, oignon rouge, concombre", R.drawable.grecque_simple);
        //ListItem item4 = new ListItem("maria", "4IIR2", "20", R.drawable.ic_launcher_foreground);
        ListItem item5 = new ListItem("César simple", "40 DH", "2 coeurs de laitue romaine lavées et essorées, 4 tranches de pain (sans croûtes), 2 c. à soupe d'huile ...", R.drawable.e);
        ListItem item6 = new ListItem("Niçoise", "60 DH", "2 oeufs, feuilles de mesclun, thon égoutté, olives noires, poivron vert, sel, poivre ...", R.drawable.ni_oise);
        ListItem item7 = new ListItem("Russe", "3IIR1", "5 pommes de terre, 1/2 poivron rouge, 2 carottes, poivre, sel ", R.drawable.russe);
        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        //listitems.add(item4);
        listitems.add(item5);
        listitems.add(item6);
        listitems.add(item7);
        adapter = new MyAdaptor(com.example.restaurant.ui.slideshow.slideshow.this.getActivity(), listitems);
        recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter



        //GalleryFragment.this.getActivity().finish();
        return root;
    }
}