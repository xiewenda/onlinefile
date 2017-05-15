package cn.flying.rest.onlinefile.apk.driver.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.flying.rest.onlinefile.apk.driver.AppVersionDao;
import cn.flying.rest.onlinefile.utils.BaseDaoHibernate;
import cn.flying.rest.onlinefile.utils.JdbcUtil;
/**
 * 手机端数据层实现类
 * @author liuwei
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public class AppVersionDaoImpl extends BaseDaoHibernate implements AppVersionDao {

	@SuppressWarnings("unchecked")
	public AppVersionDaoImpl(){
		super(AppVersionDaoImpl.class);
	}
	
	public boolean saveUpdateInfo(){
		return false;
	}

	public Map<String,Object> getAppLatestUpdateInfo() {
		Map<String,String> updateTips = new HashMap<String, String>();
		Map<String,Object> datas = new HashMap<String, Object>();
		PreparedStatement statement = null ;
		ResultSet rs = null ;
		Connection connection = null ;
		Session session = null ;
		String sql = "select * from app_update_info where id=(select max(id) from app_update_info)";
		try {
			session = getSession();
			connection = session.connection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			if(rs.next()){
				datas.put("id",String.valueOf(rs.getLong("id")));
				datas.put("appName",rs.getString("appName"));
				datas.put("appDescription",rs.getString("appDescription"));
				datas.put("packageName",rs.getString("packageName"));
				datas.put("versionCode",rs.getString("versionCode"));
				datas.put("versionName",rs.getString("versionName"));
				datas.put("forceUpdate",String.valueOf(rs.getBoolean("forceUpdate")));
				datas.put("autoUpdate",String.valueOf(rs.getLong("autoUpdate")));
				datas.put("updateTips",rs.getString("updateTips"));
				updateTips.put("updateTips", rs.getString("updateTips"));
				datas.put("updateTips",rs.getString("updateTips"));
				updateTips.put("updateTime", rs.getString("updateTime"));
				datas.put("apkFileId", rs.getString("apkFileId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, statement, connection) ;
		}
		return datas;
	}
	public boolean updateAppInfo() {
		// TODO Auto-generated method stub
		return false;
	}
}
