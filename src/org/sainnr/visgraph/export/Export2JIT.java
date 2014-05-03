/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sainnr.visgraph.export;

import java.net.URLEncoder;
import java.util.HashSet;
import org.sainnr.webparser.node.Node;

/**
 *
 * @author Владимир
 */
public class Export2JIT implements ExportFormat {

    @Override
    public String exportNodes(HashSet<Node> nodes) {
        StringBuilder json = new StringBuilder();
        json.append('[');
        
        int i = 1;
        for (Node node : nodes){
            json.append("{\"id\": \"").append(node.getId()).append("\", ");
/*            if (node.getId() == 4){
                json.append(" \"name\": \"").append(node.getUrl()).append(" (10)\", ");
                json.append(" \"data\": {\"$color\": \"#aa4400\", \"$type\": \"circle\"}, ");
            } 
            else if (node.getId() == 8){
                json.append(" \"name\": \"").append(node.getUrl()).append(" (15)\", ");
                json.append(" \"data\": {\"$color\": \"#aa6600\", \"$type\": \"circle\"}, ");
            } 
            else if ( node.getId() == 9 || node.getId() == 10){
                json.append(" \"name\": \"").append(node.getUrl()).append(" (0)\", ");
                json.append(" \"data\": {\"$color\": \"#aa0000\", \"$type\": \"circle\"}, ");
            }
            else {
                json.append(" \"name\": \"").append(node.getUrl()).append(" (" + (100-node.getId()*9) + ")\", ");
                json.append(" \"data\": {\"$color\": \"#" + (node.getId()*9) + "aa00\", \"$type\": \"circle\"}, ");
            }
*/
            json.append(" \"name\": \"").append(node.getUrl().replace("\'", "")).append("\", ");
            json.append(" \"data\": {\"$color\": \"#00cc00\", \"$type\": \"circle\"}, ");
            json.append(" \"adjacencies\": [");
            
            int j = 1;
            for (Integer adj : node.getAdjacencies()){
                json.append("{\"nodeTo\": \"").append(adj).append("\", ");
                json.append(" \"nodeFrom\": \"").append(node.getId()).append("\", ");
                json.append(" \"data\": {} } ");
                if (j != node.getAdjacencies().size()) json.append(", ");
                j++;
            }
            json.append("]} ");
            if (i != nodes.size()) json.append(", ");
            i++;
        }
        json.append(']');
        return json.toString();
    }
    
    
}
