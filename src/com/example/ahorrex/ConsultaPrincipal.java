package com.example.ahorrex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ConsultaPrincipal extends Activity {
	
	private TextView tvSaldo, tvIngresos, tvGastos, tvTarjeta;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_principal);
        
        tvSaldo=(TextView)findViewById(R.id.tvSaldo);
        tvIngresos=(TextView)findViewById(R.id.tvIngresos);
        tvGastos=(TextView)findViewById(R.id.tvGastos);
        tvTarjeta=(TextView)findViewById(R.id.tvTarjeta);
        
        
        // Recibe parametros
        Bundle parametros=getIntent().getExtras();
        if(parametros != null){
        	tvIngresos.setText (parametros.getString("ingresos_actual"));
        	
        	// Recibe ingresos
        	//dato_ingreso = parametros.getString("datoIngreso");
        	//nuevo_ingreso = Float.parseFloat(dato_ingreso);
        	
        	//ingresos = tvIngresos.getText().toString();
        	//suma_ingresos = Float.parseFloat(ingresos);
        	//suma_ingresos =  suma_ingresos + nuevo_ingreso;
        	//tvIngresos.setText(Float.toString(suma_ingresos));
        	
        	// Recibe Gastos
        	//String gastos = tvGastos.getText().toString();
            //float sumaGastos = Float.parseFloat(gastos);
            
            // Calcula Saldo Actual
            //float saldo = suma_ingresos - sumaGastos;
            //tvSaldo.setText(Float.toString(saldo));
            
        }
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_consulta_principal, menu);
        return true;
    }
    
    public void nuevoIngreso(View view){
    	String ingresos_actual = tvIngresos.getText().toString();
		Intent i = new Intent(this, NuevoIngreso.class );
		i.putExtra("ingresos_actual", ingresos_actual);
		startActivity(i);
		finish();
    }
    
    public void nuevoGasto(View view){
    	Intent i= new Intent(this, NuevoGasto.class);
    	startActivity(i);
    }
    
    public void detalle (View view){
    	Intent i= new Intent(this, Detalles.class);
    	startActivity(i);
    }
    
}
