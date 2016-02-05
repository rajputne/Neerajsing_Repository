import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
public class Part4 extends HttpServlet  
{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        Map parameter=request.getParameterMap();
        Set set = parameter.entrySet();
        Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)iterator.next();
                String key=entry.getKey();
                String[] value=entry.getValue();
                out.println("Key is "+key+"<br>");
                    if(value.length>1){    
                        for (int i = 0; i < value.length; i++) {
                            out.println("<li>"+ value[i].toString() + "</li>");
                        }
                    }else
                            out.println("Value is "+value[0].toString()+"<br>");
 
                    out.println("-------------------<br>");
            }
 
        out.close();    
    }
}