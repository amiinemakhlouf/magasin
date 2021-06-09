package com.example.magasin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_addproduit.*
import kotlinx.android.synthetic.main.activity_menu.*

class AddProduit : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addproduit)
        supportActionBar
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("produit")
        ajouter.setOnClickListener {
            if (prixP.text.isNotEmpty() && nomP.text.isNotEmpty() && quantiteP.text.isNotEmpty()) {
                setProduit()
                Toast.makeText(this, "le produit a été ajouté", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "les champs doivent etre remplis", Toast.LENGTH_LONG).show()
            }
        }


    }

    fun setProduit() {
        var id = reference.push().key
        reference.child(id!!).setValue(
            Produit(
                nomP.text.toString(),
                prixP.text.toString().toDouble(),
                quantiteP.text.toString().toInt()!!
            )
        )

    }


}