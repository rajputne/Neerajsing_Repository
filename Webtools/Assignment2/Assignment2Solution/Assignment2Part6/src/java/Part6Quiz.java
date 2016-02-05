
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Part6Quiz extends HttpServlet {

    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendPage1(response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String page = request.getParameter("page");
        answer1 = request.getParameter("ans");
        answer2 = request.getParameter("ans2");
        answer3 = request.getParameter("ans3");
        answer4 = request.getParameter("ans4");
        answer5 = request.getParameter("ans5");

        //PrintWriter out = response.getWriter();
        //out.println(answer1);
        //out.println(answer2);
        //out.println(answer3);
        //out.println(answer4);
        //out.println(answer5);
        if (page == null) {
            sendPage1(response);
            return;
        }

        if (page.equals("1")) {
            sendPage2(response);
        } else if (page.equals("2")) {
            sendPage3(response);
        } else if (page.equals("3")) {
            sendPage4(response);
        } else if (page.equals("4")) {
            sendPage5(response);
        } else if (page.equals("5")) {
            displayValues(response);
        }
    }

    void sendPage1(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 1</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Question 1</H2>");
        out.println("Please answer 1st question.<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=1>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD><label for='Question1'/> 1. My greatest challenge is that... &nbsp;</TD></TR>");

        out.println("<TR><TD><input type=radio name=ans value=Ans1>My life is too busy, scattered, chaotic.</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans\" value=\"Ans2\">I get trapped in strong emotions.</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans\" value=\"Ans3\">I feel bored and stuck in the mundane.</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans\" value=\"Ans4\">My life lacks meaning.</TD></TR>");

        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Next></TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    void sendPage2(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Question 2</H2>");
        out.println("Please answer 2nd question.<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans VALUE=\"" + answer1 + "\"></TD>");
        out.println("<TD>2. I would best describe the pain in my life right now as a feeling of ... &nbsp;</TD></TR>");

        out.println("<TR><TD><input type=radio name=ans2 value=Ans1>negativity and limitation</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans2\" value=\"Ans2\">insecurity</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans2\" value=\"Ans3\">unhappiness</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans2\" value=\"Ans4\">being unfulfilled</TD></TR>");

        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Next></TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    void sendPage3(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 3</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Question 3</H2>");
        out.println("Please answer 3rd question.<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=3>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans VALUE=\"" + answer1 + "\"></TD>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans2 VALUE=\"" + answer2 + "\"></TD>");
        out.println("<TD>3. I am working on ... &nbsp;</TD></TR>");

        out.println("<TR><TD><input type=radio name=ans3 value=Ans1>serving others</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans3\" value=\"Ans2\">accepting myself</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans3\" value=\"Ans3\">expressing myself</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans3\" value=\"Ans4\">improving myself</TD></TR>");

        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Next></TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    void sendPage4(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 4</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Question 4</H2>");
        out.println("Please answer 4th question.<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=4>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans VALUE=\"" + answer1 + "\"></TD>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans2 VALUE=\"" + answer2 + "\"></TD>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans3 VALUE=\"" + answer3 + "\"></TD>");
        out.println("<TD>4. I usually approach problems and life ... &nbsp;</TD></TR>");

        out.println("<TR><TD><input type=radio name=ans4 value=Ans1>intuitively</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans4\" value=\"Ans2\">with action</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans4\" value=\"Ans3\">intellectually</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans4\" value=\"Ans4\">with feelings</TD></TR>");

        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Next></TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    void sendPage5(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 5</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Question 5</H2>");
        out.println("Please answer 5th question.<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=5>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans VALUE=\"" + answer1 + "\"></TD>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans2 VALUE=\"" + answer2 + "\"></TD>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans3 VALUE=\"" + answer3 + "\"></TD>");
        out.println("<TD><INPUT TYPE=HIDDEN NAME=ans4 VALUE=\"" + answer4 + "\"></TD>");
        out.println("<TD>5. I most value ... &nbsp;</TD></TR>");

        out.println("<TR><TD><input type=radio name=ans5 value=Ans1>purpose and contribution</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans5\" value=\"Ans2\">peace of mind, order</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans5\" value=\"Ans3\">understanding</TD></TR>");
        out.println("<TR><TD><input type=\"radio\" name=\"ans5\" value=\"Ans4\">love and connection</TD></TR>");

        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Next></TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    void displayValues(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 3</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 3 (Finish)</H2>");
        out.println("Enjoy the results!!.<BR><BR>");
        out.println("<TABLE>");

        out.println("<TR>");
        out.println("<TD>Answer1: &nbsp;</TD>");
        out.println("<TD>" + answer1 + "</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>Answer2: &nbsp;</TD>");
        out.println("<TD>" + answer2 + "</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>Answer3: &nbsp;</TD>");
        out.println("<TD>" + answer3 + "</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>Answer4: &nbsp;</TD>");
        out.println("<TD>" + answer4 + "</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>Answer4: &nbsp;</TD>");
        out.println("<TD>" + answer5 + "</TD>");
        out.println("</TR>");

        out.println("</TR></TABLE></CENTER>");
        out.println("</BODY></HTML>");
    }
}
