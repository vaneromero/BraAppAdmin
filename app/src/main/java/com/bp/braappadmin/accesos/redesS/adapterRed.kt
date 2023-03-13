package com.bp.braappadmin.accesos.redesS

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class adapterRed(
    val Facebook: String? = null,
    val Instagram: String? = null,
    val Telegram: String? = null,
    val Twitter: String? = null,
    val Whatsapp: String? = null,
    val Pagina: String? = null,
    val Youtube: String? = null,
    val link: String? = null,
    val VerMas: String? = null,
    val DescarHis: String? = null,
    val VerMasM: String? = null,
    val DescarHis3: String? = null,
    val qrf:String?=null,
    val nombre:String?=null,
    val imagen:String?=null,
    val Tiktok:String?=null,
    val Spotify:String?=null,
    val Figma:String?=null,
) {
}
data class video(
    val  video4: String? = null,
) {
}