package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.moneyapp.data.DebstDataStorageSP;
import com.example.moneyapp.data.Debt;
import com.example.moneyapp.data.DebtsDataStorageSQL;
import com.example.moneyapp.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DebstDataStorageSP dataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataStorage = new DebstDataStorageSP(this);
        resetAdapter();
        binding.floatingBtn.setOnClickListener(v -> {
            dataStorage.saveData(new Debt("Random guy", new Random().nextFloat()));
            resetAdapter();
        });

    }

    private void resetAdapter() {
        List<Debt> debts = dataStorage.getAllData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new MyAdapter(debts));
    }
}