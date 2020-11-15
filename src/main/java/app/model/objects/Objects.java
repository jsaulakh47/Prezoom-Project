package app.model.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import app.interfaces.ObjectsI;
import app.model.attributes.XPosition;
import app.model.attributes.YPosition;
import app.model.attributes.Attributes;

public abstract class  Objects implements ObjectsI {
    private List<Attributes> attributes;

    private static int count = 1;
    private int id;

    public Objects(String x, String y) {
        attributes = new ArrayList<Attributes>();
		addAttribute(new XPosition(x));
		addAttribute(new YPosition(y));
        id = count++;
    }

    public int getId() {
        return id;
    }


    protected void addAttribute(Attributes attribute) {
        this.attributes.add(attribute);
    }

    public Map<String,String> getAttributes()
    {
       Map<String,String> map = new HashMap<String,String>(); 
      for (Attributes attribute : attributes)
      {
               map.put(attribute.getLabel(),attribute.get());
      }
      return map;
   }
}