package service;

import dao.GalleryDao;
import model.Gallery;
import org.json.JSONArray;
import org.json.JSONObject;
import util.StaticParameters;

import java.util.ArrayList;
import java.util.Date;

public class GalleryService {
	GalleryDao galleryDao = new GalleryDao();

	public int saveGallery(JSONObject galleryJson) {
		ArrayList<Gallery> gList=new ArrayList<Gallery>();
		String userId = galleryJson.getString("userId");
		JSONArray imagesUrl = galleryJson.getJSONArray("imagesUrl");
		for (int i = 0; i <imagesUrl.length(); i++) {
			Gallery gallery = new Gallery();
			gallery.setCreateTime(new Date());
//			gallery.setDetail(galleryJson.getString("detail"));
			gallery.setImageUrl((String) imagesUrl.get(i));
//			gallery.setTitle(galleryJson.getString("title"));
			gallery.setUserId(galleryJson.getString("userId"));
			gList.add(gallery);
		}
		int rs = galleryDao.save(gList);
		if (rs <1) {
			System.out.println("发布失败！");
		}
		return rs;
	}

	public JSONObject getGallery(Integer currentPage) {
		JSONObject pageJson = new JSONObject();// pageTatal gallery数组
		JSONArray galleryJsonArray = galleryDao.getGalleryJsonArrayByCurPage(currentPage);
		int totalRecords = galleryDao.getTotalRecords();
		int pagesize=StaticParameters.GaLLERYPAGESIZE;
		int pageInt=totalRecords/pagesize;
		int mod=totalRecords%pagesize;
		int totalPages = mod==0?pageInt:pageInt+1;
		pageJson.put("newTotalPages", totalPages);
		pageJson.put("content", galleryJsonArray);
		return pageJson;
	}

}
