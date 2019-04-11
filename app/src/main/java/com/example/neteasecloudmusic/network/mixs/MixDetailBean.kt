package com.example.neteasecloudmusic.network.mixs


class MixDetailBean{
    var playlist: PlaylistBean? = null
    var code: Int = 0
    var privileges: List<PrivilegesBean>? = null

    class PlaylistBean {


        var isSubscribed: Boolean = false
        var creator: CreatorBean? = null
        var cloudTrackCount: Int = 0
        var subscribedCount: Int = 0
        var createTime: Long = 0
        var isHighQuality: Boolean = false
        var userId: Int = 0
        var coverImgId: Long = 0
        var updateTime: Long = 0
        var specialType: Int = 0
        var trackCount: Int = 0
        var commentThreadId: String? = null
        var privacy: Int = 0
        var isNewImported: Boolean = false
        var trackUpdateTime: Long = 0
        var playCount: Int = 0
        var coverImgUrl: String? = null
        var adType: Int = 0
        var trackNumberUpdateTime: Long = 0
        var isOrdered: Boolean = false
        var description: String? = null
        var status: Int = 0
        var name: String? = null
        var id: Int = 0
        var shareCount: Int = 0
        var commentCount: Int = 0
        var subscribers: List<SubscribersBean>? = null
        var tracks: List<TracksBean>? = null
        var trackIds: List<TrackIdsBean>? = null
        var tags: List<String>? = null

        class CreatorBean {

            var isDefaultAvatar: Boolean = false
            var province: Int = 0
            var authStatus: Int = 0
            var isFollowed: Boolean = false
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
            var isMutual: Boolean = false
            var expertTags: Any? = null
            var experts: Any? = null
            var djStatus: Int = 0
            var vipType: Int = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
        }

        class SubscribersBean {

            var isDefaultAvatar: Boolean = false
            var province: Int = 0
            var authStatus: Int = 0
            var isFollowed: Boolean = false
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
            var isMutual: Boolean = false
            var expertTags: Any? = null
            var experts: Any? = null
            var djStatus: Int = 0
            var vipType: Int = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
            var avatarImgId_str: String? = null
        }

        class TracksBean {


            var name: String? = null
            var id: Int = 0
            var pst: Int = 0
            var t: Int = 0
            var pop: Int = 0
            var st: Int = 0
            var rt: Any? = null
            var fee: Int = 0
            var v: Int = 0
            var crbt: Any? = null
            var cf: String? = null
            var al: AlBean? = null
            var dt: Int = 0
            var h: HBean? = null
            var m: MBean? = null
            var l: LBean? = null
            var a: Any? = null
            var cd: String? = null
            var no: Int = 0
            var rtUrl: Any? = null
            var ftype: Int = 0
            var djId: Int = 0
            var copyright: Int = 0
            var s_id: Int = 0
            var rtype: Int = 0
            var rurl: Any? = null
            var mst: Int = 0
            var cp: Int = 0
            var mv: Int = 0
            var publishTime: Long = 0
            var ar: List<ArBean>? = null
            var alia: List<*>? = null
            var rtUrls: List<*>? = null
            var tns: List<String>? = null

            class AlBean {

                var id: Int = 0
                var name: String? = null
                var picUrl: String? = null
                var pic: Long = 0
                var tns: List<*>? = null
            }

            class HBean {


                var br: Int = 0
                var fid: Int = 0
                var size: Int = 0
                var vd: Double = 0.0
            }

            class MBean {


                var br: Int = 0
                var fid: Int = 0
                var size: Int = 0
                var vd: Double = 0.0
            }

            class LBean {

                var br: Int = 0
                var fid: Int = 0
                var size: Int = 0
                var vd: Double = 0.0
            }

            class ArBean {


                var id: Int = 0
                var name: String? = null
                var tns: List<*>? = null
                var alias: List<*>? = null
            }
        }

        class TrackIdsBean {


            var id: Int = 0
            var v: Int = 0
        }
    }

    class PrivilegesBean {


        var id: Int = 0
        var fee: Int = 0
        var payed: Int = 0
        var st: Int = 0
        var pl: Int = 0
        var dl: Int = 0
        var sp: Int = 0
        var cp: Int = 0
        var subp: Int = 0
        var isCs: Boolean = false
        var maxbr: Int = 0
        var fl: Int = 0
        var isToast: Boolean = false
        var flag: Int = 0
        var isPreSell: Boolean = false
    }
}
