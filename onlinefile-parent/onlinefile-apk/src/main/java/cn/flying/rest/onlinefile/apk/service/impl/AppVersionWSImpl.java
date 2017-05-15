package cn.flying.rest.onlinefile.apk.service.impl;

import java.util.Map;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.flying.rest.onlinefile.apk.driver.AppVersionDao;
import cn.flying.rest.onlinefile.restInterface.AppVersionWS;
import cn.flying.rest.onlinefile.utils.BaseWS;

@Path("/appversion")
@Service
public class AppVersionWSImpl extends BaseWS implements AppVersionWS {
	
	@Autowired
	private AppVersionDao appVersionDao;
	
	public Map<String, Object> getAppLatestUpdateInfo() {
		Map<String, Object> datas = appVersionDao.getAppLatestUpdateInfo();
		if(datas.size()>0){
			if(null != datas.get("apkFileId")){
				datas.put("apkUrl", "http://nj02all01.baidupcs.com/file/09c56f80ceda223fdeac2a1f50d08d47?bkt=p3-0000a5292fef6ef8c06ed3254d28bf2242e1&fid=41851177-250528-650453827791946&time=1457602745&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-uN%2B7w93QAfw0S5RF1eMUuyisN4g%3D&to=nj2hb&fm=Nan,B,U,nc&sta_dx=14&sta_cs=0&sta_ft=apk&sta_ct=0&fm2=Nanjing02,B,U,nc&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=0000a5292fef6ef8c06ed3254d28bf2242e1&sl=75563087&expires=8h&rt=sh&r=720518159&mlogid=1617362586196741186&vuk=41851177&vbdid=1774218493&fin=fy");
			}
		}
		return datas;
	}
}
