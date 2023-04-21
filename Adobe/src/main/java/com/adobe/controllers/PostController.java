package com.adobe.controllers;

import com.adobe.exceptions.PostException;
import com.adobe.models.Post;
import com.adobe.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService ps;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws PostException {

        return new ResponseEntity<Post>(ps.createPost(post), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id) throws PostException {

        return new ResponseEntity<Post>(ps.getPost(id), HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Integer id, @RequestBody Post post) throws PostException {

        return new ResponseEntity<Post>(ps.updatePost(id, post), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable("id") Integer id) throws PostException {

        return new ResponseEntity<Post>(ps.deletePost(id), HttpStatus.OK);
    }

    @PostMapping("/posts/{id}/like")
    public ResponseEntity<Integer> likePost(@PathVariable("id") Integer id) throws PostException {

        return new ResponseEntity<Integer>(ps.incrementLike(id), HttpStatus.OK);
    }

    @PostMapping("/posts/{id}/unlike")
    public ResponseEntity<Integer> unlikePost(@PathVariable("id") Integer id) throws PostException {

        return new ResponseEntity<>(ps.decrementLike(id), HttpStatus.OK);
    }

    @GetMapping("/analytics/posts")
    public ResponseEntity<Long> getTotalPosts() {

        return new ResponseEntity<Long>(ps.totalNumberOfPosts(), HttpStatus.OK);
    }

    @GetMapping("/analytics/posts/top-liked")
    public ResponseEntity<List<Post>> getTopLikedPosts() {

        return new ResponseEntity<List<Post>>(ps.top5MostLikedPosts(), HttpStatus.OK);
    }
}
