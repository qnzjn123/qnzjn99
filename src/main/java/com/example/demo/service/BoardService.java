package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
