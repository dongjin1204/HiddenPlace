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
import com.phoenix.hiddenplace.domain.Theme;

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

		page = (page - 1) * 6;
		pageMaker.setPage(page);

		return sqlSession.selectList(namespace + ".list" , pageMaker);
	}

	@Override
	public int listCount(PageMaker pageMaker) {

		return sqlSession.selectOne(namespace + ".listCount", pageMaker);
	}

	@Override
	public List<MyHiddenPlace> bestMHP() throws Exception {

		return sqlSession.selectList(namespace + ".bestMHP");
	}

	@Override
	public List<Theme> themeList() throws Exception {

		return sqlSession.selectList(namespace + ".themeList");
	}

	@Override
	public List<MyHiddenPlace> bookmarkAll(String userId) throws Exception {

		return sqlSession.selectList(namespace + ".bookmarkAll", userId);
	}

	@Override
	public void delete(int num) throws Exception { //내알못 삭제

		sqlSession.delete(namespace + ".delete", num);
	}

	@Override
	public Integer upCountCheck(MyHiddenPlace myHiddenPlace) throws Exception {//추천수 받아오기 

		return sqlSession.selectOne(namespace + ".upCountCheck", myHiddenPlace);
	}

	@Override
	public void upCountInsert(MyHiddenPlace myHiddenPlace) throws Exception { //추천수 증가를 위한 정보 저장

		sqlSession.insert(namespace + ".upCountInsert", myHiddenPlace);
	}

	@Override
	public void upCount(MyHiddenPlace myHiddenPlace) throws Exception { //추천수 증가

		sqlSession.update(namespace + ".upCount", myHiddenPlace);
	}

	@Override
	public void updateMHP(MyHiddenPlace myHiddenPlace) throws Exception { //내알못 수정

		sqlSession.update(namespace + ".update", myHiddenPlace);
	}

	@Override
	public void updateBestCode() throws Exception {

		sqlSession.update(namespace + ".updateBestCode");
	}


	@Override
	public String updateBestStoreName() throws Exception {

		List<MyHiddenPlace> myHiddenPlaces = sqlSession.selectList(namespace + ".updateBestStoreName");

		String clientId = "nz8X3qf9RG0Yf_HOqllw";
		String clientSecret = "7xCblviTRC";
		String title_Name = "";
		int[][] BestMHP_array;
		int totalCount = 0;

		try {
			BestMHP_array = new int[myHiddenPlaces.size()][2];

			for(int i = 0 ; i < myHiddenPlaces.size() ; i ++){
				BestMHP_array[i][0] = i;

				String text = URLEncoder.encode(myHiddenPlaces.get(i).getStoreName(), "UTF-8");
				String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text;
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", clientId);
				con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				int responseCode = con.getResponseCode();
				BufferedReader br;;
				
				if(responseCode==200) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				
				String inputLine;
				int k = 0 ;

				while ((inputLine = br.readLine()) != null) {
					
					if(k == 2) {
						String[] total_Split = inputLine.split(": ");
						String[] totalCount_String = total_Split[1].split(",");
						totalCount =  Integer.parseInt(totalCount_String[0]);
						BestMHP_array[i][1] = totalCount;
					}
					
					k++;
				} 
				
				br.close();
			}

			//배열 정렬하기
			int[] temp = new int[myHiddenPlaces.size()];
			
			for(int i=0;i<myHiddenPlaces.size();i++) {
				for(int j=0;j<myHiddenPlaces.size();j++) {
					if(BestMHP_array[i][1]<BestMHP_array[j][1]) {
						temp = BestMHP_array[i];
						BestMHP_array[i] = BestMHP_array[j];
						BestMHP_array[j] = temp;
					}
				}
			}

			//3위까지 검색하고 상호명을 다시 담기.
			for(int i=0;i<3;i++) {
				title_Name = title_Name + myHiddenPlaces.get(BestMHP_array[i][0]).getNum() + ",";
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return title_Name.substring(0, (title_Name.length() - 1));
	}

	@Override
	public void updateBestMHP(String storeNames) throws Exception {
		
		sqlSession.update(namespace + ".updateBestMHP", storeNames);
	}

}