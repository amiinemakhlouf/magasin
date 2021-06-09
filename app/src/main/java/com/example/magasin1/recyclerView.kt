package com.example.magasin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class recyclerView : AppCompatActivity() {
    private lateinit var produitAdapter: ProduitAdapter
    private lateinit var  database: FirebaseDatabase
    private  lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar
        database= FirebaseDatabase.getInstance();
        reference =database.getReference("produit")

        getProduit()



    }
    fun getProduit(){

        reference.addValueEventListener(object : ValueEventListener
        {   var  list =ArrayList<Produit>()
            override fun onDataChange(snapshot: DataSnapshot) {
                for(data in snapshot.children){
                    var produit=data.getValue(Produit::class.java)
                    list.add(produit as Produit)
                }
              if(list.size>0) {
                    produitAdapter = ProduitAdapter(list)
                   rc.adapter = produitAdapter
                    rc.layoutManager = LinearLayoutManager(this@recyclerView)



                   }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("cancel",error.message)
            }

        })



    }



}