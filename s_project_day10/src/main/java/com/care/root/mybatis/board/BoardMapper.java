package com.care.root.mybatis.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {
	public List<BoardDTO> selectAllBoardList(@Param("s") int start, @Param("e") int end);
	//데이터베이스에서 쓸 이름은 s(xml에 있는 이름), 넘어온 이름은 start(넘길값이 2개 이상이면 꼭 @Param으로 명시해줘야함)
	public int writeSave(BoardDTO dto);
	//글이 문제없이 저장되면 1이 돌아오고 실패시 0이 돌아옴
	public BoardDTO contentView(int writeNo);
	public void upHit(int writeNo);
	public int delete(int writeNo);
	public int modify(BoardDTO dto);
	public int addReply(BoardRepDTO dto);
	public List<BoardRepDTO> getRepList(int write_group);
	public int selectBoardCount();
}
