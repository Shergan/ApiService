package com.divashchenko;

import com.divashchenko.Responses.Post;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ApiService {

    private static ApiService instance;

    private OkHttpClient client;
    private String url;
    private Gson gson;

    private ApiService() {
        client = new OkHttpClient();
        url = "https://jsonplaceholder.typicode.com/";
        gson = new Gson();
    }

    public static ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    public String takeJson(String additionalUrl) {
        StringBuilder sb = new StringBuilder(url);
        sb.append(additionalUrl);

        Request request = new Request.Builder()
                .url(sb.toString())
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Post getPostById(int id) {
        StringBuilder sb = new StringBuilder("posts/").append(id);
        return gson.fromJson(takeJson(sb.toString()), Post.class);
    }
}
