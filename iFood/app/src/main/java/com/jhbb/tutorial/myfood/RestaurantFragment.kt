package com.jhbb.tutorial.myfood

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import co.tiagoaguiar.tutorial.myfood.*
import co.tiagoaguiar.tutorial.myfood.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private lateinit var binding: FragmentRestaurantBinding
    private val categoryAdapter = ATAdapter({ CategoryView(it) })
    private val bannerAdapter = ATAdapter({ BannerView(it) })
    private val shopAdapter = ATAdapter({ ShopView(it) })
    private val moreShopAdapter = ATAdapter({ MoreShopView(it) })

    private var filters = arrayOf(
        FilterItem(1, "Ordernar", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(2, "Pra retirar", icon = R.drawable.ic_baseline_directions_walk_24),
        FilterItem(3, "Entrega grátis"),
        FilterItem(4, "Vale-refeição", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(5, "Distância", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(6, "Entrega Parceria"),
        FilterItem(7, "Super Restaurante"),
        FilterItem(8, "Filtros", closeIcon = R.drawable.ic_baseline_filter_list_24)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(1,
                "https://www.ifood.com.br/static/images/categories/market.png",
                "Mercado",
                0xFFB6D048),
            Category(2,
                "https://www.ifood.com.br/static/images/categories/restaurant.png",
                "Restaurante",
                0xFFE91D2D),
            Category(3,
                "https://www.ifood.com.br/static/images/categories/drinks.png",
                "Bebidas",
                0xFFF6D553),
            Category(4,
                "https://static-images.ifood.com.br/image/upload/f_auto/webapp/landingV2/express.png",
                "Express",
                0xFFFF0000),
            Category(5,
                "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png",
                "Saudável",
                0xFFE91D2D),
            Category(6,
                "https://www.ifood.com.br/static/images/categories/drinks.png",
                "Salgados",
                0xFF8C60C5),
        )

        bannerAdapter.items = arrayListOf(
            Banner(1,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/itensBasicosNOV21Principal_zE1X.png"),
            Banner(2,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/Bebidas40offPrincipal_cljA.png"),
            Banner(3,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/MerceariaeMatinaisPrincipal_mfDO.png"),
        )

        shopAdapter.items = arrayListOf(
            Shop(1, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek"),
            Shop(2, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/bb3ad636-7c36-4ae2-a1db-14cd35695350/202001271029_rK15_i.png", "Fábrica de Esfiha"),
            Shop(3, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/2fd863ac-4cc2-476c-8896-99aedfdaeb5f/201911150948_Z9QG_i.jpg", "Pecorino"),
            Shop(4, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/86b58685-a7dc-4596-be26-2c4037b4d591/202006051304_JuRt_i.jpg", "Barbacoa Grill"),
            Shop(5, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/e2f3424a-06fb-46dd-89c3-f7b039e2b1f0_BOLOD_PPIN02.jpeg", "Bolo de Madre"),
            Shop(6, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b9492e27ed.png", "Uau Esfiha"),
            Shop(7, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png", "Bar do Juarez"),
        )

        moreShopAdapter.items = arrayListOf(
            MoreShop(1, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 26.00),
            MoreShop(2, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/bb3ad636-7c36-4ae2-a1db-14cd35695350/202001271029_rK15_i.png", "Fábrica de Esfiha", 4.3, "Esfiha", 12.2, "60-70", 9.00),
            MoreShop(3, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/2fd863ac-4cc2-476c-8896-99aedfdaeb5f/201911150948_Z9QG_i.jpg", "Pecorino", 4.9, "Grill", 17.2, "60-70", 10.00),
            MoreShop(4, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/86b58685-a7dc-4596-be26-2c4037b4d591/202006051304_JuRt_i.jpg", "Barbacoa Grill", 4.9, "Grill", 12.2, "70-90", 40.00),
            MoreShop(5, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/e2f3424a-06fb-46dd-89c3-f7b039e2b1f0_BOLOD_PPIN02.jpeg", "Bolo de Madre", 4.7, "Bolo", 11.0, "80-90", 30.00),
            MoreShop(6, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b9492e27ed.png", "Uau Esfiha", 4.4, "Esfiha", 11.2, "60-70", 8.00),
            MoreShop(7, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png", "Bar do Juarez", 4.9, "Bar", 17.2, "40-50", 13.00),
        )

        binding = FragmentRestaurantBinding.bind(view)
        binding.let {
            it.rvCategory.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )

            it.rvBanners.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            it.rvBanners.adapter = bannerAdapter
            it.rvCategory.adapter = categoryAdapter
            it.rvShops.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvShops.adapter = shopAdapter

            it.rvMoreShops.layoutManager = LinearLayoutManager(requireContext())
            it.rvMoreShops.adapter = moreShopAdapter

            it.rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        notifyPositionUpdated(recyclerView)
                    }
                }
            })

            addDots(it.dots, bannerAdapter.items.size, 0)

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }

    private var position: Int? = RecyclerView.NO_POSITION
    private var snapHelper = LinearSnapHelper()

    private fun notifyPositionUpdated(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position =
            if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)
        val positionUpdated = this.position != position
        if (positionUpdated) {
            addDots(binding.dots, bannerAdapter.items.size, position ?: 0)
        }
        this.position = position
    }

    private fun addDots(container: LinearLayout, size: Int, position: Int) {
        container.removeAllViews()
        Array(size) {
            val textView = TextView(requireContext()).apply {
                text = getString(R.string.dotted)
                textSize = 20f
                setTextColor(
                    if (position == it) {
                        ContextCompat.getColor(requireContext(), android.R.color.black)
                    } else {
                        ContextCompat.getColor(requireContext(), android.R.color.darker_gray)
                    }
                )
            }
            container.addView(textView)
        }
    }
}

