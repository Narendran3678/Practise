package com.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		StringBuilder sb = new StringBuilder();
		String uploadPath = "E:\\Eclipse_Workspace";
		try 
		{
			List<FileItem> formItems = upload.parseRequest(request);
			for(FileItem item:formItems)
			{
				sb.append(item.getFieldName()+"-"+item.getName()+"-"+item.getSize()).append("\n");
				System.out.println(item.getFieldName()+"-"+item.getName()+"-"+item.getSize()+"-"+uploadPath);
				File file = new File(uploadPath+File.separator+item.getName());
				item.write(file);
			}
			
			response.getWriter().append("Served at: ").append(request.getContextPath()+"->").append(sb);
		} 
		catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
