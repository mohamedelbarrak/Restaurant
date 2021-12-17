package com.example.restaurant.ui.dessert;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.Model.ListItem;
import com.example.restaurant.R;

import java.util.List;

public class GalleryViewModel extends ViewModel {
    private RecyclerView recyclerView1;
    private List<ListItem> listitems;
    private RecyclerView.Adapter adapter;
    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment...");


    }

    public LiveData<String> getText() {
        return mText;
    }


}