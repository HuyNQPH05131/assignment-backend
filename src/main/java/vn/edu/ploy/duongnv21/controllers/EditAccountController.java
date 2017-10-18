/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: EditAccountController.java
 *== Created at: Oct 18, 2017 11:01:58 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.controllers
 */
package vn.edu.ploy.duongnv21.controllers;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.ploy.duongnv21.common.CommonConst;
import vn.edu.ploy.duongnv21.model.Account;

/**
 * Assignment Demo -> EditAccountController
 *
 * @author duongnguyen
 */
public class EditAccountController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = 7665821590421676631L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAccountController() {
		super();
	}

	/**
	 * @see GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		// TODO
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set encoding
		request.setCharacterEncoding(CommonConst.REQEUST_CHARACTER_ENCODING_UTF8);

		// Get logged in account from session
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute(CommonConst.SESSION_ATTRIBUTE_ACCOUNT);

		// Check logged in account
		if (account == null) {
			// Return to login page
			response.sendRedirect(request.getContextPath() + CommonConst.AUTHETICATE_LOGIN_PATH);
			return;
		}

		// TODO

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext()
														.getRequestDispatcher("/views/category/list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set encoding
		request.setCharacterEncoding(CommonConst.REQEUST_CHARACTER_ENCODING_UTF8);

		// Get logged in account from session
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute(CommonConst.SESSION_ATTRIBUTE_ACCOUNT);

		// Check logged in account
		if (account == null) {
			// Return to login page
			response.sendRedirect(request.getContextPath() + CommonConst.AUTHETICATE_LOGIN_PATH);
			return;
		}

		// TODO

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext()
														.getRequestDispatcher("/views/category/list.jsp");
		dispatcher.forward(request, response);
	}
}
