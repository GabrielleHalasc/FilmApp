import timber.log.Timber

class UtilFunctions {

    companion object {
        fun logError(tag: String, message: String) {
            Timber.tag(tag).e("Error ->$message")
        }

        fun logInfo(tag: String, message: String) {
            Timber.tag(tag).i("Info ->$message")
        }
    }
}