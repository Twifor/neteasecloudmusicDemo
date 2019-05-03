package com.example.neteasecloudmusic.network.music

class MusicUrlBean {

    /**
     * data : [{"id":33894312,"url":"http://m10.music.126.net/20190418003830/70f49180d930b6f57c9eb3149209470e/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3","br":320000,"size":10691439,"md5":"a8772889f38dfcb91c04da915b301617","code":200,"expi":1200,"type":"mp3","gain":-2.0E-4,"fee":0,"uf":null,"payed":0,"flag":0,"canExtend":false,"freeTrialInfo":null,"level":"exhigh","encodeType":"mp3"}]
     * code : 200
     */

    var code: Int = 0
    var data: List<DataBean>? = null

    class DataBean {
        /**
         * id : 33894312
         * url : http://m10.music.126.net/20190418003830/70f49180d930b6f57c9eb3149209470e/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3
         * br : 320000
         * size : 10691439
         * md5 : a8772889f38dfcb91c04da915b301617
         * code : 200
         * expi : 1200
         * type : mp3
         * gain : -2.0E-4
         * fee : 0
         * uf : null
         * payed : 0
         * flag : 0
         * canExtend : false
         * freeTrialInfo : null
         * level : exhigh
         * encodeType : mp3
         */

        var id: Int = 0
        var url: String? = null
        var br: Int = 0
        var size: Int = 0
        var md5: String? = null
        var code: Int = 0
        var expi: Int = 0
        var type: String? = null
        var gain: Double = 0.toDouble()
        var fee: Int = 0
        var uf: Any? = null
        var payed: Int = 0
        var flag: Int = 0
        var isCanExtend: Boolean = false
        var freeTrialInfo: Any? = null
        var level: String? = null
        var encodeType: String? = null
    }
}
