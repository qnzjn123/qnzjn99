package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    // 게시글 목록
    @GetMapping
    public String listBoards(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }
    
    // 게시글 상세보기
    @GetMapping("/{id}")
    public String viewBoard(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        model.addAttribute("board", board);
        return "board/view";
    }
    
    // 게시글 작성 폼
    @GetMapping("/new")
    public String newBoardForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/form";
    }
    
    // 게시글 저장
    @PostMapping
    public String saveBoard(@ModelAttribute Board board) {
        boardService.saveBoard(board);
        return "redirect:/board";
    }
    
    // 게시글 수정 폼
    @GetMapping("/{id}/edit")
    public String editBoardForm(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        model.addAttribute("board", board);
        return "board/form";
    }
    
    // 게시글 수정
    @PostMapping("/{id}")
    public String updateBoard(@PathVariable Long id, @ModelAttribute Board board) {
        boardService.updateBoard(id, board);
        return "redirect:/board/" + id;
    }
    
    // 게시글 삭제
    @PostMapping("/{id}/delete")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board";
    }
}
