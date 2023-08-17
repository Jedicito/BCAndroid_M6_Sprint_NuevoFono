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


class DetalleFragment : Fragment() {
    private var paramId: Int? = null
    lateinit var binding: FragmentDetalleBinding
    private val telefonoViewModel: TelefonoViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramId = it.getInt("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)
        setComponents()
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    private fun setComponents() {
        binding.tvxNombreDetalle.text = paramId
    }

}