package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
    
    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }
    
    @Transactional
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }
    
    @Transactional
    public Board updateBoard(Long id, Board boardDetails) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        
        board.setTitle(boardDetails.getTitle());
        board.setContent(boardDetails.getContent());
        board.setAuthor(boardDetails.getAuthor());
        
        return boardRepository.save(board);
    }
    
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
