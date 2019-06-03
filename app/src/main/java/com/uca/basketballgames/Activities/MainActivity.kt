package com.uca.basketballgames.Activities

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uca.basketballgames.Adapters.MatchListAdapter
import com.uca.basketballgames.Adapters.MatchListAdapterLand
import com.uca.basketballgames.Model.MatchViewModel
import com.uca.basketballgames.R
import com.uca.basketballgames.Room.Entities.Partido

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    val fragmentManager = this.supportFragmentManager
    companion object{
        lateinit var matchViewModel: MatchViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter2 = MatchListAdapterLand(this)
        var adapter = MatchListAdapter(this)

        start(adapter,adapter2)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)
        matchViewModel.allMatches.observe(this, Observer { matches ->
            matches?.let { adapter.setMatches(it) }
        })
        matchViewModel.allMatches.observe(this, Observer { books ->
            books?.let { adapter2.setMatches(it) }
        })
    }

    fun start(adapter: MatchListAdapter,adapter2:MatchListAdapterLand){
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        }

        else{
            val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerview2)
            recyclerView2.adapter = adapter2
            adapter2.setManager(fragmentManager)
            recyclerView2.layoutManager = LinearLayoutManager(this)

        }
        val fab = findViewById<FloatingActionButton>(R.id.add)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewMatchActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val partido = Partido(
                    data.getLongExtra(NewMatchActivity.EXTRA_REPLY, 0),
                    data.getStringExtra(NewMatchActivity.EXTRA_REPLY4),
                    data.getStringExtra(NewMatchActivity.EXTRA_REPLY7),
                    data.getIntExtra(NewMatchActivity.EXTRA_REPLY),
                    data.getIntExtra(NewMatchActivity.EXTRA_REPLY2),
                    data.getStringExtra(NewMatchActivity.EXTRA_REPLY5),
                    data.getStringExtra(NewMatchActivity.EXTRA_REPLY)
                )
                matchViewModel.insertMatches(partido)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
