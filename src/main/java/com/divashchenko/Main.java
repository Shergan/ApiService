package com.divashchenko;

import com.divashchenko.Responses.Post;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApiService service = ApiService.getInstance();

        Post post = service.getPostById(1);
        System.out.println(post);

        System.out.println();
        System.out.println("POST: " + service.postPost(post));
        System.out.println("PUT: " + service.putPost(post));
        System.out.println("DELETE: " + service.deletePost(post));
        System.out.println();

        System.out.println("GET /comments?postId=1 : ");
        System.out.println();
        System.out.println(service.getCommentsFromPost(1));
        System.out.println();

        System.out.println("GET /posts?userId=1 : ");
        System.out.println();
        System.out.println(service.getPostsFromUser(1));
        System.out.println();

        System.out.println("Get Posts:");
        System.out.println();
        List<Post> posts = service.getPosts();
        System.out.println(posts);
    }
}
