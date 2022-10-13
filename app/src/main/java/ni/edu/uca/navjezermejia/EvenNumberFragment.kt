package ni.edu.uca.navjezermejia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.navjezermejia.adapter.EvenNumberAdapter
import ni.edu.uca.navjezermejia.databinding.FragmentEvenNumberBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EvenNumberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EvenNumberFragment : Fragment() {
    private lateinit var binding: FragmentEvenNumberBinding
    private val numbersArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentEvenNumberBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        this.binding.recyclerView.adapter = EvenNumberAdapter(::numbersArray)

        this.binding.btnList.setOnClickListener {
            this.showList()
        }
        this.binding.btnClear.setOnClickListener {
            this.clearList()
            this.binding.etNum1.setText("")
            this.binding.etNum2.setText("")
        }
    }

    private fun clearList() {
        val size = this.numbersArray.size
        this.numbersArray.clear()
        this.binding.recyclerView.adapter?.notifyItemRangeRemoved(0, size)
    }

    private fun showList() {
        var firstNumber = -1
        var lastNumber = -1
        try {
            firstNumber = this.binding.etNum1.text.toString().toInt()
        } catch (ex: Exception) {
            this.binding.etNum1Layout.error = "No se pudo obtener el número"
            return
        }
        try {
            lastNumber = this.binding.etNum2.text.toString().toInt()
        } catch (ex: Exception) {
            this.binding.etNum2Layout.error = "No se pudo obtener el número"
            return
        }

        this.clearList()
        if (firstNumber % 2 != 0) firstNumber++

        for (i in firstNumber .. lastNumber step 2) {
            this.numbersArray.add(i)
            this.binding.recyclerView.adapter?.notifyItemInserted(this.numbersArray.size - 1)
        }
    }
}