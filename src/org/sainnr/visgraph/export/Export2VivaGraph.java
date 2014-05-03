/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sainnr.visgraph.export;

import java.util.HashSet;
import org.sainnr.webparser.node.Node;

/**
 *
 * @author Владимир
 */
public class Export2VivaGraph implements ExportFormat {

    @Override
    public String exportNodes(HashSet<Node> nodes) {
        StringBuilder jsonNodes = new StringBuilder();
        StringBuilder jsonLinks = new StringBuilder();
        jsonNodes.append("{\"nodes\":[");
        jsonLinks.append("\"links\":[");
        
        int i = 1;
        for (Node node : nodes){
            jsonNodes.append("{\"id\": \"").append(node.getId()).append("\", ");
            jsonNodes.append(" \"data\": \"").append(node.getUrl().replace("\'", "")).append("\"}");

            int j = 1;
            for (Integer adj : node.getAdjacencies()){
                jsonLinks.append("{\"fromId\": \"").append(node.getId()).append("\", ");
                jsonLinks.append(" \"toId\": \"").append(adj).append("\", ");
                jsonLinks.append(" \"data\": \"").append("some data").append("\"}");
                if (j < node.getAdjacencies().size()){
                    jsonLinks.append(", ");
                }
                j++;
            }
            if (i < nodes.size()){
                jsonNodes.append(", ");
                if (j != 1) jsonLinks.append(", ");
            }
            i++;
        }
        jsonNodes.append("],");
        jsonLinks.append("]}");
        return jsonNodes.append(jsonLinks).toString();
    }
    
    
}
