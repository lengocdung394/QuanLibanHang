
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DungGa2134
 */
public class Model_Menu {

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public MenuType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MenuType type) {
        this.type = type;
    }
    
    
    public Model_Menu(){
        
    }
    
   
    private String icon;
    private String name;
    
    private MenuType type;
    
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/icon/" + icon +".png"));
    }
    
    public static enum MenuType{
        TITLE, MENU, EMPTY
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    
    
    
}
