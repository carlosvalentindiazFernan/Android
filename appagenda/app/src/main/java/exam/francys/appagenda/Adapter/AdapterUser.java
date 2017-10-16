package exam.francys.appagenda.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import exam.francys.appagenda.Models.Usuario;
import exam.francys.appagenda.R;

/**
 * Created by Francys on 27/12/2016.
 */

public class AdapterUser extends RecyclerView.Adapter<AdapterUsers.ViewHolder>{


    private List<Usuario> item;
    public AdapterUser(List<Usuario> list) {
        this.item =list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listuser,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterUsers.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Name.setText(item.get(position).getNombre() +" "+ item.get(position).getApp());
        holder.Direccion.setText(item.get(position).getDireccion());
        holder.correo.setText(item.get(position).getCorreo());
        holder.usuario.setText(item.get(position).getUsuario());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ViewNombre)TextView Name;
        @BindView(R.id.ViewDireccion) TextView Direccion;
        @BindView(R.id.ViewCorreo) TextView correo;
        @BindView(R.id.ViewEstado) TextView estado;
        @BindView(R.id.ViewUsuaro) TextView usuario;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
