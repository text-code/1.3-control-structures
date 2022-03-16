private const val MINUTES: Int = 60
private const val HOURS: Int = 60 * 60
private const val DAY: Int = 24 * 60 * 60
private const val TWO_DAY = DAY * 2
private const val THREE_DAY: Int = DAY * 3

fun main() {
    val result = agoToText(DAY - HOURS * 3)
    println(result)
}

fun agoToText(
    time: Int,
): String {
    return when {
        time < MINUTES -> "был(а) только что"
        time < HOURS && time >= MINUTES -> "был(а) в сети ${minutes(time)} назад"
        time < DAY && time >= HOURS -> "был(а) в сети ${hours(time)} назад"
        time < TWO_DAY && time >= DAY -> "был(а) в сети день назад"
        time < THREE_DAY && time >= TWO_DAY -> "был(а) в сети два дня назад"
        else -> "был(а) давно"
    }
}

fun minutes(seconds: Int): String {
    return when {
        (seconds / MINUTES) % 10 == 1 && (seconds / MINUTES) % 100 != 11 -> "${seconds / MINUTES} минуту"
        else -> "${seconds / MINUTES} минут"
    }
}

fun hours(seconds: Int): String {
    return when {
        (seconds / HOURS) % 10 == 1 && (seconds / HOURS) % 100 != 11 -> "${seconds / HOURS} час"
        else -> "${seconds / HOURS} часа"
    }
}