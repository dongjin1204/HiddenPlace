package com.phoenix.hiddenplace.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;

@Repository
public class MyHiddenPlaceDaoImpl implements MyHiddenPlaceDao {


	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.phoenix.hiddenplace.mapper.MyHiddenPlaceMapper";
	
	@Override
	public void insert(MyHiddenPlace myHiddenPlace) throws Exception {
		sqlSession.insert(namespace + ".insert", myHiddenPlace);
	}

	@Override
	public MyHiddenPlace selectOne(int num) throws Exception {// 내알못 조회
		
		return sqlSession.selectOne(namespace + ".selectOne", num);
		
	}
	
	@Override
	public void updateReadCount(int num) throws Exception { // 내알못 조회수 증가
		
		sqlSession.selectOne(namespace + ".readCountPlus", num);
		
	}
	
	@Override
	public List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception {
		int page = pageMaker.getPage();
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return sqlSession.selectList(namespace + ".list" , page);
	}

	@Override
	public int listCount(PageMaker pageMaker) {
		
		return sqlSession.selectOne(namespace + ".listCount", pageMaker);
	}

	@Override
	public List<MyHiddenPlace> bestMHP(String userId) throws Exception {
		return sqlSession.selectList(namespace + ".bestMHP");
		
	}
	
	@Override
	public List<MyHiddenPlace> bookmarkAll(String userId) throws Exception {
		return sqlSession.selectList(namespace + ".bookmarkAll");
		
	}
	
	
	//내알못 베스트 업데이트
	@Override
	public void bestUpdateMHP() throws Exception {//내알못을 선정해준다 처음 실행할때 베스트4를 찾아서 베스트코드를 1로 업데이트

		String clientId = "nz8X3qf9RG0Yf_HOqllw";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "7xCblviTRC";//애플리케이션 클라이언트 시크릿값";
		String title_Name = "";
		int[][] BestMHP_array;
		int totalCount = 0;

		try {

			sqlSession.update(namespace + ".bestCodeReset"); //업데이트 베스트코드 0 만들기
			List<String> storeName = sqlSession.selectList(namespace + ".bestUpdateMHP"); //글목록중 추천수 500개이상의 상호명을 불러온다.

			BestMHP_array = new int[storeName.size()][2];
			
			for(int i = 0 ; i < storeName.size(); i++) { //상호명으로 네이버 검색해서 베스트4결정

				BestMHP_array[i][0] = i;

				String text = URLEncoder.encode(storeName.get(i), "UTF-8");
				String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과

				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", clientId);
				con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				int responseCode = con.getResponseCode();
				BufferedReader br;
				if(responseCode==200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {  // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				String inputLine;

				int k = 0 ;
				while ((inputLine = br.readLine()) != null) {
					if(k == 2){//2번째배열이 total뽑는부분
						String[] total_Split = inputLine.split(": ");
						String[] totalCount_String = total_Split[1].split(",");
						totalCount =  Integer.parseInt(totalCount_String[0]);
						BestMHP_array[i][1] = totalCount;
						break;
					}
					k++;
				}

				br.close();

			}
			//배열 정렬하기(상위가 작은순)
			int[] temp = new int[storeName.size()];
			for(int i=0;i<storeName.size();i++) {
				for(int j=0;j<storeName.size();j++) {

					if(BestMHP_array[i][1]<BestMHP_array[j][1]) {

						temp = BestMHP_array[i];
						BestMHP_array[i] = BestMHP_array[j];
						BestMHP_array[j] = temp;
					}
				}
			}

			//3위까지 검색하고 상호명을 다시 담기.
			for(int i=0; i<3; i++) {

				title_Name = title_Name + storeName.get(BestMHP_array[i][0]);
				if(i == 3){
					break;
				}else{
				title_Name = title_Name +  ",";	
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		sqlSession.selectList(namespace + ".bestFinalUpdateMHP", title_Name); //네이버 검색후 비교를해서 베스트코드 업데이트해준다.

	}

}