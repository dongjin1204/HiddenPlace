//복붙해옴 수정해야함
function MyRoute(userNickname, regionName, themeName, title, content, writeDate, storeName, latitude, longitude, detailAddress, nowLoginId) {

	this.num = 0; //글번호
	this.userNickname = userNickname; //회원닉네임
	this.regionName = regionName; //지역명
	this.themeName = themeName; //테마명
	this.title = title;  //글제목
	this.content = content; //글내용
	this.writeDate = writeDate; //작성일자
	this.upCount = 0; //추천수
	this.readCount = 0; //조회수
	this.storeName = storeName; //상호명
	this.latitude = latitude; //위도
	this.longitude = longitude; //경도
	this.detailAddress = detailAddress; //상세주소
	this.bookmark = 0; //메인목록페이지의 즐겨찾기 확인여부 (0 or 1)
	this.nowLoginId = nowLoginId;//현재 로그인한 계정
}