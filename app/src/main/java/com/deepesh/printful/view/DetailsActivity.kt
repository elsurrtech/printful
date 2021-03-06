package com.deepesh.printful.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.deepesh.printful.R
import com.deepesh.printful.data.model.ApiResponse
import com.deepesh.printful.data.model.ItemsItem
import com.deepesh.printful.viewmodel.MainActivityViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private  var itemList = ArrayList<ItemsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bundle = intent.extras
        val firstName = bundle!!.getCharSequence("name")
        val surName = bundle!!.getCharSequence("surname")
        val image = bundle!!.getCharSequence("image")
        val email = bundle!!.getCharSequence("email")
        Picasso.get().load(image.toString()).into(image_details_activity)
        email_activity_details.text = email.toString()
        name_activity_details.text = firstName.toString()
        surname_activity_details.text = surName.toString()

        btnBack_details.setOnClickListener {
            onBackPressed()
        }


    }
}