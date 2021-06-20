package com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class FilmModel(
    var id: String,
    var name: String,
    var desc: String,
    var img_preview: String,
    var poster: String,
    var share_link: String
) : Parcelable