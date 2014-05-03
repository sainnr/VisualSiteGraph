<%-- 
    Document   : index
    Created on : Mar 20, 2012, 7:34:30 AM
    Author     : Владимир
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="org.sainnr.webparser.node.NodeManager" %>
<%@page import="org.sainnr.webparser.node.Node" %>
<%@page import="org.sainnr.visgraph.export.Export2JIT" %>
<%
    Export2JIT exporter = new Export2JIT();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link type="text/css" href="ForceDirected.css" rel="stylesheet" />
        <link type="text/css" href="base.css" rel="stylesheet" />

        <script language="javascript" type="text/javascript" src="jit-yc.js"></script>
        <script language="javascript" type="text/javascript" src="graph.js"></script>
        <script language="javascript" type="text/javascript">
            var json = '<%=exporter.exportNodes(NodeManager.getAllNodes())%>';
        </script>

    </head>
    <body onload="init(json);">     
        
        <div id="container">
            
            <div id="left-container">
                <div id="id-list"></div>
            </div>

            <div id="center-container">
                <div id="infovis"></div>    
            </div>

            <div id="right-container">
                <div id="inner-details"></div>
            </div>

            <div id="log"></div>
        </div>
    </body>
</html>
