
package com.josecuriel.megabloques.controller.index;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImagesView {

    
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            images.add("b" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
}
