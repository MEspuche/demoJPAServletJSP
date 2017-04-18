package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Adresse;
import metier.Contact;
import service.IService;
import service.Service;

/**
 * Servlet implementation class MaWServletAjouterContact
 */
@WebServlet("/MaServletAjouterContact")
public class MaServletAjouterContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IService is = new Service();
	  /**
     * @see HttpServlet#HttpServlet()
     */
    public MaServletAjouterContact() {
        super();
        // TODO Auto-generated constructor stub
    }	


	
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String lenom = request.getParameter("nom");
		String leprenom = request.getParameter("prenom");
		String lemail = request.getParameter("email");
		String ladresse = request.getParameter("numrue");
		String lecodepostal = request.getParameter("codepostal");
		String laville = request.getParameter("ville");
		Contact c = new Contact();
		c.setNom(lenom);
		c.setPrenom(leprenom);
		c.setEmail(lemail);
		Adresse a = new Adresse();
		a.setNumRue(ladresse);
		a.setCodePostal(lecodepostal);
		a.setVille(laville);
		
		
		is.ajouterContactAdresse(c, a);
		
		request.setAttribute("lenom", lenom);
		request.setAttribute("leprenom", leprenom);
		request.setAttribute("lemail", lemail);
		request.setAttribute("ladresse", ladresse);
		request.setAttribute("lecodepostal", lecodepostal);
		request.setAttribute("laville", laville);
		
		request.getRequestDispatcher("/ajouterContactAdresse.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);  
		
	
	}

}
