package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.activity_productos_hot.*
import kotlinx.android.synthetic.main.producto_view.view.*

class ProductHotDrinks : AppCompatActivity() {
    var hotDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coldproductos)

        cargarProductos()

        var adaptador = AdaptadorProductos(this, hotDrinks)
        listview.adapter = adaptador
    }

    fun cargarProductos(){
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffe drink made with espresso an steamed milk.", 6))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of cofee.", 4))
        hotDrinks.add(Product("Chai late", R.drawable.chailatte, "Spiced tea concentrate with milk.", 6))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espreso-based coffee drink. prepared with steam foam.", 7))
        hotDrinks.add(Product("American cofee", R.drawable.americano, "Espresso with hot water.", 2))
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
