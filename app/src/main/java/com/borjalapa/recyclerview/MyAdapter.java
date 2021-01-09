package com.borjalapa.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borjalapa.recyclerview.modelos.Persona;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Persona> personas;

    public MyAdapter(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }

    public void setData(Persona p){
        personas.add(0,p);

        //para actualizar la lista
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //metes en una variable inflada el xml para vincular variables
        View view = LayoutInflater.from(context).inflate(R.layout.items_list, parent,false);
        return new MyViewHolder(view);
    }

    //metodo que aplica la funcionalidad
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tvNombre.setText(personas.get(i).getNombre());
        holder.tvApellido.setText(personas.get(i).getApellido());

        holder.tvNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t = (TextView)view;
                Toast.makeText(context,"Has pulsado nombre : " + t.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvApellido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNombre, tvApellido;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = (TextView)itemView.findViewById(R.id.nombre);
            tvApellido = (TextView)itemView.findViewById(R.id.apellidos);
        }
    }
}
