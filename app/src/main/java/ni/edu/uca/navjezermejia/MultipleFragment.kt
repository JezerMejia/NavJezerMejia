package ni.edu.uca.navjezermejia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import ni.edu.uca.navjezermejia.databinding.FragmentMultipleBinding
import java.lang.Error

/**
 * A simple [Fragment] subclass.
 * Use the [MultipleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MultipleFragment : Fragment() {
    private lateinit var binding: FragmentMultipleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentMultipleBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btnEvaluate.setOnClickListener {
            this.evaluateNumber()
        }
        this.binding.etNumber.addTextChangedListener {
            this.binding.txtInputLayout.error = null
        }
    }

    private fun evaluateNumber() {
        try {
            val number = this.binding.etNumber.text.toString().toInt()
            println("NUMBER: ${number}")
            if (number % 3 == 0) {
                Toast.makeText(this.requireContext(), "El número es múltiplo de 3", Toast.LENGTH_SHORT).show()
            } else if (number % 5 == 0) {
                Toast.makeText(this.requireContext(), "El número es múltiplo de 5", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.requireContext(), "El número no es un múltiplo de 3 o 5", Toast.LENGTH_SHORT).show()
            }
        } catch (ex: Exception) {
            this.binding.txtInputLayout.error = "No se pudo evaluar"
            println(ex)
        }
    }
}