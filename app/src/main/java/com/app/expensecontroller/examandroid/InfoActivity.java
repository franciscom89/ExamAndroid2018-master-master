package com.app.expensecontroller.examandroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {



    private TabLayout tabLayout;
    private ViewPager viewPager;

    TextView tv_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String ciudad=getIntent().getExtras().getString("ciudadList");
        String nivel=getIntent().getExtras().getString("nivelList");
        String tipo=getIntent().getExtras().getString("tipoList");


        //ENVIANDO DATA AL FRAGMENT TAB 1


        Log.e("datos",ciudad);
        Log.e("datos",nivel);
        Log.e("datos",tipo);

        TextView tv_nombres=findViewById(R.id.tv_nombre);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout2);
        viewPager = (ViewPager) findViewById(R.id.viewPager2);
        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);

/*
        Tab1 tab1= new Tab1();
        Bundle paquete = new Bundle();

        paquete.putString("ciudad",getIntent().getExtras().getString("ciudad"));
        paquete.putString("tipo",tipo);
        paquete.putString("nivel",nivel);

        tab1.setArguments(paquete);

        Log.e("dato2",paquete.getString("ciudad"));

        if (paquete.getString("ciudad")=="Temuco"){

            Log.e("mensaje","funciona");

        }else {
            Log.e("error","bundle vacio");
        }*/


        /*
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentTab1, tab1); //donde fragmentContainer_id es el ID del FrameLayout donde tu Fragment está contenido.
        fragmentTransaction.commit();*/



/*
        Log.e("dato",ciudad);
        Log.e("dato",nivel);
        Log.e("dato",tipo);*/












        //Una vez haz creado tu instancia de TestFragment y colocado el Bundle entre sus argumentos, usas el FragmentManager para iniciarla desde tu segunda actividad.
        /*
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentTab1, newFragment); //donde fragmentContainer_id es el ID del FrameLayout donde tu Fragment está contenido.
        fragmentTransaction.commit();*/
/*
        String ciudad2=getIntent().getExtras().getString("ciudad");
        String nivel2=getIntent().getExtras().getString("nivel");
        String tipo2=getIntent().getExtras().getString("tipo");

        Intent intent= new Intent(InfoActivity.this,Tab1.class);
        intent.putExtra("ciudad",ciudad2);
        intent.putExtra("tipo",tipo2);
        intent.putExtra("nivel",nivel2);*/


    }




    //METODO PARA CARGAR LOS TABS
    private void setUpViewPager(ViewPager viewPager){
        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());
        tabViewPagerAdapter.addFragment(new Tab1(), "INFO BASICA");
        tabViewPagerAdapter.addFragment(new Tab3(),"INFO DETALLADA");
        viewPager.setAdapter(tabViewPagerAdapter);
    }

}