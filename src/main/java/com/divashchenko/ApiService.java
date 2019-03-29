package com.divashchenko;

import com.divashchenko.Responses.*;
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

    public List<Post> getPosts() {
        Type listType = new TypeToken<List<Post>>() {
        }.getType();
        return gson.fromJson(takeJson("posts"), listType);
    }

    public Comment getCommentById(int id) {
        StringBuilder sb = new StringBuilder("comments/").append(id);
        return gson.fromJson(takeJson(sb.toString()), Comment.class);
    }

    public List<Comment> getComments() {
        Type listType = new TypeToken<List<Comment>>() {
        }.getType();
        return gson.fromJson(takeJson("comments"), listType);
    }

    public Album getAlbumById(int id) {
        StringBuilder sb = new StringBuilder("albums/").append(id);
        return gson.fromJson(takeJson(sb.toString()), Album.class);
    }

    public List<Album> getAlbums() {
        Type listType = new TypeToken<List<Album>>() {
        }.getType();
        return gson.fromJson(takeJson("albums"), listType);
    }

    public Photo getPhotoById(int id) {
        StringBuilder sb = new StringBuilder("photos/").append(id);
        return gson.fromJson(takeJson(sb.toString()), Photo.class);
    }

    public List<Photo> getPhotos() {
        Type listType = new TypeToken<List<Photo>>() {
        }.getType();
        return gson.fromJson(takeJson("photos"), listType);
    }

    public Todo getTodoById(int id) {
        StringBuilder sb = new StringBuilder("todos/").append(id);
        return gson.fromJson(takeJson(sb.toString()), Todo.class);
    }

    public List<Todo> getTodos() {
        Type listType = new TypeToken<List<Todo>>() {
        }.getType();
        return gson.fromJson(takeJson("todos"), listType);
    }

    public User getUserById(int id) {
        StringBuilder sb = new StringBuilder("users/").append(id);
        return gson.fromJson(takeJson(sb.toString()), User.class);
    }

    public List<User> getUsers() {
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        return gson.fromJson(takeJson("users"), listType);
    }
}
