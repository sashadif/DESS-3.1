/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpresentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Ольга
 */
public class GraphTransition extends GraphElement{
    private static int height = 50;
    private static int width = 5;
    private int lineWidth;
    private Color color;

    /**
     * @return the height
     */
    public static int getHeight() {
        return height;
    }

    /**
     * @param aHeight the height to set
     */
    public static void setHeight(int aHeight) {
        height = aHeight;
    }

    /**
     * @return the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * @param aWidth the width to set
     */
    public static void setWidth(int aWidth) {
        width = aWidth;
    }
    private Rectangle2D graphElement=new Rectangle2D.Double(0,0, getWidth(), getHeight());;


    public GraphTransition(){
        lineWidth = 1;
        color = Color.BLACK;
    }
  
    @Override
    public void drawGraphElement(Graphics2D g2) {
        g2.setStroke(new BasicStroke(lineWidth));
        g2.setColor(color);
        g2.draw(graphElement);
        g2.fill(graphElement);
   }
   

    @Override
    public void setNewCoordinates(Point2D p){
        graphElement.setFrame(p.getX() - getWidth() / 2, p.getY() - getHeight() / 2, getWidth(), getHeight());
    }

   
    @Override
    public boolean isGraphElement(Point2D p){
        if (graphElement.contains(p) || new Line2D.Double(new Point2D.Double(graphElement.getMaxX(),graphElement.getMinY()),new Point2D.Double(graphElement.getMinX(),graphElement.getMaxY())).ptSegDist(p)<getWidth()*2) {
            return true;
        }
        return false;
    }

  
    @Override
    public Point2D getGraphElementCenter(){
        return new Point2D.Double(graphElement.getX() + getWidth() / 2, graphElement.getY() + getHeight() / 2);
    }

   
    @Override
    public String getType() {
        return graphElement.getClass().toString();
    }

    
    @Override
    public  int getBorder() {
        return getWidth();
    }


    public static int getHEIGHT() {
        return getHeight();
    }

    public static int getWIDTH() {
        return getWidth();
    }

    public Rectangle2D getGraphElement() {
        return graphElement;
    }

    public void setGraphElement(Rectangle2D graphElement) {
        this.graphElement = graphElement;
    }
    
    public void setLineWidth(int n) {
        lineWidth = n;
    }
    
    public void setActiveColor(Color c){
        color = c;
    }
}
