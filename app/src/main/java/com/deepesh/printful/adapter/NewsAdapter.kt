package com.deepesh.printful.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deepesh.printful.R
import com.deepesh.printful.data.model.ItemsItem
import com.deepesh.printful.view.DetailsActivity
import kotlinx.android.synthetic.main.item_regular.view.*
import kotlinx.coroutines.*
import java.io.IOException
import java.net.URL


class NewsAdapter(private val context: Context, private val itemList: ArrayList<ItemsItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            val view = LayoutInflater.from(context).inflate(R.layout.item_regular, parent, false)
            return ViewHolderRegular(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            with(holder.itemView){
                firstName_itemRegular.text= itemList[position].firstName
                secondName_itemRegular.text = itemList[position].lastName

                val url = URL(itemList[position].urlToImage)
                val result : Deferred<Bitmap> = GlobalScope.async {
                    toBitmap(url)
                }
                GlobalScope.launch(Dispatchers.Main){
                    imageRegular.setImageBitmap(result.await())
                }
            }


        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putString("name", itemList[position].firstName)
            bundle.putString("surname",itemList[position].lastName )
            bundle.putString("image",itemList[position].urlToImage)
            bundle.putString("email",itemList[position].author)
            i.putExtras(bundle)
            context.startActivity(i)
        }


    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount() = itemList.size

  class ViewHolderRegular(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    private fun toBitmap(url: URL): Bitmap{
        return try {
            Log.e("TAG", "BITMAP")
            BitmapFactory.decodeStream(url.openConnection().getInputStream())
        } catch (e: IOException) {
            println(e)
            BitmapFactory.decodeResource(
                context.resources,
                R.drawable.image1
            )
        }

    }
}
