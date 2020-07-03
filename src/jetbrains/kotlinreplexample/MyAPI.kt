package jetbrains.kotlinreplexample

    val data = mutableSetOf<String>()

    fun add(s: String) {
        data.add(s)
    }

    fun remove(s: String) {
        data.remove(s)
    }

    fun list() {
        data.forEach { println(it) }
    }

    fun find(s: String) {
        data.filter { it.contains(s) }.forEach { println(it) }
    }
