package com.unisytech.ebuybook.network.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ramesh on 16/3/22.
 */
@Parcelize
class LastEvaluatedKey( val bookId : String = "") : Parcelable
