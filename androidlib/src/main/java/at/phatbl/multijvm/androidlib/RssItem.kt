package at.phatbl.multijvm.androidlib

class RssItem {
    var pubDate: String? = null
    var description: String? = null
    var link: String? = null
    var title: String? = null

    constructor() {}
    constructor(title: String?, link: String?) {
        this.title = title
        this.link = link
    }

    override fun toString(): String {
        return "RssItem [title=$title]"
    }
}
