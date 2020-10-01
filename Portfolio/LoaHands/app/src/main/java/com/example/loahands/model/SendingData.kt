package com.example.loahands.model

import android.os.Parcel
import android.os.Parcelable

class SendingData (
  var userEquip : UserEquip,
  var userInfo : UserInfo
) : Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("userEquip"),
        TODO("userInfo")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SendingData> {
        override fun createFromParcel(parcel: Parcel): SendingData {
            return SendingData(parcel)
        }

        override fun newArray(size: Int): Array<SendingData?> {
            return arrayOfNulls(size)
        }
    }
}