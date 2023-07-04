package com.example.orderfruit.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.orderfruit.RoomDB.CartFruits.CartDAO;
import com.example.orderfruit.RoomDB.CartFruits.CartModel;
import com.example.orderfruit.RoomDB.FavouriteFruits.FavouriteDAO;
import com.example.orderfruit.RoomDB.FavouriteFruits.FavouriteModel;
import com.example.orderfruit.RoomDB.FruitData.FruitDataDAO;
import com.example.orderfruit.RoomDB.FruitData.FruitDataModel;
import com.example.orderfruit.RoomDB.Registration.RegistrationDAO;
import com.example.orderfruit.RoomDB.Registration.RegistrationModel;

@Database(entities = {RegistrationModel.class, FruitDataModel.class, FavouriteModel.class, CartModel.class}, exportSchema = false, version = 1)
public abstract class CommonDB extends RoomDatabase {
    private static final String DB_NAME = "ROOMDB_Fruits";
    public static CommonDB instance;
    static Context context1;

    public static synchronized CommonDB getDB(Context context) {
        context1 = context;
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context, CommonDB.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(onRoomCallback)
                    .build();
        }
        return instance;

    }

    public static RoomDatabase.Callback onRoomCallback = new Callback() {
        private FruitDataDAO fruitDataDAO;

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {

            OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                    .build();
            WorkManager.getInstance(context1).enqueue(workRequest);
        }
    };

    public static class MyWorker extends Worker {
        public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
            super(context, workerParams);
        }

        @NonNull
        @Override
        public Result doWork() {
            CommonDB commonDB = CommonDB.getDB(getApplicationContext());
            FruitDataDAO dao = commonDB.fruitDataDAO();
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
            dao.insertFruit(new FruitDataModel(10, "Lychee", 150, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "Berry", "winter"));
            dao.insertFruit(new FruitDataModel(21, "Water Apple", 90, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "Apple", "summer"));
            dao.insertFruit(new FruitDataModel(31, "Chikoo", 40, 1, "Highly nutritious", "May promote blood sugar control", "Contains powerful antioxidants", "Easy to add to your diet", null, 0, 0, null, "summer"));
            dao.insertFruit(new FruitDataModel(42, "Pineapple", 60, 1, "Helps your immune system", "Lowers blood pressure", "Protects against heart disease", "Protects against diabetes", null, 0, 0, null, "winter"));
            dao.insertFruit(new FruitDataModel(44, "Muskmelon", 40, 1, "Protects your cells from damage", "Helps your body make collagen, a protein that heals wounds and gives you smoother skin", "Makes it easier to absorb iron to fight anemia", "Boosts your immune system, your body defense against germs", null, 0, 0, null, "summer"));
            dao.insertFruit(new FruitDataModel(20, "JackFruit", 120, 1, "Weight loss promotion", "Immunity boosting ability", "Improved respiratory health", "Improved heart health", null, 0, 0, null, "monsoon"));
            dao.insertFruit(new FruitDataModel(19, "Tamarind", 90, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, null, "summer"));
            dao.insertFruit(new FruitDataModel(18, "Pears", 180, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, null, "summer"));
            dao.insertFruit(new FruitDataModel(43, "Beet", 15, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, "Seedless", "summer"));
            dao.insertFruit(new FruitDataModel(22, "Strawberry", 100, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, "Berry", "monsoon"));
            dao.insertFruit(new FruitDataModel(41, "Raspberry", 800, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "Berry", "winter"));
            dao.insertFruit(new FruitDataModel(32, "Cherry", 190, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "Berry", "summer"));
            dao.insertFruit(new FruitDataModel(17, "Blueberry", 1400, 1, "Highly nutritious", "May promote blood sugar control", "Contains powerful antioxidants", "Easy to add to your diet", null, 0, 0, "Berry", "winter"));
            dao.insertFruit(new FruitDataModel(40, "Apple", 120, 1, "Helps your immune system", "Lowers blood pressure", "Protects against heart disease", "Protects against diabetes", null, 0, 0, "Apple", null));
            dao.insertFruit(new FruitDataModel(23, "Ambri Apple", 260, 1, "Protects your cells from damage", "Helps your body make collagen, a protein that heals wounds and gives you smoother skin", "Makes it easier to absorb iron to fight anemia", "Boosts your immune system, your body defense against germs", null, 0, 0, "Apple", "summer"));
            dao.insertFruit(new FruitDataModel(30, "Granny Smith Apple", 120, 1, "Weight loss promotion", "Immunity boosting ability", "Improved respiratory health", "Improved heart health", null, 0, 0, "Apple", "monsoon"));
            dao.insertFruit(new FruitDataModel(16, "Golden Delicious Apple", 90, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, "Apple", "summer"));
            dao.insertFruit(new FruitDataModel(39, "Alphonso Mangoes", 250, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(51, "Kesar Mangoes", 400, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(15, "Dasheri Mangoes", 60, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(50, "Badami Mangoes", 120, 1, "Helps your immune system", "Lowers blood pressure", "Protects against heart disease", "Protects against diabetes", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(33, "Totapuri Mangoes", 260, 1, "Protects your cells from damage", "Helps your body make collagen, a protein that heals wounds and gives you smoother skin", "Makes it easier to absorb iron to fight anemia", "Boosts your immune system, your body defense against germs", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(38, "Raspuri Mangoes", 120, 1, "Weight loss promotion", "Immunity boosting ability", "Improved respiratory health", "Improved heart health", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(29, "Rumani Mangoes", 90, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, "Mango", "summer"));
            dao.insertFruit(new FruitDataModel(14, "Royalty Raspberry", 250, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, "Berry", "monsoon"));
            dao.insertFruit(new FruitDataModel(24, "Anne Raspberry", 400, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "Berry", "winter"));
            dao.insertFruit(new FruitDataModel(37, "Fall Gold Raspberry", 850, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "Berry", "summer"));
            dao.insertFruit(new FruitDataModel(47, "Jamun", 80, 1, "Highly nutritious", "May promote blood sugar control", "Contains powerful antioxidants", "Easy to add to your diet", null, 0, 0, "Seedless", "monsoon"));
            dao.insertFruit(new FruitDataModel(45, "Amla", 100, 1, "Helps your immune system", "Lowers blood pressure", "Protects against heart disease", "Protects against diabetes", null, 0, 0, "Seedless", "summer"));
            dao.insertFruit(new FruitDataModel(34, "Karonda", 130, 1, "Protects your cells from damage", "Helps your body make collagen, a protein that heals wounds and gives you smoother skin", "Makes it easier to absorb iron to fight anemia", "Boosts your immune system, your body defense against germs", null, 0, 0, "Seedless", "summer"));
            dao.insertFruit(new FruitDataModel(25, "Ber", 20, 1, "Weight loss promotion", "Immunity boosting ability", "Improved respiratory health", "Improved heart health", null, 0, 0, "Berry", "summer"));
            dao.insertFruit(new FruitDataModel(46, "Rasbhari", 90, 1, "May Help Lower Blood Sugar Levels", "May Boost Heart Health", "May Have an Anticancer Effect", "May Benefit Your Digestive System", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(13, "Badam", 400, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(49, "Kaju", 480, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(48, "Khajoor", 850, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(26, "Anjeer", 180, 1, "Highly nutritious", "May promote blood sugar control", "Contains powerful antioxidants", "Easy to add to your diet", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(12, "Akhrot", 300, 1, "Helps your immune system", "Lowers blood pressure", "Protects against heart disease", "Protects against diabetes", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(36, "Kismis", 200, 1, "Protects your cells from damage", "Helps your body make collagen, a protein that heals wounds and gives you smoother skin", "Makes it easier to absorb iron to fight anemia", "Boosts your immune system, your body defense against germs", null, 0, 0, "DryFruit", null));
            dao.insertFruit(new FruitDataModel(27, "Red Banana", 75, 1, "Contains immune-boosting nutrients", "Packed with nutrients and beneficial plant compounds", "May improve digestive health", "May improve heart health.", null, 0, 0, "Banana", "monsoon"));
            dao.insertFruit(new FruitDataModel(28, "Blue Java Banana", 110, 1, "May improve blood sugar levels", "May aid weight loss", "May help you feel fuller", "May improve insulin sensitivity when unripe", null, 0, 0, "Banana", "winter"));
            dao.insertFruit(new FruitDataModel(35, "Manzano Banana", 70, 1, "May boost your mood", "May benefit eye health", "May prevent high blood pressure", "May promote good digestion", null, 0, 0, "Banana", "winter"));
            dao.insertFruit(new FruitDataModel(11, "Burro Banana", 60, 1, "Highly nutritious", "May promote blood sugar control", "Contains powerful antioxidants", "Easy to add to your diet", null, 0, 0, "Banana", "winter"));

            return Result.success();
        }
    }


    public abstract RegistrationDAO registrationDAO();

    public abstract FruitDataDAO fruitDataDAO();

    public abstract FavouriteDAO favouriteDAO();

    public abstract CartDAO cartDAO();


}

