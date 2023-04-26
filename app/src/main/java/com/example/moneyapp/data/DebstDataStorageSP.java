package com.example.moneyapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class DebstDataStorageSP implements DebstDataStorage{

    SharedPreferences storage;

    public DebstDataStorageSP(Context context) {
        storage = context.getSharedPreferences("DEBTS STORAGE", Context.MODE_PRIVATE);

    }

    @Override
    public void saveData(Debt debt) {
        int size = storage.getInt("size", 0);
        SharedPreferences.Editor editor = storage.edit();
        editor.putString("name" + size, debt.name);
        editor.putFloat("money" + size, debt.money);
        editor.putInt("size", size+1);
        editor.apply();
    }

    @Override
    public Debt getData(int id) {
        return new Debt(storage.getString("name" + id, ""), storage.getFloat("money" + id, 0));
    }

    @Override
    public List<Debt> getAllData() {
        int size = storage.getInt("size", 0);
        ArrayList<Debt> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(getData(i));
        }
        return arrayList;
    }
}
