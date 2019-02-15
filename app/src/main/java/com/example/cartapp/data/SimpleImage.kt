package com.example.cartapp.data

data class SimpleImage(val id: Int, val name: String, val urlList: List<String>) : ItemType {
    override val type: Int
        get() = TYPE

    companion object {
        const val TYPE = 1
    }
}

data class SimpleImageContainer(val simpleImageList: List<SimpleImage>) : ItemType {
    override val type: Int
        get() = 3

}

fun getSimpleImageList1() = listOf(
    "https://cdn.pixabay.com/photo/2016/06/18/17/42/image-1465348_960_720.jpg",
    "https://cdn.theatlantic.com/assets/media/img/photo/2015/11/images-from-the-2016-sony-world-pho/s01_130921474920553591/main_900.jpg?1448476701",
    "https://media.mnn.com/assets/images/2016/11/closeup-baby-robin-beak-open.jpg.653x0_q80_crop-smart.jpg",
    "https://www.gettyimages.com/gi-resources/images/CreativeLandingPage/HP_Sept_24_2018/CR3_GettyImages-159018836.jpg",
    "https://atgbcentral.com/data/out/156/5345367-images-of-nature-and-flowers.jpg",
    "http://tadalafilforsale.net/data/media/35/55607397.jpg",
    "https://html5box.com/html5lightbox/images/lakeandballoon.jpg"
)

fun getSimpleImageList2() = listOf(
    "https://avatars.mds.yandex.net/get-pdb/963327/6dbd05cf-b261-43ba-8c92-464b987985cf/s1200?webp=false",
    "http://s1.1zoom.me/b5050/573/351843-admin_2880x1800.jpg",
    "https://404store.com/2018/04/06/beautiful-swiss-lake-summer-nature-wallpapers-1920x1200.jpg",
    "http://www.1zoom.me/big2/807/304544-Sepik.jpg",
    "https://404store.com/2017/03/22/f25b8f902ed8884e0e78062fcb9b79c5.jpg",
    "https://i.imgflip.com/23xuy5.jpg"
)