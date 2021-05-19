package me.texy.treeviewdemo.data.remote.api

object ApiPath {
    /**
     * Header
     */
    const val AUTH_TOKEN = "X-Auth-Token"

    /**
     * Api_url
     */
    const val FOOTBALL_API_URL = "https://api.football-data.org/v2/"
    const val CREST_API_URL = "https://football-crest-api.herokuapp.com/crest/"
    const val COVER_IMAGE_URL = "https://loremflickr.com/320/240/"
    const val REDDIT_API_URL = "https://www.reddit.com/"


    const val TOURNAMENTS = "competitions?plan=TIER_ONE"
    const val TOURNAMENT_ID = "competitions/"

    //get Teams
    const val TEAMS = "teams/"

    //get matches
    const val MATCHES = "matches/"
}