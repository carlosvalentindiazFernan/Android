package exam.francys.appagenda;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.rengwuxian.materialedittext.MaterialEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import exam.francys.appagenda.DataBase.AgendaDB;
import exam.francys.appagenda.DataBase.CRUD_Ajenda;
import exam.francys.appagenda.Models.Usuario;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Nombre) MaterialEditText nombre;
    @BindView(R.id.Apellidos) MaterialEditText app;
    @BindView(R.id.direccion) MaterialEditText direccion;
    @BindView(R.id.telefono) MaterialEditText telefono;
    @BindView(R.id.Correo) MaterialEditText correo;
    @BindView(R.id.EstadoGrupo) RadioGroup estado;
    @BindView(R.id.Usuario) MaterialEditText usuario;
    @BindView(R.id.Contra) MaterialEditText contra;

    Usuario User;
    AgendaDB agenda;
    int Numeroesta=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        User = new Usuario();

        agenda = new AgendaDB(this);

        CRUD_Ajenda.getall(agenda);

        estado.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.Casado){
                    Numeroesta =1;
                }else  if(checkedId == R.id.Soltero){
                    Numeroesta =2;
                }
            }
        });


    }


    @OnClick(R.id.agregar)
    public void agrega(View view){

        Log.d("hola",nombre.getText().toString()+" "+ app.getText().toString() +" "
                + direccion.getText().toString()+" "+ telefono.getText().toString()+ " "
                + correo.getText().toString()+" "+ usuario.getText().toString() +" "+ contra.getText().toString()  );

        if(nombre.length()>0 && app.length()>0 && direccion.length() >0
                && telefono.length() >9 && correo.length() >0
                && usuario.length()>0 && contra.length() >6 ){

            if(CRUD_Ajenda.buscarNombre(agenda,nombre.getText().toString()) ==0 &&
                    CRUD_Ajenda.buscacorreo(agenda,correo.getText().toString()) ==0 &&
                    CRUD_Ajenda.buscaUsuario(agenda,usuario.getText().toString())==0){

                    User.setNombre(nombre.getText().toString());
                    User.setApp(app.getText().toString());
                    User.setDireccion(direccion.getText().toString());
                    User.setTelefono(telefono.getText().toString());
                    User.setCorreo(correo.getText().toString());
                    User.setEstado(String.valueOf(Numeroesta));
                    User.setUsuario(usuario.getText().toString());
                    User.setContrase(contra.getText().toString());

                    try{
                        long numero= CRUD_Ajenda.Ingresa(agenda, User);
                        Toast.makeText(this, "usuario registrado numero " + numero, Toast.LENGTH_SHORT).show();

                    }catch (Exception e){}

            }else {
                this.EventoNavigation("El nombre,correo o usuario que ingreso ya existen");
            }

        }else{
            this.EventoNavigation("Verifica, Campos vacios");
        }

    }



    private void EventoNavigation(String text){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle(text);
        dialogo1.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
            }).show();
    }






}
