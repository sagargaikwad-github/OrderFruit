package com.example.orderfruit.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.orderfruit.RoomDB.FavouriteFruits.FavouriteDAO;
import com.example.orderfruit.RoomDB.FavouriteFruits.FavouriteModel;
import com.example.orderfruit.RoomDB.FruitData.FruitDataDAO;
import com.example.orderfruit.RoomDB.FruitData.FruitDataModel;
import com.example.orderfruit.RoomDB.Registration.RegistrationDAO;
import com.example.orderfruit.RoomDB.Registration.RegistrationModel;

@Database(entities = {RegistrationModel.class,FruitDataModel.class, FavouriteModel.class}, exportSchema = false, version = 1)
public abstract class CommonDB extends RoomDatabase {
    private static final String DB_NAME = "ROOMDB_Fruits";
    public static CommonDB instance;

    public static synchronized CommonDB getDB(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context, CommonDB.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            FruitDataDAO dao = instance.fruitDataDAO();
                            allPreData(dao);
                        }
                    })
                    .build();
        }
        return instance;

    }

    private static void allPreData(FruitDataDAO dao) {
        dao.insertFruit(new FruitDataModel(0, "Watermelon", 40, 1, "Helps you stay hydrated", "Packed with nutrients and beneficial plant compounds.", "May have anticancer effects.", "May improve heart health.", null, 0, 0, null, "summer"));
        dao.insertFruit(new FruitDataModel(1, "Mango", 150, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, "Mango", "summer"));
        dao.insertFruit(new FruitDataModel(2, "Banana", 40, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "Banana", null));
        dao.insertFruit(new FruitDataModel(3, "Custard Apple", 70, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "Apple", "winter"));
        dao.insertFruit(new FruitDataModel(4, "Coconuts", 25, 1, "Highly nutritious", "May promote blood sugar control", "Contains powerful antioxidants", "Easy to add to your diet", null, 0, 0, null, null));
        dao.insertFruit(new FruitDataModel(5, "Grapes", 60, 1, "Helps your immune system", "Lowers blood pressure", "Protects against heart disease", "Protects against diabetes", null, 0, 0, "Seedless", "winter"));
        dao.insertFruit(new FruitDataModel(6, "Orange", 80, 1, "Protects your cells from damage", "Helps your body make collagen, a protein that heals wounds and gives you smoother skin", "Makes it easier to absorb iron to fight anemia", "Boosts your immune system, your body defense against germs", null, 0, 0, null, "winter"));
        dao.insertFruit(new FruitDataModel(7, "Star Fruit", 120, 1, "Weight loss promotion", "Immunity boosting ability", "Improved respiratory health", "Improved heart health", null, 0, 0, null, "monsoon"));
        dao.insertFruit(new FruitDataModel(8, "Guava", 50, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, null, "monsoon"));
        dao.insertFruit(new FruitDataModel(9, "Papaya", 70, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, null, "summer"));
    }

    public abstract RegistrationDAO registrationDAO();

    public abstract FruitDataDAO fruitDataDAO();

    public abstract FavouriteDAO favouriteDAO();

}

