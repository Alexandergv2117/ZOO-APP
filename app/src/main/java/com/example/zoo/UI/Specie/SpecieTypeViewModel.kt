package com.example.zoo.UI.Specie

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
import com.example.zoo.data.model.SpecieTypeModel
import com.example.zoo.domain.specie.GetSpecieTypeUseCase
import com.example.zoo.domain.specie.SRLSpecieTypeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecieTypeViewModel @Inject constructor(
    private val getSpecieTypeUseCase: GetSpecieTypeUseCase,
    private val srlSpecieTypeUseCase: SRLSpecieTypeUseCase
): ViewModel() {
    val isLoanding = MutableLiveData<Boolean>()

    fun onCreate(adapter: SpecieTypeAdapter, view: View, context: Context) {
        val layoutManager = GridLayoutManager(context, 2)
        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        setRecyclerView(layoutManager, itemDecorator, recyclerView, adapter, context)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecyclerView(
        layoutManager: LinearLayoutManager,
        itemDecorator: DividerItemDecoration,
        recyclerView: RecyclerView,
        adapter: SpecieTypeAdapter,
        context: Context
    ) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(itemDecorator)

        viewModelScope.launch {
            isLoanding.postValue(true)
            try {
                val result = getSpecieTypeUseCase()

                if (result.isNotEmpty()) {
                    adapter.setList(result.map {
                        SpecieTypeModel(
                            id = it.id,
                            tipo = it.tipo,
                            link_foto = it.link_foto
                        )
                    })
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(
                        context,
                        "No se encontraron datos",
                        Toast.LENGTH_SHORT
                    ).show()
                    isLoanding.postValue(false)
                }
            } catch (e: Exception) {
                Toast.makeText(
                    context,
                    "Error al cargar los datos: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
                isLoanding.postValue(false)
            }
        }
    }

    fun onReload (
        layoutManager: LinearLayoutManager,
        itemDecorator: DividerItemDecoration,
        recyclerView: RecyclerView,
        adapter: SpecieTypeAdapter
    ) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(itemDecorator)

        viewModelScope.launch {
            val result = srlSpecieTypeUseCase()

            if(result.isNotEmpty()) {
                adapter.setList(result.map {
                    SpecieTypeModel(
                        id = it.id,
                        tipo = it.tipo,
                        link_foto = it.link_foto
                    )
                })
                adapter.notifyDataSetChanged()
            }
        }
    }
}