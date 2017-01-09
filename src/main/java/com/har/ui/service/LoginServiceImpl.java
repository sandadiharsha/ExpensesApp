package com.har.ui.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.har.ui.model.LoginDTO;

public class LoginServiceImpl implements LoginService {
	final private static Map<String, String> users = new HashMap<>();
	static {

		users.put("TEST", "Test");
		users.put("HSANDADI", "Harsha");
	}

	@Override
	public LoginDTO findLoginUser(String userName, String password) {

		// TODO Auto-generated method stub
		return getLogin(userName, password);
	}

	private LoginDTO getLogin(final String userName, final String pwd) {
		List<LoginDTO> securityUsers = getListOfLoginUsers();
		if (userName != null && pwd != null && securityUsers != null && !securityUsers.isEmpty()) {
			for (LoginDTO user : securityUsers) {
				if (userName.equalsIgnoreCase(user.getUserName()) && pwd.equals(user.getPassWord()))
					return user;
			}

		}
		return null;
	}

	private List<LoginDTO> getListOfLoginUsers() {
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		JSONParser parser = new JSONParser();
		try {
			String path = getPath("securityUsers.json");

			Object obj = parser.parse(new FileReader(path));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray msg = (JSONArray) jsonObject.get("Security_users");
			Iterator<JSONObject> iterator = msg.iterator();
			while (iterator.hasNext()) {
				JSONObject record = iterator.next();
				String userName = (String) record.get("userName");
				String password = (String) record.get("passWord");
				LoginDTO dto = new LoginDTO(userName, password);
				list.add(dto);
			}
		}catch(UnsupportedEncodingException uo){
			
		}catch(FileNotFoundException f){
			
		}catch(IOException ie){
			
		}catch(ParseException p){
			
		}
		finally{
			
		}
		return list;
	}

	public String getPath(final String usersJson) throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes");
		fullPath = pathArr[0];
		String reponsePath = "";
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "json" + File.separator + usersJson;
		return reponsePath;
	}

}
