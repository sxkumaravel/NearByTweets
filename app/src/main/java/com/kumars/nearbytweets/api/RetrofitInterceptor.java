package com.kumars.nearbytweets.api;

import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Interceptor for Retrofit to add auth key to header.
 * TODO: what can be improved - reuse the same toke unless it is invalid
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class RetrofitInterceptor implements Interceptor {

    private String mToken = null;

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

        if (mToken == null) {
            ResponseBody body = chain.proceed(getToken()).body();

            try {
                JSONObject jsonObject = new JSONObject(body.string());
                mToken = "Bearer " + jsonObject.optString("access_token");
            } catch (JSONException e) {
                Log.d(RetrofitInterceptor.class.getName(), "Error fetching token");
            }
        }

        request = request.newBuilder()
                .addHeader("Authorization", mToken)
                .build();

        return chain.proceed(request);
    }

    private Request getToken() {
        String bearerToken = APIConstants.TWITTER_CONSUMER_KEY + ":" + APIConstants.TWITTER_CONSUMER_SECRET;

        String base64BearerToken = "Basic " + Base64.encodeToString(bearerToken.getBytes(), Base64.NO_WRAP);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8"), "grant_type=client_credentials");

        return new Request.Builder()
                .url(APIConstants.AUTH_URL)
                .post(requestBody)
                .header("Authorization", base64BearerToken)
                .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build();
    }
}
