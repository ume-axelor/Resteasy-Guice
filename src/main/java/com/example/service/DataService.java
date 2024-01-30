package com.example.service;
import java.util.List;

import com.example.model.Data;

public interface DataService {
    public void insertData(Data data);

	public List<Data> getAllEntries();
}
