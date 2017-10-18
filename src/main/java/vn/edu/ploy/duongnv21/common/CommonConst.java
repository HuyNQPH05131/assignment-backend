/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: CommonConst.java
 *== Created at: Oct 18, 2017 11:38:00 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.common
 */
package vn.edu.ploy.duongnv21.common;

/**
 * Assignment Demo -> Common Constant
 *
 * @author duongnguyen
 */
public final class CommonConst {

	/**
	 * Private Constructor to make sure class cannot instance
	 */
	private CommonConst() {
	}

	/** Session attribute: account */
	public static final String SESSION_ATTRIBUTE_ACCOUNT = "account";

	/** Authenticate: login path */
	public static final String AUTHETICATE_LOGIN_PATH = "/login";

	/** Authenticate: return path */
	public static final String AUTHETICATE_RETURN_PATH = "/";

	/** User type: admin */
	public static final String USER_TYPE_ADMIN = "admin";
}
