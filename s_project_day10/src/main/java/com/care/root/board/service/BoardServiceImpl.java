package com.care.root.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.common.MemberSessionName;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;
	
	@Override
	public void selectAllBoardList(Model model, int num) {
		int pageLetter = 3;
		int allCount = mapper.selectBoardCount();
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		
		model.addAttribute("repeat", repeat);	//이걸 추가 안해서 jsp쪽에서 페이지번호 표시가 안되는 문제가 있었음 
		model.addAttribute("boardList", mapper.selectAllBoardList(start, end));
	}
	
	@Override
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle( mul.getParameter("title") );
		dto.setContent( mul.getParameter("content") );
		dto.setId(mul.getParameter("id"));
		//위의 방식으로 해도 되고 아래 주석방식으로 해도됨
		//HttpSession session = request.getSession();
		//dto.setId((String)session.getAttribute(MemberSessionName.LOGIN));

		MultipartFile file = mul.getFile("image_file_name");
		//BoardFileService bfs = new BoardFileServiceImpl();
		//어노테이션을 넣어서 new를 주석처리함
		
		if(file.getSize() != 0) {
			//이미지 있을경우 처리
			dto.setImageFileName( bfs.saveFile(file) );
		}else {
			dto.setImageFileName("nan");
		}
		
		int result = 0;
		try {
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
			//이렇게 처리하면 문제가 발생해도 사용자에게 오류페이지를 보여주지 않을 수 있다
		}
		//return bfs.getMessage(mapper.writeSave(dto), request);
		//0 또는 1이 들어옴 / request는 BoardFileServiceImpl에서 경로를 넣기위해 존재
		return bfs.getMessage(result, request);
	}

	@Override
	public void contentView(int writeNo, Model model) {
		model.addAttribute("personalData", mapper.contentView(writeNo));
		//personalData를 통해 jsp에서 값을 하나씩 꺼내올 수 있음
		upHit(writeNo);
	}
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}
	
	public String boardDelete(int writeNo,String imageFileName, HttpServletRequest request) {
		//BoardFileService bfs = new BoardFileServiceImpl();
		//autowired 했기때문에 없어도됨
		
		int result = mapper.delete(writeNo);
		//MessageDTO mDTO = new MessageDTO(); //dto 안만들고 그냥 함
		
		String message = null;
		if(result == 1) { 
			bfs.deleteImage(imageFileName); 
			message = bfs.getMessage(request, "삭제 성공", "/board/boardAllList");
			//result가 1이면 데이터베이스에서 성공적으로 삭제했으므로 이미지도 삭제함
		}else {
			message = bfs.getMessage(request, "삭제 실패", "/board/contentView");
		}
		
		return message;
	}

	public void getData(int writeNo, Model model) {
		model.addAttribute("personalData", mapper.contentView(writeNo));
		//contentView와 같은 내용이지만 거기에는 조회수를 올리는 기능이 있어서 새롭게 하나 만들었음
	}
	
	public String modify(MultipartHttpServletRequest mul, HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setWriteNo( Integer.parseInt(mul.getParameter("writeNo")) );
		//getParameter로 가져오면 문자열로 들어오기 때문에 int로 형변환
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));

		MultipartFile file = mul.getFile("imageFileName");
		if(file.getSize() != 0 ) {
			//이미지 변경시
			dto.setImageFileName(bfs.saveFile(file));
			bfs.deleteImage(mul.getParameter("originFileName"));
			//원래있던 이미지를 삭제하고 새로운 이미지 저장(전에 있던 메소드를 가져와서 사용)
		}else {
			dto.setImageFileName(mul.getParameter("originFileName"));
		}
		int result = mapper.modify(dto);
		String msg, url;
		if(result == 1) {
			msg = "성공적으로 수정되었습니다";
			url = "/board/boardAllList";
		}else {
			msg = "수정 중 문제가 발생하였습니다";
			url = "/board/modify_form";
		}
		String message = bfs.getMessage(request, msg, url);
		return message;
	}

	@Override
	public String addReply(BoardRepDTO dto) {
		int result = mapper.addReply(dto);
		String msg = null;
		if(result == 1) {
			msg = "{\"result\" : true}";
		}else {
			msg = "{\"result\" : false}";
		}
		return msg;
	}

	@Override
	public List<BoardRepDTO> getRepList(int write_group) {
		
		return mapper.getRepList(write_group);
	}

}
