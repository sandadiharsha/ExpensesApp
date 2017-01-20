/**
 * 
 */
package com.har.ui.service;

import com.har.ui.model.LoginDTO;
import com.har.ui.model.Member;

/**
 * @author hsandadi
 *
 */
public interface LoginService {
	public LoginDTO findLoginUser(final String userName,final String password);
	public void saveCreateLoginUser(final LoginDTO dto);
	public void saveCreateMember(final Member member);

}
