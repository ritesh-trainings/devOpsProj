/**
 * 
 */
package devOpsProj;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.controller.CalcSumServlet;

import junit.framework.TestCase;

/**
 * @author riteshmukim
 *
 */
public class calcSumServletTest extends TestCase {

	private CalcSumServlet calcSumServlet = new CalcSumServlet();

	HttpServletRequest request = Mockito.spy(HttpServletRequest.class);
	HttpServletResponse response = Mockito.spy(HttpServletResponse.class);
	RequestDispatcher rd = Mockito.spy(RequestDispatcher.class);
	StringWriter stringWriter;
	PrintWriter writer;

	protected void setUp() throws Exception {

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testIntInt() throws Exception {

		Mockito.when(request.getParameter("value1")).thenReturn("1");
		Mockito.when(request.getParameter("value2")).thenReturn("2");

		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
		Mockito.when(response.getWriter()).thenReturn(writer);
		Mockito.when(request.getRequestDispatcher("")).thenReturn(rd);

		calcSumServlet.doPost(request, response);

		writer.flush(); // it may not have been flushed yet...
		assertTrue(stringWriter.toString().contains("3"));
	}
	@Test
	public void testString() throws Exception {

		Mockito.when(request.getParameter("value1")).thenReturn("dd");
		Mockito.when(request.getParameter("value2")).thenReturn("fff");

		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
		Mockito.when(response.getWriter()).thenReturn(writer);
		Mockito.when(request.getRequestDispatcher("")).thenReturn(rd);

		calcSumServlet.doPost(request, response);

		writer.flush(); // it may not have been flushed yet...
		assertTrue(stringWriter.toString().contains("Error"));
	}
	
}
