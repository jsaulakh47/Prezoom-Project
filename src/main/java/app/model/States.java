package app.model;

public class States {
    private static int count = 1;
    private String height;
    private String  width;
    private int id;

    public States(){
        this.id = count++;
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

    

