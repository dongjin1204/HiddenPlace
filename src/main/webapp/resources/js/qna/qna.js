function MyHiddenPlace(qnaNum, title, content,userId,userNickname, QnaWriteDate) {
	this.qnaNum = 0; //글번호
	this.userNickname = userNickname; //회원닉네임
	this.title = title;  //글제목
	this.content = content; //글내용
	this.userId = userId; //현재 로그인한 계정
	this.QnaWriteDate = QnaWriteDate; //작성 날짜
}