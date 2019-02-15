package com.example.cartapp.data

data class SimpleItem(val name: String) : ItemType {
    override val type: Int
        get() = TYPE

    companion object {
        const val TYPE = 0
    }
}

fun getSimpleItemList() = listOf(
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA"),
    SimpleItem("AA")
)