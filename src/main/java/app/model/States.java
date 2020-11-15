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

    public double getHeight()
    {
        return height;
    }

    public double getWidth()
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

    

