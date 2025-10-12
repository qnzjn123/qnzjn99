package com.example.board.controller;

import com.example.board.dto.PostDto;
import com.example.board.entity.Post;
import com.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    // 게시글 목록 페이지
    @GetMapping
    public String listPosts(@RequestParam(required = false) String search, Model model) {
        List<Post> posts;
        if (search != null && !search.isEmpty()) {
            posts = postService.searchPosts(search);
        } else {
            posts = postService.getAllPosts();
        }
        model.addAttribute("posts", posts);
        model.addAttribute("search", search);
        return "list";
    }
    
    // 게시글 작성 페이지
    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new PostDto());
        return "form";
    }
    
    // 게시글 작성 처리
    @PostMapping
    public String createPost(@ModelAttribute PostDto postDto) {
        postService.createPost(postDto);
        return "redirect:/posts";
    }
    
    // 게시글 상세 페이지
    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        model.addAttribute("post", post);
        return "view";
    }
    
    // 게시글 수정 페이지
    @GetMapping("/{id}/edit")
    public String editPostForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setAuthor(post.getAuthor());
        postDto.setContent(post.getContent());
        
        model.addAttribute("post", postDto);
        model.addAttribute("isEdit", true);
        return "form";
    }
    
    // 게시글 수정 처리
    @PostMapping("/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute PostDto postDto) {
        postService.updatePost(id, postDto);
        return "redirect:/posts/" + id;
    }
    
    // 게시글 삭제 처리
    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
