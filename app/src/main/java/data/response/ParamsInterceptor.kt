package data.response

import com.example.filmapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(Constants.language_param, Constants.language_Value)
            .addQueryParameter(Constants.API_KEY_PARAM, BuildConfig.API_KEY)

        val newRequest = request.newBuilder()
            .build()

        return chain.proceed(newRequest)
    }
}
