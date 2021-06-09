package com.example.magasin1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_fournisseur.view.*
import kotlinx.android.synthetic.main.items_produit.view.*
class FournisseurAdapter ( private val  dataSEt:MutableList<Fournisseur>
    ):RecyclerView.Adapter<FournisseurAdapter.FournisseurViewHolder> ()  {
        class FournisseurViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FournisseurViewHolder {
            return FournisseurViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_fournisseur,parent,false))

        }
        override fun onBindViewHolder(holder: FournisseurViewHolder, position: Int) {
            val  f=dataSEt[position]
            holder.itemView.apply { type.text=f.type
                nom.text=f.nom.toString()
                quantite.text=f.numero.toString()
            }

        }

        override fun getItemCount(): Int {
            return dataSEt.size
        }
}