package com.example.zoo.UI.comment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zoo.data.network.*
import com.example.zoo.databinding.FragmentCommentBinding
import com.example.zoo.di.NetworkModule.provideRetrofit
import com.example.zoo.di.NetworkModule.provideZooApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var apiClient: ZooApiClient
private lateinit var editText: EditText
private lateinit var sendButton: Button
private lateinit var ratingBar: RatingBar

class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val commentViewModel =
            ViewModelProvider(this)[CommentViewModel::class.java]

        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Obtener el contexto
        val context = requireContext()

        // Obtener la instancia de ZooApiClient
        apiClient = provideZooApiClient(provideRetrofit())
        // Obtener las referencias del EditText y el Button
        editText = binding.editText
        sendButton = binding.sendText
        ratingBar = binding.ratingBar
        // Agregar un onClickListener al Button
        sendButton.setOnClickListener {
            val comentario = editText.editableText.toString()
            val rating = ratingBar.rating
            val enviarCalificacionDto = EnviaCalificacionDto(rating)
            if (comentario != null && isVisible && !comentario.isNullOrEmpty() ) {
                val enviarComentarioDto = EnviaComentarioDto(comentario)
                apiClient.enviarCalificacion(enviarCalificacionDto).enqueue(object : Callback<RespuestaCalificacion> {

                    override fun onResponse(call: Call<RespuestaCalificacion>, response: Response<RespuestaCalificacion>) {
                        if (response.isSuccessful) {
                            val builder = AlertDialog.Builder(context)
                            builder.setTitle("Calificación enviada")
                            builder.setMessage("¡Gracias por tu calificación!")
                            builder.setPositiveButton("OK") { dialog, which ->
                                // Cerrar la alerta y hacer cualquier otra acción necesaria
                            }
                            builder.show()
                        } else {
                            val builder = AlertDialog.Builder(context)
                            builder.setTitle("Error al enviar la calificación")
                            builder.setMessage("Hubo un error al enviar tu calificación. Inténtalo de nuevo más tarde.")
                            builder.setPositiveButton("OK") { dialog, which ->
                                // Cerrar la alerta y hacer cualquier otra acción necesaria
                            }
                            builder.show()
                        }
                    }

                    override fun onFailure(call: Call<RespuestaCalificacion>, t: Throwable) {
                        val builder = AlertDialog.Builder(context)
                        builder.setTitle("Error al enviar la calificación")
                        builder.setMessage("Hubo un error al enviar tu calificación.")
                        builder.setPositiveButton("OK") { dialog, which ->
                            // Cerrar la alerta y hacer cualquier otra acción necesaria
                        }
                        builder.show()
                    }
                })
                apiClient.enviarComentario(enviarComentarioDto).enqueue(object :Callback<RespuestaComentario> {

                    override fun onResponse(
                        call: Call<RespuestaComentario>,
                        response: Response<RespuestaComentario>
                    ) {
                        RespuestaComentario("Enviado con Exito")
                    }

                    override fun onFailure(call: Call<RespuestaComentario>, t: Throwable) {
                        RespuestaComentario("Comentario fallo al enviar")

                    }
                })
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}