package com.adobe.services;

import com.adobe.exceptions.PostException;
import com.adobe.models.Post;
import com.adobe.models.User;
import com.adobe.repository.PostRepo;
import com.adobe.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImply implements PostService{
    @Autowired
    private PostRepo pr;

    @Autowired
    private UserRepo ur;

    @Override
    public Post createPost(Post post) throws PostException {
        User user = ur.findById(post.getUser_id().getUserId())
                .orElseThrow(() -> new PostException("(︺︹︶) No user with "+ post.getUser_id().getUserId()+" (︺︹︶)"));
        post.setUser_id(user);
        post.setCreated_at(LocalDateTime.now());
        return pr.save(post);
    }

    @Override
    public Post getPost(int id) throws PostException {
        return pr.findById(id)
                .orElseThrow(() -> new PostException("(︺︹︶) No Post with "+ id+" (︺︹︶)"));
    }

    @Override
    public Post updatePost(int id, Post post) throws PostException {
        // check if post exists
        Post existingPost = pr.findById(id)
                .orElseThrow(() -> new PostException("(︺︹︶) No Post with "+ id+" (︺︹︶)"));
        // update post fields
        existingPost.setContent(post.getContent());
        // set updated_at timestamp
        existingPost.setUpdated_at(LocalDateTime.now());
        // save updated post to database
        return pr.save(existingPost);
    }

    @Override
    public Post deletePost(int id) throws PostException {
        Post post = pr.findById(id)
                .orElseThrow(() -> new PostException("(︺︹︶) No Post with "+ id+" (︺︹︶)"));
        // delete post from database
        pr.delete(post);
        return post;
    }

    @Override
    public int incrementLike(int post_id) throws PostException {

        Post post = pr.findById(post_id)
                .orElseThrow(() -> new PostException("(︺︹︶) No Post with "+ post_id+" (︺︹︶)"));
        int count= post.getLikes() + 1;
        post.setLikes(count);
        pr.save(post);

        return count;
    }

    @Override
    public int decrementLike(int post_id) throws PostException {

        Post post = pr.findById(post_id)
                .orElseThrow(() -> new PostException("(︺︹︶) No Post with "+ post_id+" (︺︹︶)"));
        int count= Math.max(0, post.getLikes() - 1);
        post.setLikes(count);
        pr.save(post);

        return count;
    }

    @Override
    public long totalNumberOfPosts() {

        return pr.count();
    }

    @Override
    public List<Post> top5MostLikedPosts() {
        return pr.findTop5Likes();
    }
}
