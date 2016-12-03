$('head').append('<script src=\'../../../resources/js/page/criteria.js\'><\/script>');

function PageMaker() {

	  this.totalCount; //전체 글개수
	  this.startPage;  //시작 페이지
	  this.endPage;    //끝 페이지
	  this.prev;       //boolean타입
	  this.next;       //boolean타입
	  this.displayPageNum;
	  this.page;	
	  this.perPageNum;
	  
//	  this.displayPageNum = 10; //보여줄 페이지번호 개수
	   
//	   this.cri = new Criteria();
//
//	   this.setTotalCount = function(totalCount) { //전체 개수를 정해준다.
//	      this.totalCount = totalCount;
//	      
//	      calcData();
//	   };

//	   this.calcData = function() { //페이지 계산
//	      
//	      endPage = (Math.ceil(cri.page() / displayPageNum ) * displayPageNum);
//	      
//	      startPage = (endPage - displayPageNum) + 1;
//	      
//	      var tempEndPage = (Math.ceil(totalCount / cri.getPerPageNum()));
//	      
//	      if(endPage > tempEndPage){
//	         endPage = tempEndPage;
//	      }
//	      
//	      prev = startPage ==1 ? false : true; //startPage가 1이면 false 아니면 true
//	      
//	      next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
//	      
//	   };

//	   this.makeQuery = function(page){
//	      
//	      UriComponents uriComponents =
//	               UriComponentsBuilder.newInstance()
//	               .queryParam("page", page)
//	               .queryParam("perPageNum", cri.getPerPageNum())
//	               .build();               
//	      
//	      return uriComponents.toUriString();
//	      
//
//
//	   }
//
//	   public String makeSearch(int page){
//	      
//	      UriComponents uriComponents =
//	               UriComponentsBuilder.newInstance()
//	               .queryParam("page", page)
//	               .queryParam("perPageNum", cri.getPerPageNum())
//	               .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
//	               .queryParam("keyword", ((SearchCriteria)cri).getKeyword())
//	               .build();               
//	      
//	      return uriComponents.toUriString();
//	   }   
	
}