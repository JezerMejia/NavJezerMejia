package ni.edu.uca.navjezermejia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.navjezermejia.databinding.AgeItemBinding
import kotlin.reflect.KProperty0

class AgeAdapter(private var ages: KProperty0<ArrayList<Int>>) :
    RecyclerView.Adapter<AgeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: AgeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun load(age: Int) {
                this.binding.etAge.text = "Edad: $age"
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AgeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val age = this.ages.get()[position]
        holder.load(age)
    }

    override fun getItemCount(): Int {
        return this.ages.get().size
    }
}