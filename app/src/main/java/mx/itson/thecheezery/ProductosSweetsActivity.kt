package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_productos_sweets.*
import kotlinx.android.synthetic.main.producto_view.view.*

class ProductosSweetsActivity : AppCompatActivity() {

    var sweets = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coldproductos)

        cargarProductos()

        var adaptador = AdaptadorProductos(this, colddrinks)
        listview.adapter = adaptador
    }

    fun cargarProductos(){
        sweets.add(Product("Blueberry Cake", R.drawable.blueberrycake, "Vanilla cake flavored with blueberries on top", 6))

        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes with butter on top", 3))

        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shelled with a lemon flavored filling", 4))

        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "A very moist and delicious cake with butter frosting", 6))

        sweets.add(Product("Cherry Cheesecake", R.drawable.strawberrycheesecake, "A vanilla cake with cherries on top", 7))

        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee flavored italian dessert", 6))
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
