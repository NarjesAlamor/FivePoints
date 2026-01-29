package com.example.fivepoints;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcstd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rcstd = findViewById(R.id.rcstd);
        rcstd.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        ArrayList<Students> arr = new ArrayList<>();

        Students s1 = new Students("salem","https://business.appstate.edu/sites/business.appstate.edu/files/asu_news/student-profile-javon-nathaniel.jpg", "22/12/1981");
        arr.add(s1);


        Students s2 = new Students("alia","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6H2H1_RnK5Z9bDpjT_XdcN9JQIUbTMKlTLw&s", "22/11/1990");
        arr.add(s2);

        Students s3 = new Students("salem","https://business.appstate.edu/sites/business.appstate.edu/files/asu_news/student-profile-javon-nathaniel.jpg", "22/12/1981");
        arr.add(s3);


        Students s4 = new Students("alia","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6H2H1_RnK5Z9bDpjT_XdcN9JQIUbTMKlTLw&s", "22/11/1990");
        arr.add(s4);

        Students s5 = new Students("salm","https://images.pexels.com/photos/3769715/pexels-photo-3769715.jpeg", "20/2/2009");
        arr.add(s5);

        Students s6 = new Students("sali","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6H2H1_RnK5Z9bDpjT_XdcN9JQIUbTMKlTLw&s", "21/9/2000");
        arr.add(s6);

        Students s7 = new Students("naro","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6H2H1_RnK5Z9bDpjT_XdcN9JQIUbTMKlTLw&s", "16/3/1997");
        arr.add(s7);


        Students s8 = new Students("maikle","https://images.pexels.com/photos/3769715/pexels-photo-3769715.jpeg", "2/2/2002");
        arr.add(s8);

        Students s9 = new Students("alaa","https://images.unsplash.com/photo-1500648767791-00dcc994a43e", "22/1/2005");
        arr.add(s9);

        Students s10 = new Students("amri","https://images.pexels.com/photos/3769715/pexels-photo-3769715.jpeg", "24/5/2000");
        arr.add(s10);

        Students s11 = new Students("soso","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6H2H1_RnK5Z9bDpjT_XdcN9JQIUbTMKlTLw&s", "20/1/2003");
        arr.add(s11);

        stdAdapter sp = new stdAdapter(arr);
        rcstd.setAdapter(sp);





    }
}