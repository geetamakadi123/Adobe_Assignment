package com.adobe.services;

import com.adobe.exceptions.PostException;
import com.adobe.models.Post;

import java.util.List;

public interface PostService {
    public Post createPost(Post post) throws PostException;
    public Post getPost(int id) throws PostException;
    public Post updatePost(int id,Post post) throws PostException;
    public Post deletePost(int id) throws PostException;
    public int incrementLike(int post_id) throws PostException;
    public int decrementLike(int post_id) throws PostException;
    public long totalNumberOfPosts();
    public List<Post> top5MostLikedPosts();
}
//POST /posts: Create a new post. The request should include the user_id.
//GET /posts/{id}: Retrieve a post by id.
//PUT /posts/{id}: Update a post's content by id.
//DELETE /posts/{id}: Delete a post by id.
//POST /posts/{id}/like: Increment the like count of a post by id.
//POST /posts/{id}/unlike: Decrement the like count of a post by id. The count
//should not go below 0.
//GET /analytics/posts: Retrieve the total number of posts.
//GET /analytics/posts/top-liked: Retrieve the top 5 most liked posts.
