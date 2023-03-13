package com.bp.braappadmin.galeria

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class slides(
    val nombre: String? = null,  val imagen: String?=null,@Exclude val key: String? = null)
@IgnoreExtraProperties
data class slides3(
    val nombre: String? = null,  val foto: String?=null,val titulo:String?=null,val descr:String?=null,@Exclude val key: String? = null)