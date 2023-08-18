package chl.ancud.m6_sprint_nuevofono.presentacion.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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
            binding.tvxNombreDetalle.text = it.name
            binding.imgFotoDetalle.load(it.image)
            binding.txvDescripcionDetalle.text = it.description
            binding.txvPrecioDetalle.text = it.price.toString()
        }
    }

}