package com.franceskoly.menuprincipal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecycler;
    ArrayList<Postre> postres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecycler = (RecyclerView) findViewById(R.id.recycler_contenedor);
        GridLayoutManager myGridLayoutManager = new GridLayoutManager(this,2);
        myRecycler.setLayoutManager(myGridLayoutManager);

        creaPostre();
        PostreAdapter myAdapter = new PostreAdapter(postres,this);

        myAdapter.setOnClikListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Usted ha elegido " + postres.get(myRecycler.getChildAdapterPosition(v)).getNomnbre_food(),Toast.LENGTH_SHORT).show();
            }
        });
        myRecycler.setAdapter(myAdapter);
    }

    public void creaPostre(){
        postres = new ArrayList<>();
        postres.add(new Postre("","Tallarines rojos de Pollo"));
        postres.add(new Postre("","Aji de Gallina"));
        postres.add(new Postre("","Arroz con Pollo"));
        postres.add(new Postre("","Chancho con Tamarindo"));
        postres.add(new Postre("","CAldo de Gallina"));
        postres.add(new Postre("","Carapulcra"));
        postres.add(new Postre("","Ceviche"));




    }
}
