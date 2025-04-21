package com.example.zadanie2360_scroll

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanie2350_adapterdelegates.adapter.ProductAdapter
import com.example.zadanie2350_adapterdelegates.model.Ad
import com.example.zadanie2350_adapterdelegates.model.Product

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(
            arrayListOf(
                Product(
                    0,
                    R.drawable.ic_apple,
                    "Apple",
                    "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
                ),
                // Пример Ad
                Ad("Акция", "Скидка на бананы 15%"),

                Product(
                    1,
                    R.drawable.ic_banana,
                    "Banana",
                    "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
                ),
                Product(
                    2,
                    R.drawable.ic_lemon,
                    "Lemon",
                    "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
                ),
                Product(
                    3,
                    R.drawable.ic_pear,
                    "Pear",
                    "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
                ),
                Product(
                    4,
                    R.drawable.ic_strawberry,
                    "Strawberry",
                    "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
                ),
                Product(
                    5,
                    R.drawable.ic_orange,
                    "Orange",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                ),
                Product(
                    6,
                    R.drawable.ic_blueberry,
                    "Голубика",
                    "Голубика, просто голубика."
                ),
                Product(
                    7,
                    R.drawable.ic_cucumber,
                    "Огурец",
                    "Огурец, просто огурец."
                ),
                Product(
                        8,
                R.drawable.ic_grapefruit,
                "Грейпфрут",
                "Грейпфрут, просто грейпфрут."
                ),
                Product(
                    9,
                    R.drawable.ic_lime,
                    "Лайм",
                    "Лайм, просто лайм."
                ),
                Product(
                    10,
                    R.drawable.ic_melon,
                    "Дыня",
                    "Дыня, просто дыня."
                ),
                Product(
                        11,
                R.drawable.ic_plum,
                "Слива",
                "Слива, просто слива."
            ),
                Product(
                    12,
                    R.drawable.ic_pomelo,
                    "Помело",
                    "Помело, просто помело."
                ),
                Product(
                    13,
                    R.drawable.ic_tomato,
                    "Помидор",
                    "Помидор, просто помидор."
                ),
                Product(
                    14,
                    R.drawable.ic_watermelon,
                    "Арбуз",
                    "Арбуз, просто арбуз."
                )
            )
        )
        recyclerView.adapter = adapter

        //Код для новой задачи
        var savePositionFirst = 0
        var savePositionLast = 0

        //Метод, который сохраняет текущую позицию скрола
        fun savePosition() {
            var savePositionFirst =
                (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
            var savePositionLast =
                (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
        }
        //Метод, который скролит список к началу
        fun scrollToStart() {
            recyclerView.scrollToPosition(0)
        }
        //Метод, который скролит к savePositionFirst
        fun scrollToSaveStartPosition() {

            recyclerView.scrollToPosition(savePositionFirst)
        }
        //Метод, который скролит к savePositionLast
        fun scrollToSaveLastPosition() {
            recyclerView.scrollToPosition(savePositionLast)
        }
        //Метод который скролит список в конец
        fun scrollToEnd() {
            recyclerView.scrollToPosition(adapter.itemCount - 1)
        }

        val up = findViewById<ImageView>(R.id.up)
        val save = findViewById<ImageView>(R.id.save)
        val down = findViewById<ImageView>(R.id.down)
        up.setOnClickListener {
            if ((recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition() == 0) {
                scrollToSaveLastPosition()
            } else {
                scrollToStart()
            }
        }

        save.setOnClickListener {
            savePosition()
        }

        down.setOnClickListener {
            if ((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == adapter.itemCount - 1) {
                scrollToSaveStartPosition()
            } else {
                scrollToEnd()

            }
        }
    }
}
