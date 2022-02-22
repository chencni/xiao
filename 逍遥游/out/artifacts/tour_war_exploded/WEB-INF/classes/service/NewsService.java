package service;

import dao.NewsDao;
import model.News;
import org.json.JSONArray;
import org.json.JSONObject;
import util.StaticParameters;

import java.util.Date;

public class NewsService {
	NewsDao newsDao = new NewsDao();

	public int saveNews(JSONObject newsJson) {
		News news = new News();
		news.setContent(newsJson.getString("content"));
		news.setCreateTime(new Date());
		news.setDetail(newsJson.getString("detail"));
		news.setNewsImg(newsJson.getString("newsImg"));
		news.setTitle(newsJson.getString("title"));
		news.setUserId(newsJson.getString("userId"));
		int rs = newsDao.save(news);
		if (rs != 1) {
			System.out.println("发布失败！");
		}
		return rs;
	}

	public JSONObject getNews(Integer currentPage) {
		JSONObject pageJson = new JSONObject();// pageTatal news数组
		JSONArray newsJsonArray = newsDao.getNewsJsonArrayByCurPage(currentPage);
		int totalRecords = newsDao.getTotalRecords();
		int pagesize= StaticParameters.PAGESIZE;
		int pageInt=totalRecords/pagesize;
		int mod=totalRecords%pagesize;
		int totalPages = mod==0?pageInt:pageInt+1;
		pageJson.put("newTotalPages", totalPages);
		pageJson.put("content", newsJsonArray);
		return pageJson;
	}

}
