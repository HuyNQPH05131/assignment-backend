/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: DeleteCategoryController.java
 *== Created at: Oct 18, 2017 11:02:14 PM
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

import org.apache.commons.lang3.StringUtils;

import vn.edu.ploy.duongnv21.common.CommonConst;
import vn.edu.ploy.duongnv21.dao.CategoryDao;
import vn.edu.ploy.duongnv21.model.Account;
import vn.edu.ploy.duongnv21.model.Category;

/**
 * Assignment Demo -> DeleteCategoryController
 *
 * @author duongnguyen
 */
public class DeleteCategoryController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = 1277738795502545075L;

	/** Category Data Accessing Object */
	private CategoryDao categoryDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCategoryController() {
		super();
	}

	/**
	 * @see GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		// Instance new DAO
		this.categoryDao = new CategoryDao();
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

		// Get parameters
		String id = request.getParameter("id");

		// Validate parameter
		if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {

			// Set exception
			request.setAttribute("exception", new Exception("Invalid input parameter: ID"));

			// Redirect to error page
			RequestDispatcher dispatcher = request.getServletContext()
															.getRequestDispatcher("/views/common/error.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// Find category
		Category category = this.categoryDao.getCategory(Integer.parseInt(id));

		// Set category into request
		request.setAttribute("category", category);

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext()
														.getRequestDispatcher("/views/category/delete.jsp");
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

		// Get parameters
		String id = request.getParameter("id");

		// Validate parameter
		if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {

			// Set exception
			request.setAttribute("exception", new Exception("Invalid input parameter: ID"));

			// Redirect to error page
			RequestDispatcher dispatcher = request.getServletContext()
															.getRequestDispatcher("/views/common/error.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// Delete category
		this.categoryDao.deleteCategory(Integer.parseInt(id));

		// Return to list categories screen
		response.sendRedirect(request.getContextPath() + "/list-categories");
	}
}
