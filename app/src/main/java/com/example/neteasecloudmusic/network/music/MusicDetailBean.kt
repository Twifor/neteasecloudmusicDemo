package com.example.neteasecloudmusic.network.music

class MusicDetailBean {
    /**
     * songs : [{"name":"潮鳴り","id":22707008,"pst":0,"t":0,"ar":[{"id":15102,"name":"折戸伸治","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":29,"crbt":null,"cf":"","al":{"id":2083842,"name":"CLANNAD ORIGINAL SOUNDTRACK","picUrl":"https://p2.music.126.net/PtLd62-khEg8iCutTdE5Vg==/109951163286813093.jpg","tns":[],"pic_str":"109951163286813093","pic":109951163286813090},"dt":157000,"h":{"br":320000,"fid":0,"size":6283014,"vd":-2.65076E-4},"m":{"br":160000,"fid":0,"size":3141529,"vd":0.191089},"l":{"br":96000,"fid":0,"size":1884935,"vd":0},"a":null,"cd":"2","no":2,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"rtype":0,"rurl":null,"mst":9,"cp":663018,"mv":0,"publishTime":1092326400007}]
     * privileges : [{"id":22707008,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":320000,"toast":false,"flag":0,"preSell":false}]
     * code : 200
     */

    var code: Int = 0
    var songs: List<SongsBean>? = null
    var privileges: List<PrivilegesBean>? = null

    class SongsBean {
        /**
         * name : 潮鳴り
         * id : 22707008
         * pst : 0
         * t : 0
         * ar : [{"id":15102,"name":"折戸伸治","tns":[],"alias":[]}]
         * alia : []
         * pop : 100
         * st : 0
         * rt :
         * fee : 0
         * v : 29
         * crbt : null
         * cf :
         * al : {"id":2083842,"name":"CLANNAD ORIGINAL SOUNDTRACK","picUrl":"https://p2.music.126.net/PtLd62-khEg8iCutTdE5Vg==/109951163286813093.jpg","tns":[],"pic_str":"109951163286813093","pic":109951163286813090}
         * dt : 157000
         * h : {"br":320000,"fid":0,"size":6283014,"vd":-2.65076E-4}
         * m : {"br":160000,"fid":0,"size":3141529,"vd":0.191089}
         * l : {"br":96000,"fid":0,"size":1884935,"vd":0}
         * a : null
         * cd : 2
         * no : 2
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * djId : 0
         * copyright : 2
         * s_id : 0
         * rtype : 0
         * rurl : null
         * mst : 9
         * cp : 663018
         * mv : 0
         * publishTime : 1092326400007
         */

        var name: String? = null
        var id: Int = 0
        var pst: Int = 0
        var t: Int = 0
        var pop: Int = 0
        var st: Int = 0
        var rt: String? = null
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

        class AlBean {
            /**
             * id : 2083842
             * name : CLANNAD ORIGINAL SOUNDTRACK
             * picUrl : https://p2.music.126.net/PtLd62-khEg8iCutTdE5Vg==/109951163286813093.jpg
             * tns : []
             * pic_str : 109951163286813093
             * pic : 109951163286813090
             */

            var id: Int = 0
            var name: String? = null
            var picUrl: String? = null
            var pic_str: String? = null
            var pic: Long = 0
            var tns: List<*>? = null
        }

        class HBean {
            /**
             * br : 320000
             * fid : 0
             * size : 6283014
             * vd : -2.65076E-4
             */

            var br: Int = 0
            var fid: Int = 0
            var size: Int = 0
            var vd: Double = 0.toDouble()
        }

        class MBean {
            /**
             * br : 160000
             * fid : 0
             * size : 3141529
             * vd : 0.191089
             */

            var br: Int = 0
            var fid: Int = 0
            var size: Int = 0
            var vd: Double = 0.toDouble()
        }

        class LBean {
            /**
             * br : 96000
             * fid : 0
             * size : 1884935
             * vd : 0
             */

            var br: Int = 0
            var fid: Int = 0
            var size: Int = 0
            var vd: Double = 0.toDouble()
        }

        class ArBean {
            /**
             * id : 15102
             * name : 折戸伸治
             * tns : []
             * alias : []
             */

            var id: Int = 0
            var name: String? = null
            var tns: List<*>? = null
            var alias: List<*>? = null
        }
    }

    class PrivilegesBean {
        /**
         * id : 22707008
         * fee : 0
         * payed : 0
         * st : 0
         * pl : 320000
         * dl : 320000
         * sp : 7
         * cp : 1
         * subp : 1
         * cs : false
         * maxbr : 999000
         * fl : 320000
         * toast : false
         * flag : 0
         * preSell : false
         */

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
