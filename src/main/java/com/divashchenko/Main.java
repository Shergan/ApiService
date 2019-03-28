package com.divashchenko;

import com.divashchenko.Responses.Post;

public class Main {
    public static void main(String[] args) {
        ApiService service = ApiService.getInstance();

        Post post = service.getPostById(1);

        System.out.println(post);
    }
}
