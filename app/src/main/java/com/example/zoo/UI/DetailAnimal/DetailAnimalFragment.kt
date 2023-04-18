package com.example.zoo.UI.DetailAnimal

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.TooltipCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.zoo.R
import com.example.zoo.databinding.FragmentDetailAnimalBinding
import com.example.zoo.utils.Const
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.squareup.picasso.Picasso

class DetailAnimalFragment : Fragment() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var player: ExoPlayer
    private val args by navArgs<DetailAnimalFragmentArgs>()
    private var _binding: FragmentDetailAnimalBinding? = null
    private lateinit var botonAudio: ImageButton

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        //  Reproductor de Video
        val uri = "https://drive.google.com/uc?export=download&id=1-AtTgvpYYE6l0Dm2jTd8BIwfcm08KW0k"
        if (uri.isNotEmpty()){
            player = ExoPlayer.Builder(requireContext()).build()
            var exoPlayerView = binding.playerView
            exoPlayerView.player = player
            val mediaItem = MediaItem.fromUri(uri)
            player.setMediaItem(mediaItem)
            player.prepare()
        }else{
            binding.playerView.visibility = View.GONE // Oculta el reproductor de video si la URI está vacía
        }
        
        Glide.with(this)
            .asGif()
            .load("${Const.BASE_URL_GOOGLE_DRIVE}${args.animalType.gif}")
            .into(binding.gifAnimal)

        binding.nombreCientifico.text = args.animalType.scientific_name
        binding.nombre.text = args.animalType.nombre
        binding.textOrigen.text = args.animalType.origen
        binding.textHabitat.text = args.animalType.habitat
        binding.textRiesgo.text = args.animalType.riesgo
        binding.textTamanio.text = args.animalType.tamanio
        binding.textReproduccion.text = args.animalType.reproduccion
        binding.textAlimentacion.text = args.animalType.alimentacion
        binding.descripcion.text = args.animalType.descripcion
        //Dibujar iconos

        // endemica o no
        ///Riesgo
        if (args.animalType.origen == "Especie endémica "){
            binding.iconoOrigen.setImageResource(R.drawable.especie_endemica)
        }else{
            binding.iconoOrigen.setImageResource(R.drawable.no_endemica)
        }
                ///Riesgo
        if (args.animalType.riesgo == "bajo"){
            binding.iconoRiesgo.setImageResource(R.drawable.no_peligro)
        }else{
            binding.iconoRiesgo.setImageResource(R.drawable.peligro)
        }
                ///Habitat
            binding.iconoHabitat.setImageResource(R.drawable.habitat)
                ///Reproduccion
        if (args.animalType.reproduccion == "ovíparos (ponen huevos)"){
            binding.iconoReproduccion.setImageResource(R.drawable.oviparo)
        }else{
            binding.iconoReproduccion.setImageResource(R.drawable.viviparo)
        }
                ///Alimentacion
        if (args.animalType.alimentacion == "Insectivoro"){
            binding.iconoAlimentacion.setImageResource(R.drawable.grillo)
        }else if (args.animalType.alimentacion == "Herbívoros  "){
            binding.iconoAlimentacion.setImageResource(R.drawable.herbivoro)
        }else{
            binding.iconoAlimentacion.setImageResource(R.drawable.omnivoro)
        }
                ///Tamaño
            binding.iconoTamanio.setImageResource(R.drawable.tamanio)

        Picasso.get()
            .load("${Const.BASE_URL_GOOGLE_DRIVE}${args.animalType.mapa}")
            .into(binding.mapa)

        //Activacion y Lectura de MP3 URL
        botonAudio = binding.audioAnimal
        botonAudio.setOnClickListener {
            val tooltipText = "Reproducir/Pausar"
            TooltipCompat.setTooltipText(botonAudio, tooltipText)
            val url = "${Const.BASE_URL_GOOGLE_DRIVE}${args.animalType.audio}" // URL del archivo de audio
            mediaPlayer = MediaPlayer()
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                .build()
            mediaPlayer?.let {
                it.setAudioAttributes(audioAttributes)
                it.setDataSource(url)
                it.prepareAsync()
                if (it.isPlaying){
                    it.pause()
                }else{
                    it.setOnPreparedListener {
                        it.start()
                    }
                }
            }

        }
        //para reproducir un gif
        Glide.with(this).asGif().load("https://drive.google.com/uc?id=1xdXkTWDhF0y4lMdfUr9faD3KpiaIdVzf").into(binding.gifAnimal)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        player.release()
        mediaPlayer?.release()

    }
}