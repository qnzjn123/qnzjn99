package com.example.board.service;

import com.example.board.dto.PostDto;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    // 전체 게시글 목록 조회
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }
    
    // 게시글 상세 조회
    @Transactional
    public Optional<Post> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(p -> {
            p.setViewCount(p.getViewCount() + 1);
            postRepository.save(p);
        });
        return post;
    }
    
    // 게시글 작성
    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setAuthor(postDto.getAuthor());
        post.setContent(postDto.getContent());
        post.setViewCount(0);
        return postRepository.save(post);
    }
    
    // 게시글 수정
    @Transactional
    public Post updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        
        post.setTitle(postDto.getTitle());
        post.setAuthor(postDto.getAuthor());
        post.setContent(postDto.getContent());
        
        return postRepository.save(post);
    }
    
    // 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    
    // 게시글 검색
    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContainingOrContentContainingOrderByCreatedAtDesc(keyword, keyword);
    }
}
