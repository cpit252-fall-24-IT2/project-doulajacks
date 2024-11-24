package org.example.vncpit252;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract  class SharedData  {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static String[] getArrStrings(int choise) throws IOException{
        String [] arr;
        String pathh = null ;
        switch (choise) {
            case 0 -> { pathh =".\\dialog.txt";
            }
            case 1 -> {pathh =".\\video.txt";
            }
            case 2 -> {pathh =".\\qustion.txt";
            }
            
        }
        
        try (FileReader fr = new FileReader(pathh,StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;

            
            while ((c = fr.read()) != -1) {
                content.append((char) c);
            }

            String fileContent = content.toString();
            arr = fileContent.split("\\|");
            
        }
        return arr;
    }
    
}
