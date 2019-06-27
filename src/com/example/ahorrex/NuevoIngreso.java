package com.example.ahorrex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

public class NuevoIngreso extends Activity {
	
	private Spinner spinner1;
	private EditText etIngreso;
	private String dia, mes, anio, fecha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingreso);
		
		etIngreso=(EditText) findViewById(R.id.et1);
		
		//Definimos Spinner
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		String []opciones={"Sueldo","Prestamo","Otros"};
		ArrayAdapter<String> adapter = new
		ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
		spinner1.setAdapter(adapter);
		
		NumberPicker np_dia = (NumberPicker) findViewById(R.id.np_dia);
		NumberPicker np_mes = (NumberPicker) findViewById(R.id.np_mes);
		NumberPicker np_anio = (NumberPicker) findViewById(R.id.np_anio);
		
		np_dia.setMinValue(1);
		np_dia.setMaxValue(31);
		np_mes.setMinValue(1);
		np_mes.setMaxValue(12);
		np_anio.setMinValue(2019);
		np_anio.setMaxValue(2030);
		
		np_dia.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                dia = Integer.toString(newVal);
            }
        });
		
		np_mes.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                mes = Integer.toString(newVal);
            }
        });
		
		np_anio.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                anio = Integer.toString(newVal);
            }
        });
		
		fecha = dia + "/" + mes + "/" + anio;
	}

	
	public void aceptar(View view){
		
		//Recibe parametros
		Bundle parametros=getIntent().getExtras();
		String ingresos_actual = parametros.getString("ingresos_actual");
		String nuevo_ingreso = etIngreso.getText().toString();
		
		if(etIngreso.getText().toString().trim().length() > 0){
			
			float suma_ingresos = Float.parseFloat(ingresos_actual);
			float ingreso = Float.parseFloat(nuevo_ingreso);
			suma_ingresos = suma_ingresos + ingreso;
			ingresos_actual = Float.toString(suma_ingresos);
		
			Intent i = new Intent(this, ConsultaPrincipal.class );
			i.putExtra("ingresos_actual", ingresos_actual);
			startActivity(i);
			finish();
		}else{
			Toast tostada =Toast.makeText(this, "Hay datos sin completar",Toast.LENGTH_SHORT);
			tostada.show();
		}
	}
	
	public void cancelar(View view){
		Intent i = new Intent(this, ConsultaPrincipal.class );
		startActivity(i);
		finish();
	}
}
