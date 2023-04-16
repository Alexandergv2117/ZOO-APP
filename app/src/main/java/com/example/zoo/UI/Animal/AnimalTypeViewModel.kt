package com.example.zoo.UI.Animal

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R
import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.domain.animal.GetAnimalTypeUseCase
import com.example.zoo.domain.animal.SRLAnimalTypeUseCase
import com.example.zoo.utils.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalTypeViewModel @Inject constructor(
    private val getAnimalTypeUseCase: GetAnimalTypeUseCase,
    private val srlAnimalTypeUseCase: SRLAnimalTypeUseCase
): ViewModel() {
    val isLoanding = MutableLiveData<Boolean>()

    fun onCreate(adapter: AnimalTypeAdapter, view: View, context: Context, tipo: String) {
        val layoutManager = GridLayoutManager(context, 2)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        setRecyclerView(layoutManager, recyclerView, adapter, context, tipo)
    }

     @SuppressLint("NotifyDataSetChanged")
     private fun setRecyclerView(
         layoutManager: GridLayoutManager,
         recyclerView: RecyclerView,
         adapter: AnimalTypeAdapter,
         context: Context,
         tipo: String
     ) {
         recyclerView.layoutManager = layoutManager
         recyclerView.adapter = adapter

         viewModelScope.launch {
             isLoanding.postValue(true)
             try {
                 val result = getAnimalTypeUseCase(tipo)

                 if (result.isNotEmpty()) {
                     adapter.setList(result.map {
                         AnimalTypeModel (
                             id = it.id,
                             imagen = it.imagen,
                             nombre = it.nombre,
                             scientific_name = it.scientific_name,
                             origen = it.origen,
                             habitat = it.habitat,
                             riesgo = it.riesgo,
                             tamanio = it.tamanio,
                             reproduccion = it.reproduccion,
                             alimentacion = it.alimentacion,
                             descripcion = it.descripcion,
                             video = it.video,
                             mapa = it.mapa,
                             audio = it.audio,
                             gif = it.gif,
                             especie = it.especie,
                         )
                     })
                     adapter.notifyDataSetChanged()
                 } else {
                     if (Const.isLoggedIn) {
                         Toast.makeText(
                             context,
                             "No se encontraron datos de animales",
                             Toast.LENGTH_SHORT
                         ).show()
                         isLoanding.postValue(false)
                     }
                 }
             } catch (e: Exception) {
                    if (Const.isLoggedIn) {
                        Toast.makeText(
                            context,
                            "Error al obtener datos de animales",
                            Toast.LENGTH_SHORT
                        ).show()
                        isLoanding.postValue(false)
                    }
             }
         }
     }

    fun onReload (
        layoutManager: LinearLayoutManager,
        recyclerView: RecyclerView,
        adapter: AnimalTypeAdapter,
        tipo: String
    ) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        viewModelScope.launch {
            val result = srlAnimalTypeUseCase(tipo)

            if (result.isNotEmpty()) {
                adapter.setList(result.map {
                    AnimalTypeModel (
                        id = it.id,
                        imagen = it.imagen,
                        nombre = it.nombre,
                        scientific_name = it.scientific_name,
                        origen = it.origen,
                        habitat = it.habitat,
                        riesgo = it.riesgo,
                        tamanio = it.tamanio,
                        reproduccion = it.reproduccion,
                        alimentacion = it.alimentacion,
                        descripcion = it.descripcion,
                        video = it.video,
                        mapa = it.mapa,
                        audio = it.audio,
                        gif = it.gif,
                        especie = it.especie,
                    )
                })
                adapter.notifyDataSetChanged()
            }
        }
    }
}