package com.project.draftapplicationdi.model

import com.google.gson.annotations.SerializedName

data class Technology(@SerializedName("id") val id: Int, @SerializedName("name") val name: String?)
