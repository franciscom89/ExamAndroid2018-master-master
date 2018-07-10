package com.app.expensecontroller.examandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.firebase.database.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListadoActivity extends AppCompatActivity {

    ListView lv_establecimientos;
    ArrayList<String> ciudadArray = new ArrayList<>();
    ArrayList<String> nivelArray = new ArrayList<>();
    ArrayList<String> tipoArray = new ArrayList<>();
    String ciudad1,nivel1,tipo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lv_establecimientos=findViewById(R.id.lv_establecimientos);
        //ListView resultsListView = (ListView) findViewById(R.id.lv_establecimientos);


        ciudad1=getIntent().getExtras().getString("ciudad");
        nivel1=getIntent().getExtras().getString("nivel");
        tipo1=getIntent().getExtras().getString("tipo");

        Intent intent= new Intent(ListadoActivity.this,ListadoActivity.class);
        intent.putExtra("ciudad",ciudad1);
        intent.putExtra("tipo",nivel1);
        intent.putExtra("nivel",tipo1);
        Log.e("dato",ciudad1);


        Bundle bundle= new Bundle();
        bundle.putString("ciudad",ciudad1);
        bundle.putString("tipo",tipo1);
        bundle.putString("nivel",nivel1);
        Tab1 tab1=new Tab1();
        tab1.setArguments(bundle);


/*
        Intent intent= new Intent(ListadoActivity.this,Tab1.class);
        Bundle data = new Bundle();//create bundle instance

        Tab1.setArguments(data);
        data.putString("ciudad", ciudad1);
        data.putString("nivel", nivel1);
        data.putString("tipo", tipo1);*/

/*
        Bundle bundle= new Bundle();
        Intent intent = new Intent(ListadoActivity.this, InfoActivity.class);
        bundle.putString("ciudad","juan");
        intent.putExtras(bundle);
        startActivity(intent);*/


       // bundle.putString("tipo",tipo1);
       // bundle.putString("nivel",nivel1);


       // Tab1 tab1=new Tab1();

       //tab1.setArguments(bundle);




       // pasarDatosFragment();
        /*
        Bundle bundle= new Bundle();
        bundle.putString("ciudad2",ciudad1);
        bundle.putString("tipo2",tipo1);
        bundle.putString("nivel2",nivel1);
        Tab1 tab1=new Tab1();
        tab1.setArguments(bundle);*/


        /*
        Intent intent= new Intent(ListadoActivity.this,Tab1.class);
        intent.putExtra("ciudad",ciudad1);
        intent.putExtra("tipo",tipo1);
        intent.putExtra("nivel",nivel1);*/


        ciudadArray.add(ciudad1);
        nivelArray.add(nivel1);
        tipoArray.add(tipo1);

        Log.e("Ciudad",ciudad1);
        Log.e("Nivel",nivel1);
        Log.e("Tipo",tipo1);

        cargarLista(ciudad1,nivel1,tipo1);

        lv_establecimientos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(ListadoActivity.this,InfoActivity.class);

                String lista=lv_establecimientos.getItemAtPosition(position).toString();
                String ciudadSeleccionada = ciudadArray.get(position);
                String nivelSeleccionado = nivelArray.get(position);
                String tipoSeleccionado = tipoArray.get(position);


                //PASANDO DATOS A INFOACTIVITY
                intent.putExtra("ciudadList",ciudadSeleccionada);
                intent.putExtra("nivelList",nivelSeleccionado);
                intent.putExtra("tipoList",tipoSeleccionado);

                Bundle bundle= new Bundle();
                bundle.putString("ciudadBundle",ciudadSeleccionada);
                bundle.putString("nivelBundle",nivelSeleccionado);
                bundle.putString("tipoBundle",tipoSeleccionado);
                Tab1 fragmento=new Tab1();
                fragmento.setArguments(bundle);


                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Ciudad seleccionada: "+ciudadSeleccionada+"\n Nivel seleccionado: "+nivelSeleccionado+"\n Tipo seleccionado: "+tipoSeleccionado,Toast.LENGTH_SHORT).show();



                //Log.e("Item",lista);
            }
        });
        {


        }
/*
        HashMap<String, String> nameAddresses = new HashMap<>();
        nameAddresses.put("Diana", "3214 Broadway Avenue");
        nameAddresses.put("Tyga", "343 Rack City Drive");
        nameAddresses.put("Rich Homie Quan", "111 Everything Gold Way");
        nameAddresses.put("Donna", "789 Escort St");
        nameAddresses.put("Bartholomew", "332 Dunkin St");
        nameAddresses.put("Eden", "421 Angelic Blvd");


        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.lista,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});


        Iterator it = nameAddresses.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        resultsListView.setAdapter(adapter);*/
    }

/*
    public Fragment pasarDatosFragment(){

        Bundle bundle= new Bundle();
        bundle.putString("ciudad",ciudad1);
        bundle.putString("tipo",tipo1);
        bundle.putString("nivel",nivel1);
        Tab1 tab1=new Tab1();
        tab1.setArguments(bundle);


        return tab1;

    }*/

    public void cargarLista(String st_ciudad,String st_nivel,String st_tipo){

        BaseHelper conn= new BaseHelper(getApplicationContext(),"bd_establecimiento",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        HashMap<String,String> listaEstablecimientos= new HashMap<>();


        String sql = "SELECT * FROM ESTABLECIMIENTO WHERE CIUDAD_ESTABLECIMIENTO='"+st_ciudad+"' AND TIPO_ESTABLECIMIENTO='"+st_tipo+"' AND NIVEL_ESTABLECIMIENTO='"+st_nivel+"'";
        Cursor c = db.rawQuery(sql, null);


        while (c.moveToNext()) {
            String nombre_establecimiento=c.getString(c.getColumnIndex("NOMBRE_ESTABLECIMIENTO"));
            String tipo_establecimiento="Establecimiento "+c.getString(c.getColumnIndex("TIPO_ESTABLECIMIENTO"));
            listaEstablecimientos.put(nombre_establecimiento,tipo_establecimiento);

        }

        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.lista,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});

        Iterator it = listaEstablecimientos.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        lv_establecimientos.setAdapter(adapter);
    }
}
