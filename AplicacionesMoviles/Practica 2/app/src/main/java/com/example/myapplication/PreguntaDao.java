package com.example.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import com.example.myapplication.Pregunta;

@Dao
public interface PreguntaDao{

    @Query("SELECT * FROM Pregunta")
    List<Pregunta> getPreguntas();

    @Query("SELECT * FROM Pregunta WHERE questionID LIKE :qID")
    Pregunta getPregunta(String qID);

    @Insert
    void addPregunta(Pregunta p);

    @Delete
    void deletePregunta(Pregunta p);

    @Update
    void updatePregunta(Pregunta p);
}