package com.example.crud.database;

import com.example.crud.models.Car;

import java.util.ArrayList;
import java.util.Collections;

public class Database {

    // ArrayList
    private ArrayList<Car> cars;

    // Instance
    private static Database instance;

    // Construtor Database
    public Database() {
        cars = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public ArrayList<Car> getCars() {
        Collections.sort(cars);

        return cars;
    }

}
