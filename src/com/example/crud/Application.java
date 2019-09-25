package com.example.crud;

import com.example.crud.database.Database;
import com.example.crud.views.Display;

public class Application {

    public static void main(String[] args) {

        // Iniciando Database
        Database.getInstance();

        // Iniciando Display
        new Display();

    }

}
