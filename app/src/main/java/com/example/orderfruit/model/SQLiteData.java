package com.example.orderfruit.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;
import java.util.ArrayList;

public class SQLiteData extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "OrderFruit.db";
    public static final int DATABASE_VERSION = 17;


    public SQLiteData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String register_table = "create table registration(name text,phone text primary key,password text)";
        sqLiteDatabase.execSQL(register_table);
        sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN isLogin");
        sqLiteDatabase.execSQL("update registration set isLogin=0;");

        sqLiteDatabase.execSQL("create table summer(id int primary key,name text,price int,description text,quantity int,image blob)");
        sqLiteDatabase.execSQL("Insert into summer values(0,'Mango',120,'Indian summers are incomplete without mango. It is undoubtedly the king of fruits in the Indian subcontinent. There are dozens of varieties grown all over India. There are well-planned commercial mango orchards with amazing, authentic varieties. Mango grows wild in Indian conditions providing lip-smacking flavours. Mango season starts in summer and continues till the middle of the monsoon. Dwarf grafted mango plants are also grown in containers in terrace gardening.',1,'null')");
        sqLiteDatabase.execSQL("Insert into summer values(1,'Watermelon',50,'These super popular fruits are massively grown in India during summer. Sweet varieties like sugar baby and sugar queen are more preferred. The plant is an annual creeper, and 2-3 fruits per plant are formed on the ground.',1,'null')");
        sqLiteDatabase.execSQL("Insert into summer values(2,'Wax jambu',120,'These bell-shaped white, pink or red waxy fruits are formed on a medium-sized evergreen tree. The plant is a close relative of the Jamun tree. The fruit is extremely watery; it has mild sweet flavour and cotton candy like mesh in the middle that holds the seeds. Many varieties can be cultivated in orchard and tree is a heavy fruit bearer.  ',1,1)");
        sqLiteDatabase.execSQL("Insert into summer values(3,'Karaunda',120,'The berry-sized fruits are formed on a prickly shrub. This flowering plant is suitable for fencing. The green raw fruits are pickled and black ripe fruits are a delicacy. The plant is grown from seed sown in the monsoon. The fruit is a rich source of iron, so it is sometimes used in the treatment of anaemia. It contains a fair amount of Vitamin C.',1,1)");
        sqLiteDatabase.execSQL("Insert into summer values(4,'Jackfruit',120,'Widely cultivated and popular in the Indian subcontinent, it is national fruit of Bangladesh. It is a giant fruit with a wonderful fruity smell and flavor that has a cult following in the people who have developed a taste for it. The raw fruit is eaten as a vegetable. The evergreen tree is huge and needs plenty of space to grow. Jackfruits are formed on the main trunk of a tree.',1,'null')");
        sqLiteDatabase.execSQL("Insert into summer values(5,'View All',null,null,null,'null')");
        sqLiteDatabase.execSQL("Insert into summer values(6,'View All',null,null,null,'null')");


        sqLiteDatabase.execSQL("create table fresh_fruits(id int Primary key,name text,price int,quantity int,description text,image blob,add_To_cart int)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(0,'Apple',120,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia where its wild ancestor Malus sieversii is still found today','null',0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(1,'Watermelon',40,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(2,'Orange',80,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(3,'Pear',35,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(4,'Cherry',100,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(5,'Strawberry',120,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(6,'Nectarine',800,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(7,'Grape',50,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(8,'Mango',200,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
        sqLiteDatabase.execSQL("Insert into fresh_fruits values(9,'Blueberry',60,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");

        sqLiteDatabase.execSQL("Update summer set id=5,name='Papaya',price=60,description='The papaya, papaw, or pawpaw is the plant Carica papaya, one of the 22 accepted species in the genus Carica of the family Caricaceae. It was first domesticated in Mesoamerica, within modern-day southern Mexico and Central America. In 2020, India produced 43% of the world supply of papayas.',quantity=1,image=null where id=5");
        sqLiteDatabase.execSQL("Update summer set id=6,name='Pineapple',price=40,description='The pineapple is a tropical plant with an edible fruit; it is the most economically significant plant in the family Bromeliaceae. The pineapple is indigenous to South America, where it has been cultivated for many centuries.',quantity=1,image=null where id=6");
        sqLiteDatabase.execSQL("ALTER TABLE fresh_fruits ADD COLUMN catagory text");

        sqLiteDatabase.execSQL("create table fruits_main(id int Primary key,name text,price int,quantity int,description1 text,description2 text,description3 text,description4 text,image blob,add_To_cart int,favourite int,category text,season text)");
        sqLiteDatabase.execSQL("Insert into fruits_main values(0,'Watermelon',40,1,'Helps you stay hydrated', 'Packed with nutrients and beneficial plant compounds.','May have anticancer effects.','May improve heart health.','null',0,0,'null','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(1,'Mango',150,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(2,'Banana',40,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Banana','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(3,'Custard Apple',70,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Apple','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(4,'Coconuts',25,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'null','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(5,'Grapes',60,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Seedless','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(6,'Orange',80,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'null','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(7,'Star Fruit',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'null','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(8,'Guava',50,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'null','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(9,'Papaya',70,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'null','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(10,'Lychee',150,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Berry','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(21,'Water Apple',90,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Apple','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(31,'Chikoo',40,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'null','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(42,'Pineapple',60,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'null','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(44,'Muskmelon',40,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'null','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(20,'JackFruit',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'null','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(19,'Tamarind',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'null','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(18,'Pears',180,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'null','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(43,'Beet',15,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'Seedless','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(22,'Strawberry',100,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Berry','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(41,'Raspberry',800,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Berry','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(32,'Cherry',190,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Berry','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(17,'Blueberry',1400,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'Berry','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(40,'Apple',120,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Apple','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(23,'Ambri Apple',260,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'Apple','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(30,'Granny Smith Apple',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'Apple','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(16,'Golden Delicious Apple',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'Apple','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(39,'Alphonso Mangoes',250,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(51,'Kesar Mangoes',400,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(15,'Dasheri Mangoes',60,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(50,'Badami Mangoes',120,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(33,'Totapuri Mangoes',260,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(38,'Raspuri Mangoes',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(29,'Rumani Mangoes',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'Mango','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(14,'Royalty Raspberry',250,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Berry','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(24,'Anne Raspberry',400,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Berry','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(37,'Fall Gold Raspberry',850,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Berry','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(47,'Jamun',80,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'Seedless','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(45,'Amla',100,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Seedless','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(34,'Karonda',130,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'Seedless','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(25,'Ber',20,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'Berry','summer')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(46,'Rasbhari',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(13,'Badam',400,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(49,'Kaju',480,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(48,'Khajoor',850,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(26,'Anjeer',180,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(12,'Akhrot',300,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(36,'Kismis',200,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'DryFruit','null')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(27,'Red Banana',75,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Banana','monsoon')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(28,'Blue Java Banana',110,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Banana','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(35,'Manzano Banana',70,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Banana','winter')");
        sqLiteDatabase.execSQL("Insert into fruits_main values(11,'Burro Banana',60,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'Banana','winter')");

        sqLiteDatabase.execSQL("Drop Table user_info");

        sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Address1 text");
        sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Address2 text");
        sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN ZipCode text");
        sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Email text");
        sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Image blob");


        sqLiteDatabase.execSQL("create table order_history_1(order_id int primary key autoincrement,name text,address text,price text,phone text,phone2 text,order_status text,date text,time text,fruit_id text)");
        sqLiteDatabase.execSQL("ALTER TABLE order_history_1 ADD COLUMN fruit_weight text");
        sqLiteDatabase.execSQL("alter table order_history_1 RENAME column time TO Quantity");

        sqLiteDatabase.execSQL("create table order_history_1(order_id INTEGER PRIMARY KEY autoincrement,name text,address text,price text,phone text,phone2 text,order_status text,date text,quantity text,fruit_id text,fruit_weight text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        switch (i1) {
            case 4:
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS fresh_fruits");
                sqLiteDatabase.execSQL("create table fresh_fruits(id int Primary key,name text,price int,quantity int,description text,image blob,add_To_cart int)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(0,'Apple',120,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia where its wild ancestor Malus sieversii is still found today','null',0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(1,'Watermelon',40,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(2,'Orange',80,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(3,'Pear',35,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(4,'Cherry',100,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(5,'Strawberry',120,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(6,'Nectarine',800,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(7,'Grape',50,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(8,'Mango',200,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");
                sqLiteDatabase.execSQL("Insert into fresh_fruits values(9,'Blueberry',60,1,'An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today',null,0)");

            case 6:
                sqLiteDatabase.execSQL("Update summer set id=5,name='Papaya',price=60,description='The papaya, papaw, or pawpaw is the plant Carica papaya, one of the 22 accepted species in the genus Carica of the family Caricaceae. It was first domesticated in Mesoamerica, within modern-day southern Mexico and Central America. In 2020, India produced 43% of the world supply of papayas.',quantity=1,image=null where id=5");
                sqLiteDatabase.execSQL("Update summer set id=6,name='Pineapple',price=40,description='The pineapple is a tropical plant with an edible fruit; it is the most economically significant plant in the family Bromeliaceae. The pineapple is indigenous to South America, where it has been cultivated for many centuries.',quantity=1,image=null where id=6");

            case 7:
                sqLiteDatabase.execSQL("ALTER TABLE fresh_fruits ADD COLUMN catagory text");

            case 8:
                sqLiteDatabase.execSQL("create table fruits_main(id int Primary key,name text,price int,quantity int,description1 text,description2 text,description3 text,description4 text,image blob,add_To_cart int,favourite int,category text,season text)");
                sqLiteDatabase.execSQL("Insert into fruits_main values(0,'Watermelon',40,1,'Helps you stay hydrated', 'Packed with nutrients and beneficial plant compounds.','May have anticancer effects.','May improve heart health.','null',0,0,'null','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(1,'Mango',150,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(2,'Banana',40,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Banana','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(3,'Custard Apple',70,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Apple','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(4,'Coconuts',25,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'null','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(5,'Grapes',60,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Seedless','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(6,'Orange',80,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'null','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(7,'Star Fruit',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'null','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(8,'Guava',50,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'null','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(9,'Papaya',70,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'null','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(10,'Lychee',150,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Berry','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(21,'Water Apple',90,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Apple','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(31,'Chikoo',40,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'null','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(42,'Pineapple',60,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'null','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(44,'Muskmelon',40,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'null','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(20,'JackFruit',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'null','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(19,'Tamarind',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'null','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(18,'Pears',180,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'null','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(43,'Beet',15,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'Seedless','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(22,'Strawberry',100,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Berry','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(41,'Raspberry',800,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Berry','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(32,'Cherry',190,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Berry','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(17,'Blueberry',1400,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'Berry','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(40,'Apple',120,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Apple','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(23,'Ambri Apple',260,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'Apple','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(30,'Granny Smith Apple',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'Apple','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(16,'Golden Delicious Apple',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'Apple','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(39,'Alphonso Mangoes',250,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(51,'Kesar Mangoes',400,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(15,'Dasheri Mangoes',60,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(50,'Badami Mangoes',120,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(33,'Totapuri Mangoes',260,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(38,'Raspuri Mangoes',120,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(29,'Rumani Mangoes',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'Mango','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(14,'Royalty Raspberry',250,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Berry','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(24,'Anne Raspberry',400,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Berry','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(37,'Fall Gold Raspberry',850,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Berry','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(47,'Jamun',80,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'Seedless','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(45,'Amla',100,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'Seedless','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(34,'Karonda',130,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'Seedless','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(25,'Ber',20,1,'Weight loss promotion', 'Immunity boosting ability','Improved respiratory health','Improved heart health','null',0,0,'Berry','summer')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(46,'Rasbhari',90,1,'May Help Lower Blood Sugar Levels', 'May Boost Heart Health','May Have an Anticancer Effect','May Benefit Your Digestive System','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(13,'Badam',400,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(49,'Kaju',480,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(48,'Khajoor',850,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(26,'Anjeer',180,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(12,'Akhrot',300,1,'Helps your immune system', 'Lowers blood pressure','Protects against heart disease','Protects against diabetes','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(36,'Kismis',200,1,'Protects your cells from damage', 'Helps your body make collagen, a protein that heals wounds and gives you smoother skin','Makes it easier to absorb iron to fight anemia','Boosts your immune system, your body defense against germs','null',0,0,'DryFruit','null')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(27,'Red Banana',75,1,'Contains immune-boosting nutrients', 'Packed with nutrients and beneficial plant compounds','May improve digestive health','May improve heart health.','null',0,0,'Banana','monsoon')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(28,'Blue Java Banana',110,1,'May improve blood sugar levels', 'May aid weight loss','May help you feel fuller','May improve insulin sensitivity when unripe','null',0,0,'Banana','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(35,'Manzano Banana',70,1,'May boost your mood', 'May benefit eye health','May prevent high blood pressure','May promote good digestion','null',0,0,'Banana','winter')");
                sqLiteDatabase.execSQL("Insert into fruits_main values(11,'Burro Banana',60,1,'Highly nutritious', 'May promote blood sugar control','Contains powerful antioxidants','Easy to add to your diet','null',0,0,'Banana','winter')");

            case 9:
                sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN isLogin");
                sqLiteDatabase.execSQL("update registration set isLogin=0;");
            case 12:
                sqLiteDatabase.execSQL("Drop Table user_info");
            case 13:
                sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Address1 text");
                sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Address2 text");
                sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN ZipCode text");
                sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Email text");
                sqLiteDatabase.execSQL("ALTER TABLE registration add COLUMN Image blob");

            case 14:
                sqLiteDatabase.execSQL("create table order_history_1(order_id int primary key ,name text,address text,price text,phone text,phone2 text,order_status text,date text,time text,fruit_id text)");
//                sqLiteDatabase.execSQL("create table order_history_2(order_id int primary key ,name text,address text,price text,order_status text,date text,time text)");
            case 15:
                sqLiteDatabase.execSQL("DROP TABLE order_history_1");
                sqLiteDatabase.execSQL("create table order_history_1(order_id INTEGER PRIMARY KEY autoincrement,name text,address text,price text,phone text,phone2 text,order_status text,date text,time text,fruit_id text)");
            case 16:

            case 17:
                sqLiteDatabase.execSQL("DROP TABLE order_history_1");
                sqLiteDatabase.execSQL("create table order_history_1(order_id INTEGER PRIMARY KEY autoincrement,name text,address text,price text,phone text,phone2 text,order_status text,date text,quantity text,fruit_id text,fruit_weight text)");


        }

    }

    public String new_user(String name, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("password", password);

        long res = db.insert("registration", null, cv);
        if (res == -1)
            return "Failed";
        else
            return "Sucessfully Inserted";

    }

    public boolean checkUser(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from registration where phone=?", new String[]{phone});
        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean login(String login, String Password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from registration where phone=? and password=?", new String[]{login, Password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAccount(String phone, String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cv = db.rawQuery("select * from registration where phone=? and name=?", new String[]{phone, name});
        if (cv.getCount() > 0) {
            return true;
        }
        return false;
    }

    public Cursor getAccount(String phone, String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cv = db.rawQuery("select * from registration where phone=? and name=?", new String[]{phone, name});
        return cv;
    }

    public void addSummerImage(int id, byte[] photo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("image", photo);
        db.update("summer", cv, "id=?", new String[]{String.valueOf(id)});

    }


    public ArrayList<FruitData> getFruit(String Category) {

        ArrayList<FruitData> fruitData = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from fruits_main where category=?", new String[]{Category}, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                fruitData.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }
        return fruitData;
    }


    public ArrayList<FruitData> getFruitMain() {
        ArrayList<FruitData> fruitData = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String qry = "select * from fruits_main";
        Cursor cursor = sqLiteDatabase.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                fruitData.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {
        }
        return fruitData;
    }

    public ArrayList<FruitData> getSummerFruits() {
        ArrayList<FruitData> summer = new ArrayList<>();
        SQLiteDatabase sqLiteData = this.getReadableDatabase();
        String qry = "select * from fruits_main where season='summer'";
        Cursor cursor = sqLiteData.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                summer.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }

        return summer;
    }

    public ArrayList<FruitData> getTopDeals() {
        ArrayList<FruitData> topdeals = new ArrayList<>();
        SQLiteDatabase sqLiteData = this.getReadableDatabase();
        String qry = "select * from fruits_main where price<=60";
        Cursor cursor = sqLiteData.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                topdeals.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }

        return topdeals;
    }

    public ArrayList<FruitData> getSeasonSummer() {
        ArrayList<FruitData> season_summer = new ArrayList<>();
        SQLiteDatabase sqLiteData = this.getReadableDatabase();
        String qry = "select * from fruits_main where season='summer'";
        Cursor cursor = sqLiteData.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                season_summer.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }

        return season_summer;
    }

    public ArrayList<FruitData> getSeasonMonsoon() {
        ArrayList<FruitData> season_monsoon = new ArrayList<>();
        SQLiteDatabase sqLiteData = this.getReadableDatabase();
        String qry = "select * from fruits_main where season='monsoon'";
        Cursor cursor = sqLiteData.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                season_monsoon.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }

        return season_monsoon;
    }

    public ArrayList<FruitData> getSeasonWinter() {
        ArrayList<FruitData> season_winter = new ArrayList<>();
        SQLiteDatabase sqLiteData = this.getReadableDatabase();
        String qry = "select * from fruits_main where season='winter'";
        Cursor cursor = sqLiteData.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                season_winter.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }

        return season_winter;
    }

    public void favoutite_update(int id, int num) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("favourite", num);
        sqLiteDatabase.update("fruits_main", cv, "id=?", new String[]{String.valueOf(id)});

    }

    public ArrayList<FruitData> favourite_list() {
        ArrayList<FruitData> getfravourite = new ArrayList<>();

        SQLiteDatabase sqLiteData = this.getReadableDatabase();
        String qry = "select * from fruits_main where favourite=1";
        Cursor cursor = sqLiteData.rawQuery(qry, null);
        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                String fruit_name = cursor.getString(1);
                int fruit_price = cursor.getInt(2);
                int fruit_quantity = cursor.getInt(3);
                String fruit_description_1 = cursor.getString(4);
                String fruit_description_2 = cursor.getString(5);
                String fruit_description_3 = cursor.getString(6);
                String fruit_description_4 = cursor.getString(7);
                byte[] fruit_image = cursor.getBlob(8);
                int fruit_addtocart = cursor.getInt(9);
                int fruit_favourite = cursor.getInt(10);
                String fruit_category = cursor.getString(11);
                String fruit_season = cursor.getString(12);

                getfravourite.add(new FruitData(fruit_id, fruit_name,
                        fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                        fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
            } while (cursor.moveToNext());
        } else {


        }
        return getfravourite;
    }


    public void UpdateLogin(String phone,int num)
    {
           SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
           ContentValues cv = new ContentValues();
           cv.put("isLogin", num);
           sqLiteDatabase.update("registration",cv,"phone=?", new String[]{String.valueOf(phone)});

    }
    public Cursor headerData()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cv = sqLiteDatabase.rawQuery("select * from registration where isLogin=1", null);
        return cv;

    }
    public String User_info(String name,String phone, String address, String address2, String ZipCode, String Email, Blob Image)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("Address1",address);
        cv.put("Address2",address2);
        cv.put("ZipCode",ZipCode);
        cv.put("Email",Email);
        long res = sqLiteDatabase.update("registration", cv, "phone=?",new String[]{String.valueOf(phone)});
       if(res==-1)
       {
           return "Error";
       }
      return "Successfully Saved";
    }

    public void addtocart(int id, int num)
    {
     SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
     ContentValues cv=new ContentValues();
     cv.put("add_to_cart",num);
     sqLiteDatabase.update("fruits_main",cv,"id=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<FruitData> get_cart_list()
    {
        ArrayList <FruitData> getcart=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String qry="select * from fruits_main where add_to_cart>0";
        Cursor cursor=sqLiteDatabase.rawQuery(qry,null);

        if(cursor.moveToFirst())
        {
          do{
              int fruit_id = cursor.getInt(0);
              String fruit_name = cursor.getString(1);
              int fruit_price = cursor.getInt(2);
              int fruit_quantity = cursor.getInt(3);
              String fruit_description_1 = cursor.getString(4);
              String fruit_description_2 = cursor.getString(5);
              String fruit_description_3 = cursor.getString(6);
              String fruit_description_4 = cursor.getString(7);
              byte[] fruit_image = cursor.getBlob(8);
              int fruit_addtocart = cursor.getInt(9);
              int fruit_favourite = cursor.getInt(10);
              String fruit_category = cursor.getString(11);
              String fruit_season = cursor.getString(12);

              getcart.add(new FruitData(fruit_id, fruit_name,
                      fruit_price, fruit_quantity, fruit_description_1, fruit_description_2, fruit_description_3,
                      fruit_description_4, fruit_image, fruit_addtocart, fruit_favourite, fruit_category, fruit_season));
          }while (cursor.moveToNext());
        }
        else
        {

        }

        return getcart;
    }
    public ArrayList savelist(ArrayList<FruitData> Clone) {
     ArrayList<FruitData>savelist=Clone;
     return savelist;
    }

    public boolean addtohistory(int orderid, String name, String address, String price, String phone, String phone2, String order_status, String date, String quantity, String fruit_id,String fruit_weight)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
       // cv.put("order_id",orderid);
        cv.put("name",name);
        cv.put("address",address);
        cv.put("price",price);
        cv.put("phone",phone);
        cv.put("phone2",phone2);
        cv.put("order_status",order_status);
        cv.put("date",date);
        cv.put("quantity",quantity);
        cv.put("fruit_id",fruit_id);
        cv.put("fruit_weight",fruit_weight);

        long res = sqLiteDatabase.insert("order_history_1", null,cv);
        if(res==-1)
        {
            return Boolean.parseBoolean("Error");
        }
        return Boolean.parseBoolean("Successfully Saved");

    }

    public ArrayList<orderHistoryData>getHistory()
    {
        ArrayList<orderHistoryData>getlist=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("select * from order_history_1",null);

        if(c.moveToFirst())
        {
           do{
               int order_id=c.getInt(0);
               String name=c.getString(1);
               String address=c.getString(2);
               String price=c.getString(3);
               String phone=c.getString(4);
               String phone2=c.getString(5);
               String order_status=c.getString(6);
               String date=c.getString(7);
               String quantity=c.getString(8);
               String fruit_id=c.getString(9);
               String fruit_weight=c.getString(10);

               getlist.add(new orderHistoryData(order_id,name,address,price,phone,phone2,order_status,date,quantity,fruit_id,fruit_weight));
           }while (c.moveToNext());
        }
        else {

        }


        return getlist;


    }

    public ArrayList<orderHistoryData> orderView(int num)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        sqLiteDatabase.rawQuery("Select * from order_history_1 where order_id=?", new String[]{String.valueOf(num)});

        return null;
    }
    public ArrayList<FruitData> getOrderID(String num)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        sqLiteDatabase.rawQuery("Select * from fruits_main where id=?", new String[]{String.valueOf(num)});
        return null;
    }


}