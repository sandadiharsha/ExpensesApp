/**
 * 
 */
package com.har.ui.service;

import com.har.ui.model.LoginDTO;

/**
 * @author hsandadi
 *
 */
public interface LoginService {
	public LoginDTO findLoginUser(final String userName,final String password);

}
