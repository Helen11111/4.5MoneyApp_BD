package com.example.moneyapp.data;

import java.util.List;

public interface DebstDataStorage {
    public void saveData(Debt debt);

    public Debt getData(int id);

    public List<Debt> getAllData();
}
