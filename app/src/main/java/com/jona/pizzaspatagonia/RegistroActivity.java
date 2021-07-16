package com.jona.pizzaspatagonia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jona.pizzaspatagonia.clases.Cliente;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    Button btnRegistrar;
    EditText txtEmail, txtNombres, txtApellidos, txtTelefono, txtDireccion, txtPass, txtPass2;
    private int id = 0;
    private String registrado = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtEmail = findViewById(R.id.txtEmail);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtPass = findViewById(R.id.txtPass);
        txtPass2 = findViewById(R.id.txtPass2);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String nombres = txtNombres.getText().toString();
                String apellidos = txtApellidos.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String direccion = txtDireccion.getText().toString();
                String clave1 = txtPass.getText().toString();
                String clave2 = txtPass2.getText().toString();
                if (clave1.equals(clave2)) {

                    FirebaseDatabase database =FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("clientes");

                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot ds : snapshot.getChildren()){
                                Cliente c1 = ds.getValue(Cliente.class);

                                Toast.makeText(RegistroActivity.this, c1.toString(), Toast.LENGTH_LONG).show();
                                if (c1.getId()>=id){
                                    id = c1.getId();
                                }
                                if (c1.getEmail().equals(email)){
                                    registrado = "si";
                                    //Toast.makeText(RegistroActivity.this, "Usuario ya está registrado", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                                }
                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w("ERROR", "Failed to read value.", error.toException());
                        }
                    });
                    if (registrado.equals("no")){
                        id = id+1;
                        Cliente c = new Cliente(id, email,nombres,apellidos,telefono,direccion,clave1);
                        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                myRef.child(c.getId()+"").setValue(c);
                            }
                        });
                        //Toast.makeText(RegistroActivity.this, "Usuario registrado existosamente", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                    } else {
                        //Toast.makeText(RegistroActivity.this, "Usuario ya está registrado", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                    }



                    /*myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot ds : snapshot.getChildren()){
                                Cliente c1 = ds.getValue(Cliente.class);
                                if (c1.getId()>id){
                                    id = c1.getId();
                                }
                                if (c1.getEmail().equals(email)){
                                    Toast.makeText(RegistroActivity.this, "Usuario ya está registrado", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                                    break;
                                }
                            }
                            id++;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w("ERROR", "Failed to read value.", error.toException());
                        }
                    });*/


                } else {
                    Toast.makeText(RegistroActivity.this, "Clave no coincide, verificar", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}