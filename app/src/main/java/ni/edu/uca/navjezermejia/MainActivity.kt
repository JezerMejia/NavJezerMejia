package ni.edu.uca.navjezermejia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import ni.edu.uca.navjezermejia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.navController = findNavController(R.id.fragmentView)
    }

    override fun onSupportNavigateUp(): Boolean {
        return this.navController.navigateUp() || super.onSupportNavigateUp()
    }
}