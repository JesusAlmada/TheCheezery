package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_productos_hot.*
import kotlinx.android.synthetic.main.producto_view.view.*

class ProductosHotActivity : AppCompatActivity() {

    var hotdrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_hot)

        cargarProductos()

        var adaptador = ProductosHotActivity.AdaptadorProductos(this, hotdrinks)
        listview_hot.adapter = adaptador
    }

    fun cargarProductos(){
        hotdrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6))

        hotdrinks.add(Product("Hot Chocolate", R.drawable.hotchocolate, "Heated drink consisted of shaved chocolate, topped with marshmallows", 5))

        hotdrinks.add(Product("Espresso", R.drawable.espresso, "Full flavored, concentrated form of coffeee", 4))

        hotdrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6))

        hotdrinks.add(Product("Cappuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam", 7))

        hotdrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2))
    }

    private class AdaptadorProductos : BaseAdapter {
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
