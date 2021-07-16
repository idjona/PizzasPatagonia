package com.jona.pizzaspatagonia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SeleccionPizzaActivity extends AppCompatActivity {

    EditText txtDetalleIngredientes, txtCantidad, txtPrecio;
    TextView lblNombrePizzaSeleccion;
    CheckBox chboxDespacho;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_pizza);

        txtDetalleIngredientes = findViewById(R.id.txtDetalleIngredientes);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPrecio = findViewById(R.id.txtPrecio);
        lblNombrePizzaSeleccion = findViewById(R.id.lblNombrePizzaSeleccion);
        chboxDespacho = findViewById(R.id.chboxDespacho);

        ///onCheckedChanged()



    }
}