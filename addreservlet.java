package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.addremod;

import services.addreservice;


/**
 * Servlet implementation class addreservlet
 */
@WebServlet("/addreservlet")
public class addreservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addreservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addremod am=new addremod();
		addreservice as=new addreservice();
		
		String operation=request.getParameter("operation");
		if(operation.equals("SaveReminder"))
		{
			
			String title=request.getParameter("title");
			String desc=request.getParameter("description");
			String date=request.getParameter("date");
			am.setTitle(title);
			am.setDesc(desc);
			am.setDate(date);
			
			int a=as.insert(am);
			if(a!=0)
			{
				response.sendRedirect("view.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("index.jsp?msg=b");	
			}	
			/*try{
				as.senMail(am);
			}
			catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			*/
		}
		else if(operation.equals("Update"))
		{
			
			String t=request.getParameter("title");
			String de=request.getParameter("description");
			String da=request.getParameter("date");		
			am.setTitle(t);
			am.setDesc(de);
			am.setDate(da);
			int id=Integer.parseInt(request.getParameter("id"));
			am.setId(id);
			as.updateRegisration(am);
			response.sendRedirect("view.jsp?msg=a");
			}
		else if(operation.equals("Delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			as.deleteRegistration(id);
			response.sendRedirect("view.jsp?msgb");
		}
		
	}
	
	

}
