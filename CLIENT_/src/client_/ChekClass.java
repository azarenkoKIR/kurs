/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_;

/**
 *
 * @author Benutzer
 */
public class ChekClass {
    public boolean DoubleChek(String str){
    try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
}
    
    public boolean InegerChek(String str){
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
