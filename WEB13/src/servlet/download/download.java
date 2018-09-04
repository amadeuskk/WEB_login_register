package servlet.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class download
 */
public class download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename=request.getParameter("filename");
		// 服务器无法直接通过文件后缀知道文件类型，而是要通过文件的MIME类型去区分类型，以此来设置好response的属性
		response.setContentType(this.getServletContext().getMimeType(filename));
		// 告诉服务器文件不直接解析，而是以附件形式打开（下载）
		response.setHeader("Content-Disposition","attachment;filename="+filename);
		
		// 获取文件的绝对地址
		String path = this.getServletContext().getRealPath("WEB-INF/"+filename);
		ServletOutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(path);
		
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len=in.read(buffer))>0) {
			out.write(buffer,0,len);
		}
		
		in.close();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
