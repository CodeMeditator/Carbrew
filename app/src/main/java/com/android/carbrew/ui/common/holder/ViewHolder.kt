package com.android.carbrew.ui.common.holder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.carbrew.Const.ItemViewType.Companion.AUTO_PLAY_VIDEO_AD
import com.android.carbrew.Const.ItemViewType.Companion.BANNER
import com.android.carbrew.Const.ItemViewType.Companion.BANNER3
import com.android.carbrew.Const.ItemViewType.Companion.COLUMN_CARD_LIST
import com.android.carbrew.Const.ItemViewType.Companion.FOLLOW_CARD
import com.android.carbrew.Const.ItemViewType.Companion.HORIZONTAL_SCROLL_CARD
import com.android.carbrew.Const.ItemViewType.Companion.INFORMATION_CARD
import com.android.carbrew.Const.ItemViewType.Companion.SPECIAL_SQUARE_CARD_COLLECTION
import com.android.carbrew.Const.ItemViewType.Companion.TAG_BRIEFCARD
import com.android.carbrew.Const.ItemViewType.Companion.TEXT_CARD_FOOTER2
import com.android.carbrew.Const.ItemViewType.Companion.TEXT_CARD_FOOTER3
import com.android.carbrew.Const.ItemViewType.Companion.TEXT_CARD_HEADER4
import com.android.carbrew.Const.ItemViewType.Companion.TEXT_CARD_HEADER5
import com.android.carbrew.Const.ItemViewType.Companion.TEXT_CARD_HEADER7
import com.android.carbrew.Const.ItemViewType.Companion.TEXT_CARD_HEADER8
import com.android.carbrew.Const.ItemViewType.Companion.TOPIC_BRIEFCARD
import com.android.carbrew.Const.ItemViewType.Companion.UGC_SELECTED_CARD_COLLECTION
import com.android.carbrew.Const.ItemViewType.Companion.UNKNOWN
import com.android.carbrew.Const.ItemViewType.Companion.VIDEO_SMALL_CARD
import com.android.carbrew.R
import com.android.carbrew.extension.inflate
import com.android.carbrew.logic.model.Daily

class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view)

class TextCardViewHeader5ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle5 = view.findViewById<TextView>(R.id.tvTitle5)
    val tvFollow = view.findViewById<TextView>(R.id.tvFollow)
    val ivInto5 = view.findViewById<ImageView>(R.id.ivInto5)
}

class FollowCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivVideo = view.findViewById<ImageView>(R.id.ivVideo)
    val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
    val tvVideoDuration = view.findViewById<TextView>(R.id.tvVideoDuration)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val ivShare = view.findViewById<ImageView>(R.id.ivShare)
    val tvLabel = view.findViewById<TextView>(R.id.tvLabel)
    val ivChoiceness = view.findViewById<ImageView>(R.id.ivChoiceness)
}

class VideoSmallCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.ivPicture)
    val tvVideoDuration = view.findViewById<TextView>(R.id.tvVideoDuration)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    val ivShare = view.findViewById<ImageView>(R.id.ivShare)
}


object RecyclerViewHelp {
    fun getViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TEXT_CARD_HEADER5 -> TextCardViewHeader5ViewHolder(
            R.layout.item_text_card_type_header_five.inflate(parent)
        )

        FOLLOW_CARD -> FollowCardViewHolder(
            R.layout.item_follow_card_type.inflate(parent)
        )

        VIDEO_SMALL_CARD -> VideoSmallCardViewHolder(
            R.layout.item_video_small_card_type.inflate(
                parent
            )
        )

    }

    fun getItemViewType(type: String, dataType: String) = when (type) {

        "horizontalScrollCard" -> {
            when (dataType) {
                "HorizontalScrollCard" -> HORIZONTAL_SCROLL_CARD
                else -> UNKNOWN
            }
        }

        "specialSquareCardCollection" -> {
            when (dataType) {
                "ItemCollection" -> SPECIAL_SQUARE_CARD_COLLECTION
                else -> UNKNOWN
            }
        }

        "columnCardList" -> {
            when (dataType) {
                "ItemCollection" -> COLUMN_CARD_LIST
                else -> UNKNOWN
            }
        }

        "banner" -> {
            when (dataType) {
                "Banner" -> BANNER
                else -> UNKNOWN
            }
        }

        "banner3" -> {
            when (dataType) {
                "Banner" -> BANNER3
                else -> UNKNOWN
            }
        }

        "videoSmallCard" -> {
            when (dataType) {
                "VideoBeanForClient" -> VIDEO_SMALL_CARD
                else -> UNKNOWN
            }
        }

        "briefCard" -> {
            when (dataType) {
                "TagBriefCard" -> TAG_BRIEFCARD
                "TopicBriefCard" -> TOPIC_BRIEFCARD
                else -> UNKNOWN
            }
        }

        "followCard" -> {
            when (dataType) {
                "FollowCard" -> FOLLOW_CARD
                else -> UNKNOWN
            }
        }

        "informationCard" -> {
            when (dataType) {
                "InformationCard" -> INFORMATION_CARD
                else -> UNKNOWN
            }
        }

        "ugcSelectedCardCollection" -> {
            when (dataType) {
                "ItemCollection" -> UGC_SELECTED_CARD_COLLECTION
                else -> UNKNOWN
            }
        }

        "autoPlayVideoAd" -> {
            when (dataType) {
                "AutoPlayVideoAdDetail" -> AUTO_PLAY_VIDEO_AD
                else -> UNKNOWN
            }
        }

        else -> UNKNOWN
    }

    private fun getTextCardType(type: String) = when (type) {
        "header4" -> TEXT_CARD_HEADER4
        "header5" -> TEXT_CARD_HEADER5
        "header7" -> TEXT_CARD_HEADER7
        "header8" -> TEXT_CARD_HEADER8
        "footer2" -> TEXT_CARD_FOOTER2
        "footer3" -> TEXT_CARD_FOOTER3
        else -> UNKNOWN
    }

    fun getItemViewType(item: Daily.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(
            item.type, item.data.dataType
        )
    }
}