package mx.itson.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_coldproductos.*
import kotlinx.android.synthetic.main.producto_view.view.*

class ProductosCombos : AppCompatActivity() {
    var combos = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coldproductos)

        cargarProductos()

        var adaptador = AdaptadorProductos(this, combos)
        listview.adapter = adaptador
    }

    fun cargarProductos(){
        combos.add(Product("BlueBerry Pancakes with milkshake", R.drawable.pancakes, " 3 blueberry pancakes with a milshake you can select it.", 10))

        combos.add(Product("3 Creppes with strawberry", R.drawable.crepes, "3 crepes covered with strawberries and chocolate.", 7))

        combos.add(Product("Waffles", R.drawable.waffles, "waffles with butter or Ice Cream.", 6))

        combos.add(Product("Sundae with OreoMilshake", R.drawable.sundae, "huge bowl of Ice cream sundae style with a oreo milkshake.", 15))

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
