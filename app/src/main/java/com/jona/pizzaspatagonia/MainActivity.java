package com.jona.pizzaspatagonia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jona.pizzaspatagonia.clases.Cliente;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarSesion, btnRegistro;
    EditText txtMail, txtClave;
    ArrayList<Cliente> clientesFirebase = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistro = findViewById(R.id.btnRegistro);
        txtClave = findViewById(R.id.txtClave);
        txtMail = findViewById(R.id.txtMail);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef =database.getReference("clientes");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren()){
                    Cliente cliente = ds.getValue(Cliente.class);
                    clientesFirebase.add(cliente);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("ERROR", "Failed to read value.", error.toException());
            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Cliente c : clientesFirebase){
                    if (c.getEmail().equals(txtMail.toString()) && c.getClave().equals(txtClave.toString())){
                        startActivity(new Intent(MainActivity.this, ListadoPizzasActivity.class));
                        break;
                    }
                }
                Toast.makeText(MainActivity.this, "Usuario o clave incorrecta", Toast.LENGTH_LONG).show();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistroActivity.class));
            }
        });
    }
}