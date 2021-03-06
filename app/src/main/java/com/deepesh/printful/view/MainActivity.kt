package com.deepesh.printful.view

import android.app.Service
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deepesh.printful.R
import com.deepesh.printful.adapter.NewsAdapter
import com.deepesh.printful.data.model.ApiResponse
import com.deepesh.printful.data.model.ItemsItem
import com.deepesh.printful.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private  var itemList = ArrayList<ItemsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsAdapter=NewsAdapter(this,itemList)
        recyclerViewNews.adapter=newsAdapter
        recyclerViewNews.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        mainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.callApi()
        mainActivityViewModel.getNews().observe(this, {
            response ->
            val apiresponse : ApiResponse? = response.body()
            val items : ArrayList<ItemsItem> = apiresponse?.items as ArrayList<ItemsItem>

            for (i in items.size-1 downTo 0 step 1) {
                if(!itemList.contains(items[i]))
                    itemList.add(0,items[i])
            }

            newsAdapter.notifyDataSetChanged()
        })

        swipeRefreshLayout.setOnRefreshListener {
            mainActivityViewModel.callApi()
            swipeRefreshLayout.isRefreshing=false
        }
    }




}