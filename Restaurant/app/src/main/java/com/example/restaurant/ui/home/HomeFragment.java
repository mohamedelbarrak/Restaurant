package com.example.restaurant.ui.home;

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

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView1;
    private List<ListItem> listitems;
    private RecyclerView.Adapter adapter;
    private HomeViewModel galleryViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
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
        recyclerView1.setLayoutManager(new LinearLayoutManager(HomeFragment.this.getActivity()));

        listitems = new ArrayList<>();
        //for (int x = 1; x < 12; x++){
        //    ListItem listitem = new ListItem("name" + (x+1), "Dtails", "23");
        //    listitems.add(listitem);
        //}Margherita Sicilienne     Quatre saisons     Capricciosa   Hawaïenne
        ListItem item1 = new ListItem("Margherita", "100 DH", "tomate, mozzarella, basilic, huile d'olive", R.drawable.margherita);//getResources().getResourceEntryName(R.drawable.a)
        //listitems.add(item1);
        ListItem item2 = new ListItem("Sicilienne", "60 DH", "tomate, mozzarella, basilic, anchois, câpres, champignon", R.drawable.sicilienne);//R.drawable.b return id c'est un int
        ListItem item3 = new ListItem("Quatre saisons", "50 DH", "mozzarella, champignons, artichaut, jambon, olives, huile d'olive", R.drawable.quatre_saisons);
        //ListItem item4 = new ListItem("maria", "4IIR2", "20", R.drawable.ic_launcher_foreground);
        ListItem item5 = new ListItem("Capricciosa", "120 DH", "mozzarella, champignons, artichaut, jambon, olives, huile d'olive", R.drawable.capricciosa);
        ListItem item6 = new ListItem("Hawaïenne", "140 DH", "tomate, mozzarella, jambon, ananas", R.drawable.hawaienne);
        //ListItem item7 = new ListItem("ayman", "3IIR1", "23", getResources().getResourceEntryName(R.drawable.j));
        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        //listitems.add(item4);
        listitems.add(item5);
        listitems.add(item6);
        //listitems.add(item7);
        adapter = new MyAdaptor(HomeFragment.this.getActivity(), listitems);
        recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter



        //GalleryFragment.this.getActivity().finish();
        return root;
    }
}