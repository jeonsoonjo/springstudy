# springstudy

work/TestProgram1

1. board.xml BoardDAO로 수정
2. BeanConfiguration에 Configuration 애너테이션 import
3. BoardController에 insert.do PostMapping으로 수정
4. jsp에 script 링크 추가
5. view.jsp에 form id="f" 추가, <input type="hidden" name="bIdx" value="${boardDTO.bIdx}"> 추가
6. UpdateBoardCommand에 append("location.href='selectBoardByIdx.do?bIdx=" + request.getParameter("bIdx") + "'"); 수정

