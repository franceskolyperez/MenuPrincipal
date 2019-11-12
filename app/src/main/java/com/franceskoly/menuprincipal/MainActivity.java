package com.franceskoly.menuprincipal;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecycler;
    ArrayList<Postre> postres;

    //fragment
    Fragment_Postre1 fragment_postre1;
    Fragment_Postre2 fragment_postre2;
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
                String nombre = postres.get(myRecycler.getChildAdapterPosition(v)).getNomnbre_food();

                if (nombre!=null){
                    setFragment(nombre);
                }
                //Toast.makeText(getApplicationContext(),"Usted ha elegido " + postres.get(myRecycler.getChildAdapterPosition(v)).getNomnbre_food(),Toast.LENGTH_SHORT).show();
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

    public void setFragment(String nombre){
        fragment_postre1 = new Fragment_Postre1();
        fragment_postre2 = new Fragment_Postre2();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        switch (nombre){
            case "Tallarines rojos de Pollo":
                fragmentTransaction.replace(R.id.frame_contenedor,fragment_postre1);
                Toast.makeText(getApplicationContext(),"eligio la opcion 1", Toast.LENGTH_SHORT).show();
                break;

            case "Aji de Gallina":
                fragmentTransaction.replace(R.id.frame_contenedor,fragment_postre2);
                Toast.makeText(getApplicationContext(),"eligio la opcion 2", Toast.LENGTH_SHORT).show();
                break;
        }

        fragmentTransaction.commit();
        /*fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (nombre){
            case "Tallarines rojos de Pollo":
                Fragment_Postre1 fragment_postre1 = new Fragment_Postre1();
                fragmentTransaction.replace(R.id.layout_contenedor,fragment_postre1);

                Toast.makeText(getApplicationContext(),"eligio la opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case "Aji de Gallina": Toast.makeText(getApplicationContext(),"eligio la opcion 2", Toast.LENGTH_SHORT).show();
                break;
        }
        fragmentTransaction.commit();

         */
    }
}
