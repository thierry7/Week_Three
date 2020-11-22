package com.thierryoke.weekthreeassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMoreInfos : AppCompatActivity() {

    lateinit var imageProfile : ImageView
    lateinit var userNmae: TextView
    lateinit var email: TextView
    lateinit var locaion: TextView
    lateinit var bio: TextView
    lateinit var startDate:TextView
    lateinit var followers: TextView
    lateinit var followings: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_infos)

        userNmae = findViewById(R.id.tv_user_name)
        email = findViewById(R.id.tv_email)
        locaion= findViewById(R.id.tv_location)
        bio = findViewById(R.id.tv_bio)
        startDate = findViewById(R.id.tv_join_date)
        followers= findViewById(R.id.tv_followers)
        followings = findViewById(R.id.tv_follwings)
        imageProfile = findViewById(R.id.iv_profile)

        val user = intent.getStringExtra("KEY_MOVIE_ITEM")
        if (user != null) {
            getREsponse(user)
            getFollowers(user)
            getFollowing(user)

        }
        else
        {
            Toast.makeText(baseContext, user, Toast.LENGTH_LONG).show()


        }


    }
    private fun getREsponse(searchString: String) {

        UsersAPI.initretrofit().searchReposNumber(searchString).enqueue(
            object : Callback<UserInfos>{
                override fun onResponse(call: Call<UserInfos>, response: Response<UserInfos>)
                {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            userNmae.text = it.login
                            email.text = it.email.toString()
                            locaion.text = it.location.toString()
                            startDate.text = it.created_at
                            bio.text = it.bio.toString()
                            Picasso.get().load(it.avatar_url).into(imageProfile)
                        }
                    }
                    else
                    {
                        Toast.makeText(baseContext, "The response is null", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<UserInfos>, t: Throwable) {

                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }
    fun getFollowers(searchNameString: String){
        UsersAPI.initretrofit().searchFollowers(searchNameString).enqueue(
            object : Callback<List<followers>>{
                override fun onResponse(call: Call<List<followers>>, response: Response<List<followers>>)
                {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            followers.text = it.size.toString()
                        }
                    }
                    else
                    {
                        Toast.makeText(baseContext, "The response is null", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<followers>>, t: Throwable) {

                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }

    fun getFollowing(searchNameString: String){
        UsersAPI.initretrofit().searchFollowing(searchNameString).enqueue(
            object : Callback<List<following>>{
                override fun onResponse(call: Call<List<following>>, response: Response<List<following>>)
                {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            followings.text = it.size.toString()
                        }
                    }
                    else
                    {
                        Toast.makeText(baseContext, "The response is null", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<following>>, t: Throwable) {

                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }


            })
    }


}