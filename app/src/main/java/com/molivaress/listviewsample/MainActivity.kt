package com.molivaress.listviewsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFirstOption.setOnClickListener { loadAndRender(20) }
        btnSecondOption.setOnClickListener { loadAndRender(200) }
    }

    private fun loadAndRender(limit: Int) {
        val items = loadItems(limit)
        lvPoll.adapter = PollArrayAdapter(this, R.layout.poll_item, items)
    }

    private fun loadItems(limit: Int): List<Poll> {
        val items = mutableListOf<Poll>()
        try {
            val inputStream = assets.open(limit.toString().plus(".json"))
                .bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(inputStream)
            for (index in jsonArray.length() - 1 downTo 1) {
                val jsonObject = jsonArray.getJSONObject(index)
                val title: String = jsonObject.getString("title")
                val body: String = jsonObject.getString("body")
                items.add(Poll(title, body))
            }
        } catch (exception: Exception) {
            Log.e(TAG, exception.message, exception)
            items.add(Poll(getString(R.string.load_data_message_error)))
        }
        return items
    }
}