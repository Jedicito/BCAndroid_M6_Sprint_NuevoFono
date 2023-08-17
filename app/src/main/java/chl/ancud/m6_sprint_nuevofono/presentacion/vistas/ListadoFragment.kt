package chl.ancud.m6_sprint_nuevofono.presentacion.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import chl.ancud.m6_sprint_nuevofono.R
import chl.ancud.m6_sprint_nuevofono.data.Repositorio
import chl.ancud.m6_sprint_nuevofono.databinding.FragmentListadoBinding
import chl.ancud.m6_sprint_nuevofono.presentacion.TelefonoViewModel
import chl.ancud.m6_sprint_nuevofono.presentacion.adaptadores.AdapterListado

class ListadoFragment : Fragment() {
    lateinit var binding: FragmentListadoBinding
    private val telefonoViewModel: TelefonoViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListadoBinding.inflate(layoutInflater)
        ///initListeners()
        initAdapter()
        return binding.root
    }

    private fun initListeners() {


    }

    private fun initAdapter() {
        val adapter = AdapterListado()
        telefonoViewModel.getAllTelefonos()
        binding.rvListado.adapter = adapter
        telefonoViewModel.telefonosLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }

}