/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import static xorj.Common.rand;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class GraphPanel extends javax.swing.JPanel {
    public static final int WIDTH=500;
    public static final int HEIGHT=5;
    public static final int VGAP=5;
    public static final int VSPC=HEIGHT+VGAP;
    private ArrayList<JPanel> bars= new ArrayList<JPanel>();
    
    Color colors[] = new Color[]{
        new Color(0xFF,0x33   ,0x33   ),
        new Color(0xFF,0xA5,0x11   ),
        new Color(0x11   ,0xFF,0x11   ),
        new Color(0x11   ,0xFF,0xCC),
        new Color(0x33   ,0x33   ,0xFF),
        new Color(0x66,0x33,0x99)
    };
    int icolor=0;
    
    /**
     * Creates new form GraphPanel
     */
    public GraphPanel() {
        initComponents();
        test();
    }

    private void clear(){
       removeAll();
       bars.clear();
    }
    
    private JPanel addBar(int x,int y,int length,       Color c){
        JPanel a=new JPanel();
        a.setLayout(new GridLayout(0,1));
        a.setSize(new Dimension(length,HEIGHT));
        a.setLocation(x+VGAP,y*VSPC);
        a.setBackground(c);
        add(a);
        bars.add(a);
        return a;
    }
    public void test(){
        /*JPanel bar=addBar(0,0,10, 0xFF,0,0);
        this.add(bar);
        JPanel bar2=addBar(0,1,200, 0,0XFF,0);
        this.add(bar2);
        this.invalidate();
        this.repaint();*/
        
    }
    public void renderList(ArrayList<FileBar> fbs){
        clear();
        int y=1;
        for(FileBar fb : fbs){
            render(fb,y);
            y++;
        }
        invalidate();
        repaint(); 
    }
    public void render(FileBar fb, int y){
        JPanel sub = addBar(fb.xselected,y,fb.wselected, colors[icolor].darker().darker());
        JPanel bar = addBar(fb.x,y,fb.width, colors[icolor].brighter().brighter());
        
        icolor=rand.nextInt(colors.length);
    }
    
    @Override
    public boolean isOptimizedDrawingEnabled(){
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}