package com.har.ui.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.har.ui.model.LoginDTO;
import com.har.ui.model.Member;
import com.har.util.ExpensesUtil;

public class LoginServiceImpl implements LoginService {

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
		} catch (UnsupportedEncodingException uo) {

		} catch (FileNotFoundException f) {

		} catch (IOException ie) {

		} catch (ParseException p) {

		} finally {

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

	@SuppressWarnings("unchecked")
	public void saveCreateLoginUser(final LoginDTO dto) {

		JSONObject obj = new JSONObject();
		obj.put("userName", dto.getUserName());
		obj.put("passWord", dto.getPassWord());
		JSONArray msg = new JSONArray();
		List<LoginDTO> list = getListOfLoginUsers();
		for (LoginDTO dao : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userName", dao.getUserName());
			jsonObject.put("passWord", dao.getPassWord());
			msg.add(jsonObject);
		}
		msg.add(obj);
		JSONObject obj1 = new JSONObject();
		obj1.put("Security_users", msg);
		try {

			FileWriter file = new FileWriter(getPath("securityUsers.json"));
			file.write(obj1.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void saveCreateMember(final Member member) {
		JSONObject members = new JSONObject();
		JSONArray memberList = new JSONArray();
		if (member != null) {
			JSONObject memberJSON = new JSONObject();
			JSONArray personList = new JSONArray();
			JSONObject person = new JSONObject();
			person.put("prefix", member.getPrefix());
			person.put("firstName", member.getFirstName());
			person.put("middleName", member.getMiddleName());
			person.put("lastName", member.getLastName());
			person.put("suffix", member.getSuffix());
			person.put("dateOfBirth", ExpensesUtil.getStringFromDate(member.getDateOfBirth()));
			person.put("gender", member.getGender());
			personList.add(person);
			memberJSON.put("person", personList);
			JSONObject securityUser = new JSONObject();
			JSONArray securityUserList = new JSONArray();
			securityUser.put("userName", member.getDto().getUserName());
			securityUserList.add(securityUser);
			memberJSON.put("securityUser", securityUserList);
			memberList.add(memberJSON);
		}
		List<Member> membersFromDb= getListOfMembers();
		if(!ExpensesUtil.isEmptyList(membersFromDb)){
			for(Member dao:membersFromDb){
				JSONObject memberJSON = new JSONObject();
				JSONArray personList = new JSONArray();
				JSONObject person = new JSONObject();
				person.put("prefix", dao.getPrefix());
				person.put("firstName", dao.getFirstName());
				person.put("middleName", dao.getMiddleName());
				person.put("lastName", dao.getLastName());
				person.put("suffix", dao.getSuffix());
				person.put("dateOfBirth", ExpensesUtil.getStringFromDate(dao.getDateOfBirth()));
				person.put("gender", dao.getGender());
				personList.add(person);
				memberJSON.put("person", personList);
				JSONObject securityUser = new JSONObject();
				JSONArray securityUserList = new JSONArray();
				securityUser.put("userName", dao.getDto().getUserName());
				securityUserList.add(securityUser);
				memberJSON.put("securityUser", securityUserList);
				memberList.add(memberJSON);
			}
		}
		members.put("members", memberList);
		try {

			FileWriter file = new FileWriter(getPath("members.json"));
			file.write(members.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Member> getListOfMembers() {
		List<Member> members = new ArrayList<Member>();
		try {
			JSONParser parser = new JSONParser();
			String path = getPath("members.json");

			Object obj = parser.parse(new FileReader(path));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray memberList = (JSONArray) jsonObject.get("members");
			if (!ExpensesUtil.isEmptyList(memberList)) {
				Iterator<JSONObject> iterator = memberList.iterator();
				while (iterator.hasNext()) {
					JSONObject record = iterator.next();
					JSONArray persons = (JSONArray) record.get("person");
					Member member = null;
					if (!ExpensesUtil.isEmptyList(persons)) {
						Iterator<JSONObject> ite = persons.iterator();
						while (ite.hasNext()) {
							JSONObject person = ite.next();
							String prefix = (String) person.get("prefix");
							String firstName = (String) person.get("firstName");
							String middleName = (String) person.get("middleName");
							String lastName = (String) person.get("lastName");
							String suffix = (String) person.get("suffix");
							Date dateOfBirth = ExpensesUtil.getDateFromString((String) person.get("dateOfBirth"));
							String gender = (String) person.get("gender");
							member = new Member(prefix, firstName, middleName, lastName, suffix, dateOfBirth, gender,
									null);

						}
					}
					JSONArray users = (JSONArray) record.get("securityUser");
					if (!ExpensesUtil.isEmptyList(users)) {
						Iterator<JSONObject> ite = users.iterator();
						while (ite.hasNext()) {
							JSONObject user = ite.next();
							String userName = (String) user.get("userName");
							LoginDTO dto = new LoginDTO(userName, null);
							member.setDto(dto);
						}
					}
					members.add(member);
				}
			}
		} catch (UnsupportedEncodingException uo) {

		} catch (FileNotFoundException f) {

		} catch (IOException ie) {

		} catch (ParseException p) {

		} finally {

		}
		return members;
	}

}
