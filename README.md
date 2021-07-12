# springstudy

work/TestProgram1

1. board.xml BoardDAO로 수정
2. boardDTO에 getter, setter 추가(lombok 설치 대신)
3. BeanConfiguration에 Configuration 애너테이션 import
4. BoardController에 insert.do PostMapping으로 수정
5. view.jsp에 form id="f" 추가, input type="hidden" name="bIdx" value="${boardDTO.bIdx}" 추가
7. UpdateBoardCommand에 append("location.href='selectBoardByIdx.do?bIdx=" + request.getParameter("bIdx") + "'"); 수정

