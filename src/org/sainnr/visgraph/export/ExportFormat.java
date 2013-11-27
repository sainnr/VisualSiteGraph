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
public interface ExportFormat {
    public String exportNodes(HashSet<Node> nodes);
}
