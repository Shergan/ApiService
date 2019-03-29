package com.divashchenko;

import com.divashchenko.Responses.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;

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

    private String takeJson(String additionalUrl) {

        Request request = new Request.Builder()
                .url(url + additionalUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Post getPostById(int id) {
        return gson.fromJson(takeJson("posts/" + id), Post.class);
    }

    public List<Post> getPosts() {
        Type listType = new TypeToken<List<Post>>() {
        }.getType();
        return gson.fromJson(takeJson("posts"), listType);
    }

    public Comment getCommentById(int id) {
        return gson.fromJson(takeJson("comments/" + id), Comment.class);
    }

    public List<Comment> getComments() {
        Type listType = new TypeToken<List<Comment>>() {
        }.getType();
        return gson.fromJson(takeJson("comments"), listType);
    }

    public Album getAlbumById(int id) {
        return gson.fromJson(takeJson("albums/" + id), Album.class);
    }

    public List<Album> getAlbums() {
        Type listType = new TypeToken<List<Album>>() {
        }.getType();
        return gson.fromJson(takeJson("albums"), listType);
    }

    public Photo getPhotoById(int id) {
        return gson.fromJson(takeJson("photos/" + id), Photo.class);
    }

    public List<Photo> getPhotos() {
        Type listType = new TypeToken<List<Photo>>() {
        }.getType();
        return gson.fromJson(takeJson("photos"), listType);
    }

    public Todo getTodoById(int id) {
        return gson.fromJson(takeJson("todos/" + id), Todo.class);
    }

    public List<Todo> getTodos() {
        Type listType = new TypeToken<List<Todo>>() {
        }.getType();
        return gson.fromJson(takeJson("todos"), listType);
    }

    public User getUserById(int id) {
        return gson.fromJson(takeJson("users/" + id), User.class);
    }

    public List<User> getUsers() {
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        return gson.fromJson(takeJson("users"), listType);
    }

    public String postPost(Post post) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, gson.toJson(post));

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return "Status: " + response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error!";
    }

    public String putPost(Post post) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, gson.toJson(post));

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .put(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return "Status: " + response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error!";
    }

    public String deletePost(Post post) {
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .delete(null)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return "Status: " + response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error!";
    }

    public List<Comment> getCommentsFromPost(int postId) {
        Type listType = new TypeToken<List<Comment>>() {
        }.getType();
        return gson.fromJson(takeJson("comments?postId=" + postId), listType);
    }

    public List<Post> getPostsFromUser(int userId) {
        Type listType = new TypeToken<List<Post>>() {
        }.getType();
        return gson.fromJson(takeJson("posts?userId=" + userId), listType);
    }
}
