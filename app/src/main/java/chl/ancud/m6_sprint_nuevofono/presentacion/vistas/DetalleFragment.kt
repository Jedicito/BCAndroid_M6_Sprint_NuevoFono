package chl.ancud.m6_sprint_nuevofono.presentacion.vistas

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import chl.ancud.m6_sprint_nuevofono.R
import chl.ancud.m6_sprint_nuevofono.databinding.FragmentDetalleBinding
import chl.ancud.m6_sprint_nuevofono.presentacion.TelefonoViewModel
import coil.load


class DetalleFragment : Fragment() {
    private var paramId: Long? = null
    lateinit var binding: FragmentDetalleBinding
    private val telefonoViewModel: TelefonoViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramId = it.getLong("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)
        setComponentes(paramId!!)
        return binding.root
    }

    private fun setComponentes(id: Long) {
        telefonoViewModel.getTelefonoDetalle(id)
        telefonoViewModel.telefonoLiveData(id).observe(viewLifecycleOwner) {
            if (it != null) {
                val nombre = it.name
                val precio = it.price.toString()
                binding.tvxNombreDetalle.text = nombre
                binding.imgFotoDetalle.load(it.image)
                binding.txvDescripcionDetalle.text = it.description
                binding.txvPrecioDetalle.text = getString(R.string.txvPrecioDetalle, precio)

                binding.flbCorreo.setOnClickListener {
                    val intentCorreo = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:")
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("info@novaera.cl"))
                        putExtra(Intent.EXTRA_SUBJECT, getString(R.string.correoAsunto, nombre))
                        putExtra(Intent.EXTRA_TEXT, getString(R.string.correoMensaje, nombre, precio))
                    }
                    startActivity(intentCorreo)
                }
            }
        }

        /// No me funciona el botón de volver del celu
        binding.flbVolver.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_detalleFragment_to_listadoFragment)
        }


    }

}