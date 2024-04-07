package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataBaseHelper dbhelper = new DataBaseHelper(this);

        clientmod client1 = new clientmod("Ahmad Mustafa",1111,"amustafa@hotmail.com", "ahmad1111");
        clientmod client2 = new clientmod("Nora Ali",1112,"nali@gmail.com", "ahmad1111");
        clientmod client3 = new clientmod("Hamid Abdullah",1113,"habdullah@yahoo.com", "ahmad1111");
        clientmod client4 = new clientmod("Abbud Obeid",1114,"aobeid@hotmail.com", "ahmad1111");
        clientmod client5 = new clientmod("Arfa Ansari",1115,"ansari@gmail.com", "ahmad1111");
        clientmod client6 = new clientmod("Shireen Tamer",1116,"stamer@yahoo.com", "ahmad1111");
        clientmod client7 = new clientmod("Ayman Yousuf",1117,"ayousuf@hotmail.com", "ahmad1111");
        clientmod client8 = new clientmod("Dameer Sattar",1118,"dsattar@gmail.com", "ahmad1111");
        clientmod client9 = new clientmod("Ibrahim Khalil",1119,"ikhalil@yahoo.com", "ahmad1111");

        dbhelper.addClient(client1);
        dbhelper.addClient(client2);
        dbhelper.addClient(client3);
        dbhelper.addClient(client4);
        dbhelper.addClient(client5);
        dbhelper.addClient(client6);
        dbhelper.addClient(client7);
        dbhelper.addClient(client8);
        dbhelper.addClient(client9);

        servicemod service1 = new servicemod("Cleaning",123,"Shoe Wash",25,"");
        servicemod service2 = new servicemod("Cleaning",234,"Deep cleaning",250,"");
        servicemod service3 = new servicemod("Cleaning",345,"Clothes Wash",50,"");
        servicemod service4 = new servicemod("Cleaning",456,"Carpet Wash",75,"");
        servicemod service5 = new servicemod("Plumbing",567,"Washbasins",45,"");
        servicemod service6 = new servicemod("Plumbing",678,"Roof Insulation",1500,"");
        servicemod service7 = new servicemod("Plumbing",789,"Water Filter",90,"");
        servicemod service8 = new servicemod("Plumbing",100,"Dynamo",1000,"");

        dbhelper.addService(service1);
        dbhelper.addService(service2);
        dbhelper.addService(service3);
        dbhelper.addService(service4);
        dbhelper.addService(service5);
        dbhelper.addService(service6);
        dbhelper.addService(service7);
        dbhelper.addService(service8);

        ordermod order1 = new ordermod(111, 123, 1119, "Riyadh City, P.O.Box: 55570", 50,"2 hours", "Khalid Batais","Accepted","051234567");
        ordermod order2 = new ordermod(112, 567, 1118,"3rd Industrial City, P.O.Box: 88910", 100, "3 hours","Muhammad Ashraf","Rejected","054567890");
        ordermod order3 = new ordermod(113,789,1113,"Derah Dist., P.O.Box: 21634",25,"2 days","Asif Hakeem","Accepted","059378378");

        dbhelper.addOrder(order1);
        dbhelper.addOrder(order2);
        dbhelper.addOrder(order3);

    }
}