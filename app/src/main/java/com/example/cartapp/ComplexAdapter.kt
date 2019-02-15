package com.example.cartapp

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cartapp.data.ItemType
import com.example.cartapp.data.SimpleImage
import com.example.cartapp.data.SimpleImageContainer
import com.example.cartapp.data.SimpleItem
import kotlinx.android.synthetic.main.pager_layout.view.*
import kotlinx.android.synthetic.main.pager_selector_layout.view.*
import kotlinx.android.synthetic.main.simple_image_layout.view.*
import kotlinx.android.synthetic.main.simple_text_layout.view.*

class ComplexAdapter : Adapter<ViewHolder>() {

    private val mData: MutableList<ItemType> = mutableListOf()
    private val mViewPool = RecyclerView.RecycledViewPool()
    private val mPagerImageAdapter = PagerViewHolder.PagerImageAdapter()
    private val mPagerSelectorAdapter: PagerViewHolder.PagerSelectorAdapter = PagerViewHolder.PagerSelectorAdapter {
        mPagerImageAdapter.updateData(it.urlList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            SimpleItem.TYPE -> {
                val view = parent.inflate(R.layout.simple_text_layout)
                SimpleTextViewHolder(view)
            }
            SimpleImage.TYPE -> {
                val view = parent.inflate(R.layout.pager_layout)
                PagerViewHolder(view).apply {
                    pagerRecyclerView.apply {
                        adapter = mPagerImageAdapter
                        layoutManager = horizontalLayoutManager(itemView.context)
                        setRecycledViewPool(mViewPool)
                        val snapHelper = PagerSnapHelper()
                        snapHelper.attachToRecyclerView(this)
                        addOnScrollListener(object : RecyclerView.OnScrollListener() {
                            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                                super.onScrolled(recyclerView, dx, dy)

                                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                                Log.d("", "firstVisibleItemPosition = $firstVisibleItemPosition")
                            }
                        })
                    }

                    selectorRecyclerView.apply {
                        adapter = mPagerSelectorAdapter
                        layoutManager = horizontalLayoutManager(itemView.context)
                        setRecycledViewPool(mViewPool)
                    }
                }
            }
            else -> {
                throw Exception("ViewType not found with id = $viewType")
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (mData[position].type) {
            SimpleItem.TYPE -> {
                with(holder as SimpleTextViewHolder) {
                    val simpleItem = mData[position] as SimpleItem
                    this.simpleTv.text = simpleItem.name
                }
            }
            SimpleImage.TYPE -> {
                val simpleImage = mData[position] as SimpleImage

                mPagerSelectorAdapter.updateData(simpleImage.urlList)
//                mPagerImageAdapter.updateData(simpleImage.urlList)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return mData[position].type
    }

    fun updateData(newData: List<ItemType>) {
        mData.clear()
        mData.addAll(newData)
        notifyDataSetChanged()
    }

    class SimpleTextViewHolder(view: View) : ViewHolder(view) {
        val simpleTv: TextView = view.simpleTv
    }

    class PagerViewHolder(view: View) : ViewHolder(view) {
        val selectorRecyclerView: RecyclerView = view.pagerSelectorRecyclerView
        val pagerRecyclerView: RecyclerView = view.pagerRecyclerView


        class PagerSelectorAdapter(private val clickListener: (SimpleImage) -> Unit) :
            Adapter<PagerSelectorAdapter.PagerSelectorViewHolder>() {

            private val mData: MutableList<SimpleImageContainer> = mutableListOf()

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerSelectorViewHolder {
                val view = parent.inflate(R.layout.pager_selector_layout)

                return PagerSelectorViewHolder(view).apply {
                    itemView.setOnClickListener { clickListener(mData[adapterPosition]) }
                }
            }

            override fun getItemCount(): Int {
                return mData.size
            }

            override fun onBindViewHolder(holder: PagerSelectorViewHolder, position: Int) {
                holder.pagerSelectorTv.text = mData[position].
            }

            fun updateData(newData: List<SimpleImageContainer>) {
                if (newData != mData) {
                    mData.clear()
                    mData.addAll(newData)
                    notifyDataSetChanged()
                }
            }


            class PagerSelectorViewHolder(view: View) : ViewHolder(view) {
                val pagerSelectorTv: TextView = view.pagerSelectorTv
            }
        }


        class PagerImageAdapter : Adapter<PagerImageAdapter.ImagePagerViewHolder>() {

            private val mData: MutableList<String> = mutableListOf()

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePagerViewHolder {
                val view = parent.inflate(R.layout.simple_image_layout)

                return ImagePagerViewHolder(view)
            }

            override fun getItemCount(): Int {
                return mData.size
            }

            override fun onBindViewHolder(holder: ImagePagerViewHolder, position: Int) {
                holder.image.load(mData[position])
            }

            fun updateData(newData: List<String>) {
                if (newData != mData) {
                    mData.clear()
                    mData.addAll(newData)
                    notifyDataSetChanged()
                }
            }

            class ImagePagerViewHolder(view: View) : ViewHolder(view) {
                val image: ImageView = view.simpleImg
            }
        }
    }
}


















