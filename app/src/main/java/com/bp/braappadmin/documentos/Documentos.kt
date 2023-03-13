package com.bp.braappadmin.documentos

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Documentos(
    val fecha: String? = null,
    val nombre: String? = null,
    val url1: String? = null,
    val url2: String? = null,
    val url3: String? = null,
    @Exclude val key: String? = null)