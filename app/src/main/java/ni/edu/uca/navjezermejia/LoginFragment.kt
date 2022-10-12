package ni.edu.uca.navjezermejia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import ni.edu.uca.navjezermejia.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val password = "Somos UCA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentLoginBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btnLogin.setOnClickListener {
            this.validateLogin()
        }
    }

    private fun validateLogin() {
        val passwd = this.binding.etPassword.text.toString()

        if (passwd != this.password) {
            this.binding.txtInputLayout.error = "La contraseña es incorrecta"
            return
        }

        this.binding.etPassword.setText("")

        findNavController().navigate(R.id.menuFragment)
        //findNavController().navigate(R.id.actionLoginToMenu)
    }
}