package chl.ancud.m6_sprint_nuevofono.presentacion.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado
import chl.ancud.m6_sprint_nuevofono.databinding.ItemListadoTelefonoBinding
import coil.load

class AdapterListado: RecyclerView.Adapter<AdapterListado.ItemListadoViewHolder>() {
    lateinit var binding: ItemListadoTelefonoBinding
    private val listaTelefonos = mutableListOf<TelefonoListado>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterListado.ItemListadoViewHolder {
        binding = ItemListadoTelefonoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemListadoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterListado.ItemListadoViewHolder, position: Int) {
        val telefono = listaTelefonos[position]

        holder.bind(telefono)
    }

    override fun getItemCount(): Int {
        return listaTelefonos.size
    }

    class ItemListadoViewHolder(val binding: ItemListadoTelefonoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(telefono: TelefonoListado) {
            binding.txvNombre.text = telefono.name
            binding.txvPrecio.text = telefono.price.toString()
            binding.imgFoto.load(telefono.image)
        }
    }


}