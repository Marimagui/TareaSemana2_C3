package code.maribelhll.tareasemana2_c3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    TextView mNombre, mTelefono, mEmail, mDescripcion, mFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        mNombre = (TextView) findViewById(R.id.txtNombre);
        mTelefono = (TextView) findViewById(R.id.txtTelf);
        mEmail = (TextView) findViewById(R.id.txtEmail);
        mDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        mFecha = (TextView) findViewById(R.id.txtFecha);

        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null){

            String nombre = bundle.getString("nombre");
            String telefono = bundle.getString("telefono");
            String email = bundle.getString("email");
            String descripcion = bundle.getString("descripcion");
            String fecha = bundle.getString("fecha");
            mNombre.setText(nombre);
            mTelefono.setText("Tel." + telefono);
            mEmail.setText("Email:" + email);
            mDescripcion.setText("Descripcion: "+ descripcion);
            mFecha.setText("Fecha de Nacimiento:" + fecha);
        }

    }

    public void onClick(View view) {
        finish();
        //Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
        //startActivity(intent);
    }
}
