package com.unisytech.ebuybook.network.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ramesh on 18/3/22.
 */
@Parcelize
data class Book
(
    var   bookId   :String? = "B0001",
    var title : String? = "SWift programming",
    var author : String? = "Jhont",
    var yearOfPublish : Int? = 2000,
    var genre : String? = "Technolgoy",
    var price : Double? = 1000.00,
    var country : String? = "U.S"
    ) : Parcelable{}



