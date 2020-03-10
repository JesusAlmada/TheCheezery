package mx.itson.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_colddrinks.setOnClickListener {
            var intent = Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        btn_hotdrinks.setOnClickListener{
            var intent = Intent(this, ProductHotDrinks::class.java)
            startActivity(intent)
        }

        btn_sweets.setOnClickListener{
            var intent = Intent(this, ProductHotDrinks::class.java)
            startActivity(intent)
        }
        btn_combos.setOnClickListener{
            var intent = Intent(this,ProductosCombos::class.java)
            startActivity(intent)
        }
    }
}
