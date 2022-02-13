package at.phatbl.multijvm.androidlib

import java.util.*

object RssFeedProvider {
    fun parse(rssFeed: String?): List<RssItem> {
        val list: MutableList<RssItem> = ArrayList()
        val r = Random()
        // random number of item but at least 5
        val number = r.nextInt(10) + 5
        for (i in 0 until number) {
            // create sample data
            val s = r.nextInt(1000).toString()
            val item = RssItem("Summary $s", "Description $s")
            list.add(item)
        }
        return list
    }
}
