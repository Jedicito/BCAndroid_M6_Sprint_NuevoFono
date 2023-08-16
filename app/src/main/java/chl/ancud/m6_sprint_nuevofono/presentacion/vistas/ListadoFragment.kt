package chl.ancud.m6_sprint_nuevofono.presentacion.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chl.ancud.m6_sprint_nuevofono.R
import chl.ancud.m6_sprint_nuevofono.databinding.FragmentListadoBinding
import chl.ancud.m6_sprint_nuevofono.presentacion.adaptadores.AdapterListado

class ListadoFragment : Fragment() {
    lateinit var binding: FragmentListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListadoBinding.inflate(layoutInflater)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterListado()
        binding.rvListado.adapter = adapter
    }

}