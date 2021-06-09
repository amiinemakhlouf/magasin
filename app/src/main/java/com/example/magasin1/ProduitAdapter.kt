package com.example.magasin1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_produit.view.*

class ProduitAdapter (
    private val  dataSEt:ArrayList<Produit>
        ):RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder> ()  {
    class ProduitViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitViewHolder {
       return ProduitViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_produit,parent,false))

    }
    override fun onBindViewHolder(holder: ProduitViewHolder, position: Int) {
       val  p=dataSEt[position]
        holder.itemView.apply { nom.text=p.nom
         prix.text=p.prix.toString()
         quantite.text=p.quantite.toString()
        }

    }

    override fun getItemCount(): Int {
        return dataSEt.size
    }
}