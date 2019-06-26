package com.stx.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取上传信息
		Part part = request.getPart("file");
		//获取请求头信息
		String header = part.getHeader("content-disposition");
		System.out.println(header);
		//从请求头信息截取上传的文件名
		String fileName = header.substring(header.lastIndexOf("=")+2,header.length()-1);
		//取得文件目录物理路径
		String filePathForder = request.getServletContext().getRealPath("/upload");
		//能过文件目录物理路径创建file对象
		File file = new File(filePathForder);
		//判断该目录是否存在
		if(!file.exists()){
			file.mkdirs();//创建文件夹
		}
		//得到上传文件的物理路径
		String filePath = filePathForder +File.separator+ fileName;
		//将文件写入服务器
		part.write(filePath);
		request.getRequestDispatcher("UserServlet?fileName="+fileName).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
