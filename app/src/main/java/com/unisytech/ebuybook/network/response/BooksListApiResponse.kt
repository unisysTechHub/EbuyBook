package com.unisytech.ebuybook.network.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ramesh on 07/07/23.
 */
@Parcelize
data  class BooksListApiResponse(val books: ArrayList<Book> = arrayListOf(), val lastEvaluateKey : LastEvaluatedKey = LastEvaluatedKey() ) :
   BaseResponse(), Parcelable