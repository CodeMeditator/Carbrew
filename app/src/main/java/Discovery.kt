//package com.android.blue.logic.model
//
//import android.view.Display.Mode
//
//data class Discovery() : Model() {
//    data class Item(
//        val `data`: Data, val type: String, val tag: Any?, val id: Int = 0, val adIndex: Int
//    )
//
//    data class Data()
//
//    data class HeaderX(
//        val actionUrl: Any,
//        val cover: Any,
//        val description: Any,
//        val font: Any,
//        val icon: Any,
//        val id: Int,
//        val label: Any,
//        val labelList: Any,
//        val rightText: Any,
//        val subTitle: Any,
//        val subTitleFont: Any,
//        val textAlign: String,
//        val title: Any
//    )
//
//    data class AutoPlayVideoAdDetail(
//        val actionUrl: String,
//        val adTrack: List<Any>,
//        val adaptiveImageUrls: String,
//        val adaptiveUrls: String,
//        val canSkip: Boolean,
//        val categoryId: Int,
//        val countdown: Boolean,
//        val cycleCount: Int,
//        val description: String,
//        val displayCount: Int,
//        val displayTimeDuration: Int,
//        val icon: String,
//        val id: Long,
//        val ifLinkage: Boolean,
//        val imageUrl: String,
//        val iosActionUrl: String,
//        val linkageAdId: Int,
//        val loadingMode: Int,
//        val openSound: Boolean,
//        val position: Int,
//        val showActionButton: Boolean,
//        val showImage: Boolean,
//        val showImageTime: Int,
//        val timeBeforeSkip: Int,
//        val title: String,
//        val url: String,
//        val videoAdType: String,
//        val videoType: String
//    )
//
//}
