package com.thierryoke.weekthreeassignment


data class Infos(
    val login: String?,
    val id: Number?,
    val node_id: String?,
    val avatar_url: String?,
    val gravatar_id: String?,
    val url: String?,
    val html_url: String?,
    val followers_url: String?,
    val following_url: String?,
    val gists_url: String?,
    val starred_url: String?,
    val subscriptions_url: String?,
    val organizations_url: String?,
    val repos_url: String?,
    val events_url: String?,
    val received_events_url: String?,
    val type: String?,
    val site_admin: Boolean?,
    val score: Number?
)

data class Base(
        val total_count: Number?,
        val incomplete_results: Boolean?,
        val items: List<Infos>?
)
data class followers(val login: String?, val id: Number?, val node_id: String?,
                     val avatar_url: String?, val gravatar_id: String?, val url: String?,
                     val html_url: String?, val followers_url: String?,
                     val following_url: String?, val gists_url: String?,
                     val starred_url: String?, val subscriptions_url: String?,
                     val organizations_url: String?, val repos_url: String?,
                     val events_url: String?,
                     val received_events_url: String?,
                     val type: String?, val site_admin: Boolean?)

data class following(val login: String?, val id: Number?, val node_id: String?,
                     val avatar_url: String?, val gravatar_id: String?, val url: String?,
                     val html_url: String?, val followers_url: String?,
                     val following_url: String?, val gists_url: String?,
                     val starred_url: String?, val subscriptions_url: String?,
                     val organizations_url: String?, val repos_url: String?,
                     val events_url: String?,
                     val received_events_url: String?,
                     val type: String?, val site_admin: Boolean?)
