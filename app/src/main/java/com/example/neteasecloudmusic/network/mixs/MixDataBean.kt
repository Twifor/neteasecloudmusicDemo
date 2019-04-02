package com.example.neteasecloudmusic.network.mixs

import com.google.gson.annotations.SerializedName

class MixDataBean {

    var more: Boolean = false
    var code: Int = 0
    var playlist: List<PlaylistBean>? = null

    class PlaylistBean {

        @SerializedName("subscribed")
        var subscribed: Boolean = true
        var creator: CreatorBean? = null
        var artists: Any? = null
        var tracks: Any? = null
        var subscribedCount: Int = 0
        var cloudTrackCount: Int = 0
        var createTime: Long = 0
        var highQuality: Boolean = false
        var userId: Int = 0
        var coverImgId: Long = 0
        var updateTime: Long = 0
        var anonimous: Boolean = false
        var commentThreadId: String? = null
        var totalDuration: Int = 0
        var newImported: Boolean = false
        var privacy: Int = 0
        var trackUpdateTime: Long = 0
        var specialType: Int = 0
        var trackCount: Int = 0
        var coverImgUrl: String? = null
        var playCount: Int = 0
        var adType: Int = 0
        var trackNumberUpdateTime: Long = 0
        var ordered: Boolean = false
        var description: Any? = null
        var status: Int = 0
        var name: String? = null
        var id: Int = 0
        var subscribers: List<*>? = null
        var tags: List<*>? = null

        class CreatorBean {


            var defaultAvatar: Boolean = false
            var province: Int = 0
            var authStatus: Int = 0
            var followed: Boolean = false
            var avatarUrl: String? = null
            var accountStatus: Int = 0
            var gender: Int = 0
            var city: Int = 0
            var birthday: Long = 0
            var userId: Int = 0
            var userType: Int = 0
            var nickname: String? = null
            var signature: String? = null
            var description: String? = null
            var detailDescription: String? = null
            var avatarImgId: Long = 0
            var backgroundImgId: Long = 0
            var backgroundUrl: String? = null
            var authority: Int = 0
            var mutual: Boolean = false
            var expertTags: Any? = null
            var experts: Any? = null
            var djStatus: Int = 0
            var vipType: Int = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
            var avatarImgId_str: String? = null
        }
    }
}
