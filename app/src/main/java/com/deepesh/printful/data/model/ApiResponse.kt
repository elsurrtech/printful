package com.deepesh.printful.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(

		@field:SerializedName("page")
		val page: Int? = null,

	@field:SerializedName("per_page")
	val per_page: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("total_pages")
	val results: Int? = null,

		@field:SerializedName("data")
val items: List<ItemsItem?>? = null,


)

data class ItemsItem(

	@field:SerializedName("id")
	val thumbnail: Int? = null,

	@field:SerializedName("email")
	val author: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("avatar")
	val urlToImage: String? = null,
)
