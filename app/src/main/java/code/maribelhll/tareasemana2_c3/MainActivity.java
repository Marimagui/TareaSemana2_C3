package code.maribelhll.tareasemana2_c3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    EditText campoNombre, campoTelefono, campoEmail, campoDescripcion;
    String campoFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = (EditText) findViewById(R.id.etxtNombre);
        campoTelefono = (EditText) findViewById(R.id.etxtTelefono);
        campoEmail = (EditText) findViewById(R.id.etxtEmail);
        campoDescripcion = (EditText) findViewById(R.id.etxtDescripcion);

        }

    public void onClick(View view) {

        DatePicker fecha = (DatePicker) findViewById(R.id.dpFecha) ;
        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonth()+1;
        int ano = fecha.getYear();

        campoFecha = dia +"/"+mes+"/"+ano;

        Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

        Bundle bundle = new Bundle();
        bundle.putString("nombre",campoNombre.getText().toString());
        bundle.putString("telefono",campoTelefono.getText().toString());
        bundle.putString("email", campoEmail.getText().toString());
        bundle.putString("descripcion", campoDescripcion.getText().toString());
        bundle.putString("fecha", campoFecha.toString());

        intent.putExtras(bundle);

        startActivity(intent);

    }
}
