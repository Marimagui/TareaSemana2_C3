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

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDataSetListener;

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


        mDisplayDate = (TextView) findViewById(R.id.txtFechaNacimiento);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int ano = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDataSetListener,ano,mes,dia);
                dialog.show();
            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG, "onDateSet:date:" + year+"/"+month+"/"+dayOfMonth);

                campoFecha= dayOfMonth +"/"+month+"/"+year;
            }
        };



    }

    public void onClick(View view) {
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
