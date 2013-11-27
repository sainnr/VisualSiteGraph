<%@page import="org.sainnr.visgraph.export.ExportFormat" %>
<%@page import="org.sainnr.webparser.node.NodeManager" %>
<%@page import="org.sainnr.webparser.node.Node" %>
<%@page import="org.sainnr.visgraph.export.Export2VivaGraph" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    ExportFormat exporter = new Export2VivaGraph();

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script language="javascript" type="text/javascript" src="vivagraph.js"></script>
        
        <style type='text/css'>
            .node {
                background-color: #00a2ff;
                width: 50px;
                height: 50px;
                position: absolute;
            }
            .link {
                background-color: #dddddd;
                position: absolute;
            }
            
            #graph1{
                position: absolute;
                vertical-align:middle;
                width: 100%;
                height: 100%;
            }
            
            #setParams{
                position:absolute;
                background-color: #fff;
                top: 10px;
            }
            
            body {
                height: 100%;
                width: 100%;
                position: absolute;
                background-color: black;
            }
            canvas { 
                width: 100%;
                height: 100%;
            }
        </style>

    </head>
    <body>     
        <script language="javascript" type="text/javascript">
            //alert('<%=NodeManager.getAllNodes().size()%>');
            var json = '<%=exporter.exportNodes(NodeManager.getAllNodes())%>';
            var graph = Viva.Graph.serializer().loadFromJSON(json);
                
            var layout = Viva.Graph.Layout.forceDirected(graph, {
                springLength : 500,
                springCoeff : 0.00000001,
                dragCoeff : 0.009,
                gravity : -2.0,
                theta : 0.8
            });

            var graphics = Viva.Graph.View.svgGraphics();

            var renderer = Viva.Graph.View.renderer(graph,
                {
                    layout     : layout,
                    graphics   : graphics,
                    renderLinks : true,
                    prerender  : true
                });

            renderer.run();
        </script>
        <div id="setParams">
            <script language="javascript" type="text/javascript">
                function applyParams(){
                    layout['springLength'](parseFloat(document.getElementById("springLength").value));
                    layout['springCoeff'](parseFloat(document.getElementById("springCoeff").value));
                    //layout['dragCoeff'](parseFloat(document.getElementById("dragCoeff").value));
                    layout['gravity'](parseFloat(document.getElementById("gravity").value));
                    layout['theta'](parseFloat(document.getElementById("theta").value));

                    renderer.resume();
                }
            </script>
            <input id="springLength" type="text" value="500"><br/>
            <input id="springCoeff" type="text" value="0.00000001"><br/>
            <input id="dragCoeff" type="text" value="0.009"><br/>
            <input id="gravity" type="text" value="-2.0"><br/>
            <input id="theta" type="text" value="0.8"><br/>
            <button onclick="applyParams()">Apply</button>
        </div>
    </body>
</html>
