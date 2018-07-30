package com.ma.home;

import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}



public class App {
    public static boolean contains(Node root, int value) {
        if(root != null){
            if(value == root.value){
                return  true;
            }
            if(root.value >= root.right.value){
                root = root.right;
                contains(root, value);
            }else if(root.value <= root.left.value){
                root = root.left;
                contains(root, value);
            }
        }
        return false;
    }

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
        ByteArrayInputStream bf = new ByteArrayInputStream(xml.getBytes());
        Collection<String> list = new ArrayList<String>();
        NodeList elem = builder.parse(bf).getElementsByTagName("folder");
        
        return list;
    }
    
    

    public static void main(String[] args) throws Exception {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        System.out.println(contains(n2, 3));
    }
}
