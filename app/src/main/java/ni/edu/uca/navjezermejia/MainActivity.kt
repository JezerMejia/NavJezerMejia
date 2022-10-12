package ni.edu.uca.navjezermejia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.navjezermejia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }
}