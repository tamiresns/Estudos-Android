package com.example.cadastrocomfoto

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.cadastrocomfoto.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var foto: ImageView
    private lateinit var botaoTirarFoto : Button
    private lateinit var nome : EditText
    private lateinit var idade : EditText
    private lateinit var botaoSalvar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foto = findViewById(R.id.imgFoto)
        botaoTirarFoto = findViewById(R.id.btnFoto)
        nome = findViewById(R.id.edtNome)
        idade = findViewById(R.id.edtIdade)
        botaoSalvar = findViewById(R.id.btnSalvar)

        botaoSalvar.setOnClickListener {
            //INTENT EXPLICITA
            val intent = Intent(this@MainActivity, SecondActivity::class.java)

            val usuario = Usuario(nome = nome.text.toString(), idade = idade.text.toString().toInt())
            intent.putExtra("USUARIO", usuario)

            startActivity(intent)
        }

        botaoTirarFoto.setOnClickListener {
            abrirCamera()
        }
    }

    fun abrirCamera(){
        //INTENT IMPLÍCITA
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(intent.resolveActivity(packageManager) != null){
            startActivityForResult(intent, 12345)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 12345 && resultCode == RESULT_OK){
            val fotoTirada = data?.extras?.get("data") as Bitmap
            foto.setImageBitmap(fotoTirada)
        }
    }

    override fun onBackPressed() {
        var dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle("Confirmação")
        dialog.setPositiveButton("Sim", DialogInterface.OnClickListener{dialogInterface, i ->  super.onBackPressed()})
        dialog.create().show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("CICLOVIDA", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CICLOVIDA", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CICLOVIDA", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CICLOVIDA", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLOVIDA", "OnDestroy")
    }
}



