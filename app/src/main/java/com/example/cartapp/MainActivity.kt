package com.example.cartapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cartapp.data.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(recyclerView) {
            val complexAdapter = ComplexAdapter()
            adapter = complexAdapter
            layoutManager = verticalLayoutManager(this@MainActivity)
            complexAdapter.updateData(
                getSimpleItemList() + SimpleImageContainer(
                    listOf(
                        SimpleImage(1, "#1", getSimpleImageList1()),
                        SimpleImage(2, "#2", getSimpleImageList2())
                    )
                )
            )
        }
    }
}
