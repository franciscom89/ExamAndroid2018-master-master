package com.app.expensecontroller.examandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;


public class Tab1 extends Fragment {

    Button bnt_ubicar;
    TextView tv_nombre,tv_direccion,tv_telefono,tv_correo,tv_sitio;
    String getCiudad,getNivel,getTipo;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab1, container, false);
        Bundle bundle= getArguments();

        if (bundle!=null){

            String dato= bundle.getString("ciudad");



        }

        else {
            Log.e("Error","bundle vacio");
        }

        //cargarinfo();



       return view;

    }

    private void cargarinfo() {

        BaseHelper conn= new BaseHelper(getContext(),"bd_establecimiento",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        HashMap<String,String> listaEstablecimientos= new HashMap<>();


        //String sql = "SELECT * FROM ESTABLECIMIENTO WHERE CIUDAD_ESTABLECIMIENTO='"+st_ciudad+"' AND TIPO_ESTABLECIMIENTO='"+st_tipo+"' AND NIVEL_ESTABLECIMIENTO='"+st_nivel+"'";
        //Cursor c = db.rawQuery(sql, null);
    }

    public void pasarinfo(){
        getCiudad=getArguments().getString("ciudad2");
        getNivel=getArguments().getString("nivel2");
        getTipo=getArguments().getString("tipo2");
        /*
        String ciudad=getActivity().getIntent().getExtras().getString("ciudad");
        String nivel=getActivity().getIntent().getExtras().getString("nivel");
        String tipo=getActivity().getIntent().getExtras().getString("tipo");*/
        Log.e("dato",getCiudad);
        Log.e("dato",getNivel);
        Log.e("dato",getTipo);

    }




}
