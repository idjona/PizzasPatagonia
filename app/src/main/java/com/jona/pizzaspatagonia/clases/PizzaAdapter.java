package com.jona.pizzaspatagonia.clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jona.pizzaspatagonia.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolderDatos> {

    ArrayList<Pizza> ListaPizzas;
    public PizzaAdapter(ArrayList<Pizza> pizzas){
        ListaPizzas = pizzas;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pizzas, null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.CargarPizza(ListaPizzas.get(position));
    }

    @Override
    public int getItemCount() {
        return ListaPizzas.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txtNombrePizza, txtValorPizza;
        ImageView imgPizza;
        public ViewHolderDatos(@NonNull View itemView){
            super(itemView);
            txtNombrePizza = itemView.findViewById(R.id.txtNombrePizza);
            txtValorPizza = itemView.findViewById(R.id.txtValorPizza);
            imgPizza = itemView.findViewById(R.id.imgPizza);
        }
        void CargarPizza(Pizza pizza){
            txtNombrePizza.setText(pizza.getNombrePizza());
            txtValorPizza.setText(pizza.getValorPizza());
            switch (pizza.getIdPizza()) {
                case 1:
                    imgPizza.setImageResource(R.drawable.pizza1);
                    break;
                case 2:
                    imgPizza.setImageResource(R.drawable.pizza2);
                    break;
                case 3:
                    imgPizza.setImageResource(R.drawable.pizza3);
                    break;
                case 4:
                    imgPizza.setImageResource(R.drawable.pizza4);
                    break;
                case 5:
                    imgPizza.setImageResource(R.drawable.pizza5);
                    break;
                default:
                    imgPizza.setImageResource(R.drawable.pizza6);
                    break;
            }
        }
    }
}
