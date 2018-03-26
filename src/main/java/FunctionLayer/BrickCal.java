/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Magnus West Madsen
 */
public class BrickCal {
    
    
    public static void calcualt(Order order) throws UniversalException {
        
        int height = order.getHeight();
        int length = order.getLength();
        int width = order.getWidth();
        int brick1 = 0;
        int brick2 = 0;
        int brick4 = 0;
        
        while(length >= 4) {
            
            switch (length % 4) {
                
                case 3: 
                    brick2 += (2 * height);
                    brick1 += (2 * height);
                    length -= 3;
                    break;
                
                case 2:
                    brick2 += (2 * height);
                    length -= 2;
                    break;
                
                case 1:
                    brick1 += (2 * height);
                    length -= 1;
                    break;
                
                case 0:
                    brick4 += (((length / 4)*2)* height);
                    length -= length;
                    break;
            }
        }
        
        width -= 4;
        
        while(width >= 4) {
            
            switch (width % 4) {
                
                case 3: 
                    brick2 += (2 * height);
                    brick1 += (2 * height);
                    length -= 3;
                    break;
                
                case 2:
                    brick2 += (2 * height);
                    length -= 2;
                    break;
                
                case 1:
                    brick1 += (2 * height);
                    length -= 1;
                    break;
                
                case 0:
                    brick4 += (((width / 4)*2)* height);
                    width -= width;
                    break;
            }
        }
        
        switch (length) {
            case 3:
                brick2 += (1 * height);
                brick1 += (1 * height);
                length -= 3;
                break;
                
                case 2:
                    brick2 += (1 * height);
                    length -= 2;
                    break;
                
                case 1:
                    brick1 += (1 * height);
                    length -= 1;
                    break;
        }
        
        switch (width) {
            case 3:
                brick2 += (1 * height);
                brick1 += (1 * height);
                width -= 3;
                break;
                
                case 2:
                    brick2 += (1 * height);
                    width -= 2;
                    break;
                
                case 1:
                    brick1 += (1 * height);
                    width -= 1;
                    break;
        }
        
        
        if (length + width == 0) {
            
            order.setBrick1(brick1);
            order.setBrick2(brick2);
            order.setBrick4(brick4);
        }
        else {
            
            throw new UniversalException("Error in Brick calculation");
        }
    }
    
    
    
}
