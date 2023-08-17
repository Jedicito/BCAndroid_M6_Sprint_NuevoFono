package chl.ancud.m6_sprint_nuevofono.presentacion.adaptadores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m6_sprint_nuevofono.R
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoListadoEntity
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado
import chl.ancud.m6_sprint_nuevofono.databinding.ItemListadoTelefonoBinding
import coil.load

class AdapterListado: RecyclerView.Adapter<AdapterListado.ItemListadoViewHolder>() {
    lateinit var binding: ItemListadoTelefonoBinding
    private val listaTelefonos = mutableListOf<TelefonoListadoEntity>()

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

    fun setData(telefonos: List<TelefonoListadoEntity>) {
        this.listaTelefonos.clear()
        this.listaTelefonos.addAll(telefonos)
        notifyDataSetChanged()
    }

    class ItemListadoViewHolder(val binding: ItemListadoTelefonoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(telefono: TelefonoListadoEntity) {
            binding.txvNombre.text = telefono.name
            binding.txvPrecio.text = telefono.price.toString()
            binding.imgFoto.load(telefono.image)

            var bundle = Bundle()
            binding.constraintLayoutItemListado.setOnClickListener {
                bundle.putInt("id", it.id)
                Navigation.findNavController(binding.root).navigate(R.id.action_listadoFragment_to_detalleFragment, bundle)
            }
        }
    }


}