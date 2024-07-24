package com.example.componentsandevents

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.componentsandevents.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnOpenSettingsActivity : Button
    lateinit var btnOpenSettingsActivity2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val btnOpenSettingsActivity = findViewById<Button>(R.id.btnOpenSettingsActivity)

        initView()

        initEvent()


    }

    private fun initView(){
        btnOpenSettingsActivity = findViewById(R.id.btnOpenSettingsActivity)
        btnOpenSettingsActivity2 = findViewById(R.id.btnOpenSettingsActivity2)
    }

    private fun initEvent(){
        btnOpenSettingsActivity.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnOpenSettingsActivity.setOnClickListener(this)
        btnOpenSettingsActivity2.setOnClickListener(this)

        //  en temiz kullanim. HOF ile!!
        btnOpenSettingsActivity.setOnClickListener(::openSettingsActivity)
        btnOpenSettingsActivity2.setOnClickListener(::openSettingsActivity3)

        // objenin expression kullanimi. Cünkü burada bir kullan at bir interface var.
        btnOpenSettingsActivity.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                startActivity(intent)
            }
        })


        val onClickListener = { view: View? ->
            val intent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnOpenSettingsActivity.setOnClickListener(onClickListener)

        // isimsiz Fonksiyon olusturabiliiriz!!
        val onClickListener2 = fun(view:View?){
            val intent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnOpenSettingsActivity.setOnClickListener(onClickListener2)
    }

    private fun openSettingsActivity(view:View?){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun openSettingsActivity3(view:View?){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {

        // birden fazla onClick'i this ile kullanacaksam, override ettigim onClick metodunda boyle kullanmam lazim!!!
        when(v?.id){
            R.id.btnOpenSettingsActivity -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }

            R.id.btnOpenSettingsActivity2 -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }

    }

    // public halini xml'in icerisine
    fun openSettingsActivity2(view:View?){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}