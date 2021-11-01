package com.example.myapplication;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.myapplication.PreguntaDao;
import com.example.myapplication.PreguntaDB;

public class PreguntaLab{
    @SupressLint("StaticFieldLeak")
    private static PreguntaLab sPreguntaLab;

    private PreguntaDao mPreguntaDao;

    private PreguntaLab(Context context){
        Context appContext = context.getApplicationContext();
        PreguntaDB database = Room.databaseBuilder(appContext, PreguntaDB.class, "pregunta")
                .allowMainThreadQueries().build();
        mPreguntaDao = database.getPreguntaDao();
    }

    public static PreguntaLab get(Context context){
        if(sPreguntaLab == null){
            sPreguntaLab = new PreguntaLab(context);
        }
    }

    //Llamadas a los metodos del Dao
    public List<Pregunta> getPreguntas(){
        return mPreguntaDao.getPreguntas();
    }
    public Pregunta getPregunta(String id){
        return mPreguntaDao.getPregunta(id);
    }
    public void addPregunta(Pregunta p){
        mPreguntaDao.addPregunta(p);
    }
    public void updatePregunta(Pregunta p){
        mPreguntaDao.updatePregunta(p);
    }
    public void deletePregunta(Pregunta p){
        mPreguntaDao.deletePregunta(p);
    }

    //Donde lo he copiado https://javautodidacta.es/base-de-datos-room-en-android/
}