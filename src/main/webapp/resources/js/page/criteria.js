

function Criteria(page, perPageNum) {

	   this.page = 1; //페이지 번호
	   this.perPageNum = 10; //한페이지당 보여줄 글 개수

	   this.setPage = function(page) { //댓글에서 사용 페이지가 0이하일떄는 1로 아닐때는 페이지를 덮어준다.
		   if(page <= 0) {
			   this.page = 1;
			   return;
		   }
		   this.page = page;
	   };
	   
	   this.setPerPageNum = function(perPageNum) { //한페이지당 보여줄 글 개수가 0이하거나 100개보다 많을때는 10개로
		   
		   if(perPageNum <= 0 || perPageNum > 100){
		         this.perPageNum = 10;
		         return;
		      }

		      this.perPageNum = perPageNum;
	   };
	   

	   //method for MyBatis SQL Mapper - 
	   this.getPageStart = function() {
	      return (this.page -1)* perPageNum;
	   };

}