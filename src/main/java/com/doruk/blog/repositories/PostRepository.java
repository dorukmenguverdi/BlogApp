package com.doruk.blog.repositories;

import com.doruk.blog.domain.PostStatus;
import com.doruk.blog.domain.entities.Category;
import com.doruk.blog.domain.entities.Post;
import com.doruk.blog.domain.entities.Tag;
import com.doruk.blog.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);
    List<Post> findAllByStatusAndTagsContaining(PostStatus status, Tag tag);
    List<Post> findAllByStatus(PostStatus postStatus);
    List<Post> findAllByAuthorAndStatus(User Author, PostStatus status);
}
