package com.example.neteasecloudmusic.network.music

import com.google.gson.annotations.SerializedName

class MusicCommentDataBean {
    @SerializedName("isMusician")
    var `is_$IsMusician227`: Boolean = false
    var userId: Int = 0
    var isMoreHot: Boolean = false
    var code: Int = 0
    var total: Int = 0
    var isMore: Boolean = false
    var topComments: List<*>? = null
    var hotComments: List<HotCommentsBean>? = null
    var comments: List<CommentsBean>? = null

    class HotCommentsBean {
        /**
         * user : {"locationInfo":null,"vipRights":null,"userType":0,"nickname":"Meditated","vipType":0,"remarkName":null,"authStatus":0,"avatarUrl":"https://p4.music.126.net/qdFPqkFq9chOXmoyS9qDag==/18806046883229134.jpg","experts":null,"userId":269793261,"expertTags":null}
         * beReplied : []
         * pendantData : null
         * showFloorComment : null
         * status : 0
         * commentLocationType : 0
         * parentCommentId : 0
         * decoration : null
         * repliedMark : false
         * expressionUrl : null
         * commentId : 466241119
         * liked : false
         * time : 1499605318671
         * likedCount : 1157
         * content : 大街上，有个小男孩吵着要买棉花糖。妈妈指着他手里的小糖人，说：“刚买的孙悟空还没吃呢，怎么还要？”小男孩不听，赖在原地，非要买棉花糖不可。妈妈没办法，只好同意了。小男孩终于拿到了棉花糖，开心地对小糖人说：“大圣你看，你的筋斗云来了！”
         */

        var user: UserBean? = null
        var pendantData: Any? = null
        var showFloorComment: Any? = null
        var status: Int = 0
        var commentLocationType: Int = 0
        var parentCommentId: Int = 0
        var decoration: Any? = null
        var isRepliedMark: Boolean = false
        var expressionUrl: Any? = null
        var commentId: Int = 0
        var isLiked: Boolean = false
        var time: Long = 0
        var likedCount: Int = 0
        var content: String? = null
        var beReplied: List<*>? = null

        class UserBean {
            /**
             * locationInfo : null
             * vipRights : null
             * userType : 0
             * nickname : Meditated
             * vipType : 0
             * remarkName : null
             * authStatus : 0
             * avatarUrl : https://p4.music.126.net/qdFPqkFq9chOXmoyS9qDag==/18806046883229134.jpg
             * experts : null
             * userId : 269793261
             * expertTags : null
             */

            var locationInfo: Any? = null
            var vipRights: Any? = null
            var userType: Int = 0
            var nickname: String? = null
            var vipType: Int = 0
            var remarkName: Any? = null
            var authStatus: Int = 0
            var avatarUrl: String? = null
            var experts: Any? = null
            var userId: Int = 0
            var expertTags: Any? = null
        }
    }

    class CommentsBean {
        /**
         * user : {"locationInfo":null,"vipRights":null,"userType":0,"nickname":"丿氧气丶是你","vipType":0,"remarkName":null,"authStatus":0,"avatarUrl":"https://p3.music.126.net/QYQOGPYtjhH4zWxhpgTigA==/1404076355495807.jpg","experts":null,"userId":266118609,"expertTags":null}
         * beReplied : []
         * pendantData : null
         * showFloorComment : null
         * status : 0
         * commentLocationType : 0
         * parentCommentId : 0
         * decoration : {}
         * repliedMark : false
         * expressionUrl : null
         * commentId : 1475328908
         * liked : false
         * time : 1556809589092
         * likedCount : 0
         * content : 以前学校里大喇叭天天放这个版本。
         * isRemoveHotComment : false
         */

        var user: UserBean? = null
        var pendantData: Any? = null
        var showFloorComment: Any? = null
        var status: Int = 0
        var commentLocationType: Int = 0
        var parentCommentId: Int = 0
        var decoration: DecorationBean? = null
        var isRepliedMark: Boolean = false
        var expressionUrl: Any? = null
        var commentId: Int = 0
        var isLiked: Boolean = false
        var time: Long = 0
        var likedCount: Int = 0
        var content: String? = null
        var isIsRemoveHotComment: Boolean = false
        var beReplied: List<*>? = null

        class UserBean {
            /**
             * locationInfo : null
             * vipRights : null
             * userType : 0
             * nickname : Meditated
             * vipType : 0
             * remarkName : null
             * authStatus : 0
             * avatarUrl : https://p4.music.126.net/qdFPqkFq9chOXmoyS9qDag==/18806046883229134.jpg
             * experts : null
             * userId : 269793261
             * expertTags : null
             */

            var locationInfo: Any? = null
            var vipRights: Any? = null
            var userType: Int = 0
            var nickname: String? = null
            var vipType: Int = 0
            var remarkName: Any? = null
            var authStatus: Int = 0
            var avatarUrl: String? = null
            var experts: Any? = null
            var userId: Int = 0
            var expertTags: Any? = null
        }

        class DecorationBean
    }
}
