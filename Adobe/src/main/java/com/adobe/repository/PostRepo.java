package com.adobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adobe.models.Post;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    @Query("Select p from Post p")
    public List<Post> findTop5Likes();
}
