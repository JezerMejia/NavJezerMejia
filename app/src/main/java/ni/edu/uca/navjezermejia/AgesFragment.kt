package ni.edu.uca.navjezermejia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import ni.edu.uca.navjezermejia.databinding.FragmentAgesBinding
import ni.edu.uca.navjezermejia.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AgesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgesFragment : Fragment() {
    private lateinit var binding: FragmentAgesBinding
    private val array = ArrayList<Int>()

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
            this.array.clear()
        }
    }

    private fun addAge() {
        try {
            val age = this.binding.etAge.text.toString().toInt()
            this.array.add(age)
        } catch (ex: Exception) {
            this.binding.txtInputLayout.error = "No se pudo obtener la edad"
        }
    }

    private fun compareAges() {
        this.array.sort()
        val first = this.array.first()
        val last = this.array.last()

        this.binding.tvMayor.setText("Mayor: ${last}")
        this.binding.tvMenor.setText("Menor: ${first}")
    }
}