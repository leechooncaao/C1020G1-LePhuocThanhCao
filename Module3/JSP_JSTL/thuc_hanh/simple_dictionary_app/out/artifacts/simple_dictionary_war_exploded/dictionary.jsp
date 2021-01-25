<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dictionary</title>
</head>
<body>
    <%!
        Map<String, String> dic = new HashMap<>();
    %>
    <%
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String word = request.getParameter("data-input");
        String result = dic.get(word);

        if(result != null){
            out.println("word: " + word);
            out.print("<br/>");
            out.println("Result: " + result);
        }else
            out.println("Not found");
    %>
</body>
</html>
