package com.example.neteasecloudmusic.network.login

class UserDetailBean {

    var level: Int = 0
    var listenSongs: Int = 0
    var userPoint: UserPointBean? = null
    var isMobileSign: Boolean = false
    var isPcSign: Boolean = false
    var profile: ProfileBean? = null
    var isPeopleCanSeeMyPlayRecord: Boolean = false
    var isAdValid: Boolean = false
    var code: Int = 0
    var createTime: Long = 0
    var createDays: Int = 0
    var bindings: List<BindingsBean>? = null

    class UserPointBean {

        var userId: Int = 0
        var balance: Int = 0
        var updateTime: Long = 0
        var version: Int = 0
        var status: Int = 0
        var blockBalance: Int = 0
    }

    class ProfileBean {

        var accountStatus: Int = 0
        var isFollowed: Boolean = false
        var detailDescription: String? = null
        var userId: Int = 0
        var vipType: Int = 0
        var gender: Int = 0
        var avatarImgIdStr: String? = null
        var backgroundImgIdStr: String? = null
        var city: Int = 0
        var backgroundUrl: String? = null
        var birthday: Long = 0
        var nickname: String? = null
        var avatarImgId: Long = 0
        var province: Int = 0
        var isDefaultAvatar: Boolean = false
        var avatarUrl: String? = null
        var djStatus: Int = 0
        var experts: ExpertsBean? = null
        var isMutual: Boolean = false
        var remarkName: Any? = null
        var expertTags: Any? = null
        var authStatus: Int = 0
        var backgroundImgId: Long = 0
        var userType: Int = 0
        var description: String? = null
        var signature: String? = null
        var authority: Int = 0
        var avatarImgId_str: String? = null
        var followeds: Int = 0
        var follows: Int = 0
        var cCount: Int = 0
        var isBlacklist: Boolean = false
        var eventCount: Int = 0
        var sdjpCount: Int = 0
        var allSubscribedCount: Int = 0
        var playlistCount: Int = 0
        var playlistBeSubscribedCount: Int = 0
        var sCount: Int = 0
        var artistIdentity: List<*>? = null

        class ExpertsBean
    }

    class BindingsBean {

        var refreshTime: Int = 0
        var userId: Int = 0
        var expiresIn: Int = 0
        var tokenJsonStr: Any? = null
        var url: String? = null
        var isExpired: Boolean = false
        var id: Long = 0
        var type: Int = 0
    }
}
