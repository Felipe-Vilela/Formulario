package br.edu.ifsp.scl.ads.prdm.sc303898x.formulario

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc303898x.formulario.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        activityMainBinding.estadoCivilSp.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val estadpCivilView = (view as TextView).text.toString()
                    val estadoCivil = resources.getStringArray(R.array.estado_civil)[position]
//                if (estadoCivil.equals("Casado(a)"))
                    if (position == 1) {
                        activityMainBinding.conjugeLl.visibility = View.VISIBLE
                    } else {
                        activityMainBinding.conjugeLl.visibility = View.GONE
                        activityMainBinding.nomeConjugeEt.setText("")
                        activityMainBinding.sobrenomeConjugeEt.setText("")
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        activityMainBinding.salvarBt.setOnClickListener {

            val estadoCivil = activityMainBinding.estadoCivilSp.selectedItem.toString()

            val mensagemDoPopup = "Estado Civil: $estadoCivil\n"

            val builder = AlertDialog.Builder(this@MainActivity)

            builder.setTitle("Dados do Formulário")
            builder.setMessage(mensagemDoPopup)

            builder.setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }
    }
}