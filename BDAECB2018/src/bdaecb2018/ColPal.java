/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author MBanegas
 */
public class ColPal {

    HashMap<String, Color> myMap = new HashMap<String, Color>();

    public ColPal(JTextPane textPane) {
        try {
            myMap.put("CREATE", Color.RED);
            myMap.put("DROP", Color.RED);
            myMap.put("SELECT", Color.RED);
            myMap.put("FROM", Color.RED);
            myMap.put("WHERE", Color.RED);
            myMap.put("AND", Color.RED);
            myMap.put("OR", Color.RED);
            myMap.put("GRANT", Color.RED);
            myMap.put("DATABASE", Color.RED);
            myMap.put("TO", Color.RED);
            myMap.put("INSERT", Color.RED);
            myMap.put("INTO", Color.RED);
            myMap.put("VALUES", Color.RED);
            myMap.put("TABLE", Color.RED);
            myMap.put("UPDATE", Color.RED);
            myMap.put("SET", Color.RED);
            myMap.put("DELETE", Color.RED);
            myMap.put("TRUNCATE", Color.RED);
            String text = textPane.getText();
            textPane.setText("");
            StyledDocument doc = textPane.getStyledDocument();
            Style style = textPane.addStyle("Red Style", null);
            StyleConstants.setForeground(style, Color.red);
            ArrayList<Chunk> chunks = getColorsBasedOnText(text, textPane);
            try {
                for (int i = 0; i < chunks.size(); i++) {                    
                    if (i==chunks.size()-1) {
                    doc.insertString(doc.getLength(), chunks.get(i).text + "", chunks.get(i).style);    
                    }else{
                    doc.insertString(doc.getLength(), chunks.get(i).text + " ", chunks.get(i).style);
                    }
                }                                    
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Chunk> getColorsBasedOnText(String text, JTextPane textPane) {
        ArrayList<Chunk> chunks = new ArrayList<Chunk>();
        for (String word : text.split(" ")) {
            Chunk chunk = new Chunk();
            chunk.text = word;
            Color color;
            if (myMap.containsKey(word)) {
                color = myMap.get(word);
            } else {
                color = Color.BLACK;
            }
            if (color != null) {
                chunk.style = textPane.addStyle("Style", null);
                StyleConstants.setForeground(chunk.style, color);
            }
            chunks.add(chunk);
        }
        return chunks;
    }

    private class Chunk {

        public String text;
        public Style style;
    }
}
