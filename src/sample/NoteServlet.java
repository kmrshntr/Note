package sample;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

/**
 * Servlet implementation class Sample
 */
@WebServlet(name="Note",urlPatterns = {"/new","/edit","/show", "/"})
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final String NOTE_FILE = "/Users/shintaro/Desktop/note.yml";

	/**
	 * Default constructor.
	 */
	public NoteServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userPath = request.getServletPath();
		RequestDispatcher rDispatcher = null;
		System.out.println(userPath);
		if ("/show".equals(userPath) || "/".equals(userPath)) {
			try {
				YamlReader reader = new YamlReader(new FileReader(NOTE_FILE));
				NoteBean note = reader.read(NoteBean.class);
				request.setAttribute("noteBean", note);
				rDispatcher = request
						.getRequestDispatcher("/show.jsp");
			} catch (java.io.FileNotFoundException e) {
				rDispatcher = request
						.getRequestDispatcher("/new.jsp");
			}
		}else if("/edit".equals(userPath)){
			YamlReader reader = new YamlReader(new FileReader(NOTE_FILE));
			NoteBean note = reader.read(NoteBean.class);
			request.setAttribute("noteBean", note);
			rDispatcher = request
					.getRequestDispatcher("/edit.jsp");
		}else if("/new".equals(userPath)){
			rDispatcher = request
					.getRequestDispatcher("/new.jsp");			
		}
		rDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NoteBean note = new NoteBean();
		note.setTitle(request.getParameter("title"));
		note.setBody(request.getParameter("body"));
		YamlWriter writer = new YamlWriter(new FileWriter(NOTE_FILE));
		writer.write(note);
		writer.close();
		RequestDispatcher rDispatcher = request
				.getRequestDispatcher("/show.jsp");
		request.setAttribute("noteBean", note);
		rDispatcher.forward(request, response);

	}

}
