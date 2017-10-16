package exam.francys.appagenda.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.Unbinder;
import exam.francys.appagenda.DataBase.CRUD_Diary;
import exam.francys.appagenda.DataBase.Diarys;
import exam.francys.appagenda.Models.Usuario;
import exam.francys.appagenda.R;

import static butterknife.ButterKnife.bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUser extends Fragment {

    @BindView(R.id.Nombre) MaterialEditText nombre;
    @BindView(R.id.Apellidos) MaterialEditText app;
    @BindView(R.id.direccion) MaterialEditText direccion;
    @BindView(R.id.telefono) MaterialEditText telefono;
    @BindView(R.id.Correo) MaterialEditText correo;
    @BindView(R.id.Usuario) MaterialEditText usuario;
    @BindView(R.id.Contra) MaterialEditText contra;

    private Usuario User;
    private Diarys agenda;
    private int Numeroesta=1;
    private Unbinder unbinder;

    public CreateUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        return inflater.inflate(R.layout.fragment_create_user2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        User = new Usuario();
        agenda = new Diarys(view.getContext());
 //       CRUD_Diary.getall(agenda);
    }

    @OnCheckedChanged(R.id.Casado) void onChecked(boolean checked) {
        if(checked !=false) Numeroesta =1;
    }

    @OnCheckedChanged(R.id.Soltero) void onCheck(boolean check){
        if(check != false) Numeroesta =2;
    }


    @OnClick(R.id.agregar)
    public void addUser(View view){

        if(nombre.length()>0 && app.length()>0 && direccion.length() >0
                && telefono.length() >9 && correo.length() >0
                && usuario.length()>0 && contra.length() >6 ){

            if(CRUD_Diary.buscarNombre(agenda,nombre.getText().toString()) ==0 &&
                    CRUD_Diary.buscacorreo(agenda,correo.getText().toString()) ==0 &&
                    CRUD_Diary.buscaUsuario(agenda,usuario.getText().toString())==0){

                        User.setNombre(nombre.getText().toString());
                        User.setApp(app.getText().toString());
                        User.setDireccion(direccion.getText().toString());
                        User.setTelefono(telefono.getText().toString());
                        User.setCorreo(correo.getText().toString());
                        User.setEstado(String.valueOf(Numeroesta));
                        User.setUsuario(usuario.getText().toString());
                        User.setContrase(contra.getText().toString());

                try{
                    long numero= CRUD_Diary.Ingresa(agenda, User);
                    Toast.makeText(view.getContext(), "usuario registrado numero " + numero, Toast.LENGTH_SHORT).show();

                }catch (Exception e){}

            }else {
                this.EventoNavigation("El nombre,correo o usuario que ingreso ya existen",view);
            }

        }else{
            this.EventoNavigation("Verifica, Campos vacios",view);
        }

    }



    private void EventoNavigation(String text,View view){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(view.getContext());
        dialogo1.setTitle(text);
        dialogo1.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
