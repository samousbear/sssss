package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.User;

import service.ServiceFactory;




/**
 * Servlet implementation class Upload
 */
@WebServlet("/userLoad.do")
public class UserLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if(method.equals("add")){
			add(request,response);
		}else if("getList".equals(method)){
			getList(request,response);
		}else if("findOne".equals(method)){
			findOne(request,response);
		}else if("update".equals(method)){
			update(request,response);
		}else if("del".equals(method)){
			del(request,response);
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 删除
		String uid = request.getParameter("uid");
		User u = ServiceFactory.getUserService().getUserByUid(Integer.parseInt(uid));
		String photoPath = u.getUphoto();
		File f = new File(photoPath);
		
		if(f.exists()){
			f.delete();
		}
		ServiceFactory.getUserService().delUser(Integer.parseInt(uid));
		response.sendRedirect("userLoad.do?method=getList");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// 修改
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		User u = new User();
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					if(item.getFieldName().equals("uname")){
						String uname = item.getString("utf-8");
						u.setUname(uname);
					}else if(item.getFieldName().equals("uid")){
						String uid = item.getString("utf-8");
						u.setUid(Integer.parseInt(uid));
					}else if(item.getFieldName().equals("upwd")){
						String upwd = item.getString("utf-8");
						u.setUpwd(upwd);
					}else if(item.getFieldName().equals("urole")){
						String urole = item.getString("utf-8");
						u.setUrole(urole);
					}else if(item.getFieldName().equals("ustate")){
						String ustate = item.getString("utf-8");
						u.setUstate(ustate);
					}
				}else{
					String path = "F:/abc";
					String fileName = item.getName();

					String hz = fileName.substring(fileName.lastIndexOf("."));
					String qz = String.valueOf(new Date().getTime());
					u.setUphoto("F:/abc"+File.separator+qz+hz);
					File file1 = new File("F:/abc"+File.separator+qz+hz);
					item.write(file1);
				}
			}
			User temp = ServiceFactory.getUserService().getUserByUid(u.getUid());
			String path = temp.getUphoto();
			
			File file2 = new File(path);
			if(file2.exists()){
				file2.delete();
			}
			//调用方法
			ServiceFactory.getUserService().updateUser(u);
			//跳转页面
			response.sendRedirect("userLoad.do?method=getList");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("uid");
		User u = ServiceFactory.getUserService().getUserByUid(Integer.parseInt(uid));
		request.setAttribute("user", u);
		request.getRequestDispatcher("userEdit.jsp").forward(request, response);
	}

	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> user = ServiceFactory.getUserService().GetAllUsers();
		request.setAttribute("user", user);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 页面获取值
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		//获取上传文件
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		User user = new User();
		
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					if(item.getFieldName().equals("uname")){
						user.setUname(item.getString("utf-8"));//给用户名赋值
						
					}else if(item.getFieldName().equals("upwd")){
						user.setUpwd(item.getString());
					}
				}else{
					String path = "F:/abc";
					String fileName= item.getName();
					String hz = fileName.substring(fileName.lastIndexOf("."));
					String qz = String.valueOf(new Date().getTime());
					user.setUphoto("F:/abc"+File.separator+qz+hz);//给照片路径赋值
							File file = new File("F:/abc"+File.separator+qz+hz);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServiceFactory.getUserService().addUser(user);
		response.sendRedirect("userLoad.do?method=getList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
