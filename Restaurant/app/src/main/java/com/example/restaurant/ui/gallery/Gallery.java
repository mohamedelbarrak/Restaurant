package com.example.restaurant.ui.gallery;

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

public class Gallery extends Fragment {
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
        recyclerView1.setLayoutManager(new LinearLayoutManager(Gallery.this.getActivity()));

        listitems = new ArrayList<>();
        //for (int x = 1; x < 12; x++){
        //    ListItem listitem = new ListItem("name" + (x+1), "Dtails", "23");
        //    listitems.add(listitem);
        //}
        ListItem item1 = new ListItem("Thon mayonnaise", "40 DH", "2 baguettes de pain frais, 4 œufs, 1 grosse boîte de thon au naturel, Poivre, 1 salade, 2 tomates, Mayonnaise", R.drawable.sandwich1);//getResources().getResourceEntryName(R.drawable.a)
        //listitems.add(item1);
        ListItem item2 = new ListItem("Le viandar", "50 DH", "Pour les amoureux de bonne viande, voici un sandwich au rôti de bœuf finement tranché avec une bonne dose de moutarde à l’ancienne, des oignons confits et quelques cornichons croquants.", R.drawable.sandwitch);//R.drawable.b return id c'est un int
        ListItem item3 = new ListItem("Grec", "66 DH", "filet de porc, de bœuf ou d’agneau, 4 oignons jaunes ou rouges, 3 tomates, Sauce tzatziki, 3 gousses d'ail", R.drawable.sandwich_grec);
        //ListItem item4 = new ListItem("maria", "4IIR2", "20", R.drawable.ic_launcher_foreground);
        ListItem item5 = new ListItem("Cuban", "49 DH", "1 petit pain blanc individuel, fines tranches de rôti de porc, pickles, moutarde douce ...", R.drawable.cuban_sandwich);
        ListItem item6 = new ListItem("Jambon", "66 DH", "1 baguette, 4 tranches de jambon blanc à acheter chez un vrai charcutier, 1 tomate, beurre, 4 feuilles de laitue, quelques cornichons", R.drawable.sandwich_au_jambon);

        ListItem item7 = new ListItem("Bifana", "70 DH", "4 petits pains, 4 gousses d'ail, paprika, sel, poivre, verres de vin blanc ...", R.drawable.sandwich_bifana);
        ListItem item8 = new ListItem("Thon", "55 DH", "8 tranches de pain aux céréales, 4 feuilles de salade verte, 1 oignon rouge, 1 boîte de thon, sel, poivre ...", R.drawable.sandwichs_au_thon);
        ListItem item9 = new ListItem("Suédois", "44 DH", "8 pains suédois plats, 1 petite tomate, 4 épaisses tranches de saumon fumé, 1/2 concombre, Sel, poivre ...", R.drawable.sandwich_su_dois);


        //ListItem item7 = new ListItem("ayman", "3IIR1", "23", getResources().getResourceEntryName(R.drawable.j));
        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        //listitems.add(item4);
        listitems.add(item5);
        listitems.add(item6);

        listitems.add(item7);
        listitems.add(item8);
        listitems.add(item9);
        //listitems.add(item7);
        adapter = new MyAdaptor(Gallery.this.getActivity(), listitems);
        recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter



        //GalleryFragment.this.getActivity().finish();
        return root;
    }
}