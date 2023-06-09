package com.jurabek888.yolharakatiqoidalari.Madels

class User {

    var id:Int?=null
    var name:String? = null
    var description:String?=null
    var imagePath:String?=null
    var sppiner:Int?=null
    var likee:Int?=0

    constructor(id: Int?, name: String?, description: String?, imagePath: String?, sppiner:Int?,likee:Int? ) {
        this.id = id
        this.imagePath = imagePath
        this.name = name
        this.description = description
        this.sppiner=sppiner
        this.likee=likee
    }

    constructor( name: String?, description: String?,imagePath: String?,sppiner:Int?,likee:Int?) {
        this.imagePath = imagePath
        this.name = name
        this.description = description
        this.sppiner=sppiner
        this.likee=likee

    }
    constructor( name: String?,imagePath: String?,likee:Int? ) {
        this.imagePath = imagePath
        this.name = name
        this.likee=likee
    }

    constructor()
    constructor(likee: Int?) {
        this.likee = likee
    }


}