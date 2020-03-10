package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_product_salties.*
import kotlinx.android.synthetic.main.activity_productos_saltiess.*
import kotlinx.android.synthetic.main.producto_view.view.*

class ProductosSaltiesActivity : AppCompatActivity() {

    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coldproductos)

        cargarProductos()

        var adaptador = AdaptadorProductos(this, salties)
        listview.adapter = adaptador
    }

    fun cargarProductos(){
        salties.add(Product("Chicken Crepes", R.drawable.chickencrepes, "Crepes stuffed with alfredo chicken", 6))

        salties.add(Product("Club sandwich", R.drawable.clubsandwich, "A good ol' sandwich", 5))

        salties.add(Product("Panini", R.drawable.hampanini, "An italian sandwich..", 4))

        salties.add(Product("Philly cheese steak", R.drawable.phillycheesesteak, "A deliciuos steak with a side of onions and mushrooms", 6))

        salties.add(Product("Nachos", R.drawable.nachos, "Tortilla nachos with a lot of cheese", 7))
    }

    private class AdaptadorProductos : BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.contexto = contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            vista.producto_img.setImageResource(prod.image)
            vista.producto_nombre.setText(prod.name)
            vista.producto_desc.setText(prod.description)
            vista.producto_precio.setText("$${prod.price}")

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }

    }
}
