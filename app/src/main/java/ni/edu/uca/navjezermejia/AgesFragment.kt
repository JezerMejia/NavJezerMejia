package ni.edu.uca.navjezermejia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.navjezermejia.adapter.AgeAdapter
import ni.edu.uca.navjezermejia.databinding.FragmentAgesBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AgesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgesFragment : Fragment() {
    private lateinit var binding: FragmentAgesBinding
    private val agesArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentAgesBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        this.binding.recyclerView.adapter = AgeAdapter(::agesArray)

        this.binding.btnAdd.setOnClickListener {
            this.addAge()
        }
        this.binding.btnCompare.setOnClickListener {
            this.compareAges()
        }
        this.binding.etAge.addTextChangedListener {
            this.binding.txtInputLayout.error = null
        }
        this.binding.btnClear.setOnClickListener {
            val size = this.agesArray.size
            this.agesArray.clear()
            this.binding.recyclerView.adapter?.notifyItemRangeRemoved(0, size)
        }
    }

    private fun addAge() {
        try {
            val age = this.binding.etAge.text.toString().toInt()
            this.agesArray.add(age)

            this.binding.recyclerView.adapter?.notifyItemInserted(this.agesArray.size)
        } catch (ex: Exception) {
            this.binding.txtInputLayout.error = "No se pudo obtener la edad"
        }
    }

    private fun compareAges() {
        if (this.agesArray.size == 0) return
        val sorted = this.agesArray.sorted()
        val first = sorted.first()
        val last = sorted.last()

        this.binding.tvMayor.text = "Mayor: ${last}"
        this.binding.tvMenor.text = "Menor: ${first}"
    }
}