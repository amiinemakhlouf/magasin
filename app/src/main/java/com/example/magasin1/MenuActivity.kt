package com.example.magasin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("produit")
        //setProduit()
        produit.setOnClickListener {
            Intent(this, recyclerView::class.java).also {
                startActivity(it)


            }
        }
        ajouterproduit.setOnClickListener {

            Intent(this,AddProduit::class.java).also { startActivity(it) }
        }


    }


}