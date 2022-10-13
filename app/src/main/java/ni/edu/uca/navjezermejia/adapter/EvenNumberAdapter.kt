package ni.edu.uca.navjezermejia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.navjezermejia.databinding.AgeItemBinding
import ni.edu.uca.navjezermejia.databinding.EvenNumberItemBinding
import kotlin.reflect.KProperty0

class EvenNumberAdapter(private var evenNumbers: KProperty0<ArrayList<Int>>) :
    RecyclerView.Adapter<EvenNumberAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: EvenNumberItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun load(number: Int) {
                this.binding.tvNumber.text = "- $number"
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EvenNumberItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val age = this.evenNumbers.get()[position]
        holder.load(age)
    }

    override fun getItemCount(): Int {
        return this.evenNumbers.get().size
    }
}