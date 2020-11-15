package app.model;

public class States {

    private static int id = 1;
    // private String name;
    private String height;
    private String  width;

    public States(){
        id++;
        height = "720";
        width = "1080";
    }

    public int getId()
    {
        return id;
    }

    // public String getName()
    // {
    //     return name;
    // }

    public String getHeight()
    {
        return height;
    }

    public String getWidth()
    {
        return width;
    }
    
    public void addObject()

    {
        
    }

    public void deleteObject()
    {

    }
    
    public void editObject()
    {

    }
};

    

