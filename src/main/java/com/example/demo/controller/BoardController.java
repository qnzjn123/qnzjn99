package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/boards")
    public String list(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/boards/write")
    public String writeForm() {
        return "board/write";
    }

    @PostMapping("/boards/write")
    public String write(Board board) {
        boardService.saveBoard(board);
        return "redirect:/boards";
    }

    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @PostMapping("/boards/{id}/delete")
    public String delete(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }
}
