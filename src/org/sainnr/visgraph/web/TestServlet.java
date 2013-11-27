/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sainnr.visgraph.web;

import org.sainnr.visgraph.export.Export2JIT;
import org.sainnr.webparser.node.NodeManager;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Владимир
 */
public class TestServlet extends HttpServlet {
    @Resource(name = "MysqlGaRoutes")
    private DataSource mysqlGaRoutes;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");

//            Node newNode = NodeManager.getNodeById(87);
//            out.println("<h5>Node with id = 87: "
//                    + newNode.getUrl() + " "
//                    + newNode.getAdjacencies().toString() + "</h1>");

//            int i = 0;
////            for (Iterator it = getNodes(0, 20).entrySet().iterator(); it.hasNext();) {
//            for (Node node : NodeManager.getAllNodes()) {
//                out.println("Node: [" + node.getId() + "] "
//                        + node.getUrl()
//                        + " (" + node.getAdjacencies().toString() + ")<br/>");
//                i++;
//                if (i > 100){
//                    break;
//                }
//            }
            Export2JIT exporter = new Export2JIT();
            out.println(exporter.exportNodes(NodeManager.getAllNodes()));

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

//    private HashMap getNodes(int start, int end) {
//        String query = "select id, url from nodes limit ?, ?";
//        HashMap<Integer, String> resMap = new HashMap<Integer, String>();
//
//        try {
//            Connection conn = mysqlGaRoutes.getConnection();
//            PreparedStatement prst = conn.prepareStatement(query);
//            prst.setInt(1, start);
//            prst.setInt(2, end);
//            ResultSet rs = prst.executeQuery();
//
//            while(rs.next()){
//                resMap.put(rs.getInt("id"), rs.getString("url"));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return resMap;
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
