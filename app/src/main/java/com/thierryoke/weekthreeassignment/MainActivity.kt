package com.thierryoke.weekthreeassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var usersearch: String
    lateinit var listUser: List<Infos>
    lateinit var searchView: androidx.appcompat.widget.SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchView =   findViewById(R.id.floating_search_view)
        recyclerView = findViewById(R.id.recycler_view_userlist)

        recyclerView.layoutManager = LinearLayoutManager(this)
        searchView.setOnQueryTextListener(
            object: androidx.appcompat.widget.SearchView.OnQueryTextListener
            {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    usersearch = searchView.query.toString()
                    getREsponse(usersearch)
                    searchView.clearFocus()
                    return false

                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false

                }

            }
        )

    }

    private fun getREsponse(searchString: String) {

        UsersAPI.initretrofit().searchRepos(searchString).enqueue(
            object : Callback<Base>, ClickInterface {
                override fun onResponse(
                        call: Call<Base>,
                        response: Response<Base>
                ) {
                    if (response.isSuccessful)
                        response.body()?.let {

                            recyclerView.adapter = GitListAdapter(it.items!!, this)
                            listUser = it.items

                        }
                }

                override fun onFailure(call: Call<Base>, t: Throwable) {

                    Toast.makeText(baseContext, "Failled", Toast.LENGTH_LONG).show()
                }

                override fun onCellClickListener(position: Int) {
                    val itent = Intent()
                    itent.setClass(this@MainActivity, ActivityMoreInfos::class.java)
                    itent.putExtra("KEY_MOVIE_ITEM", listUser[position].login)
                    startActivity(itent)
                }


            })
    }


}