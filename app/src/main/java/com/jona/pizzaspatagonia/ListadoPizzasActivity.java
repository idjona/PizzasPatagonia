package com.jona.pizzaspatagonia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jona.pizzaspatagonia.clases.Pizza;
import com.jona.pizzaspatagonia.clases.PizzaAdapter;

import java.util.ArrayList;

public class ListadoPizzasActivity extends AppCompatActivity {

    RecyclerView recyclerPizzas;
    Button btnPerfil, btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pizzas);

        btnPerfil = findViewById(R.id.btnPerfil);
        btnComprar = findViewById(R.id.btnComprar);
        recyclerPizzas =findViewById(R.id.recyclerPizzas);

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListadoPizzasActivity.this, RegistroActivity.class));
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef =database.getReference("pizzas");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Pizza> pizzasFireBase = new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren()){
                    Pizza pizza = ds.getValue(Pizza.class);
                    pizzasFireBase.add(pizza);
                }
                PizzaAdapter adapter = new PizzaAdapter(pizzasFireBase);
                recyclerPizzas.setLayoutManager(new LinearLayoutManager(ListadoPizzasActivity.this));
                recyclerPizzas.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}