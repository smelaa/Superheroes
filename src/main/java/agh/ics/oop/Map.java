package agh.ics.oop;

import java.util.HashMap;
import java.util.Random;

public class Map {
    private HashMap<Vector2d, IField> fields=new HashMap<>();

    public Map(Integer height, Integer width, Integer riverMinX, Integer riverMaxX) {
        for (int i=0; i<width;i++){
            for (int j=0;j<height;j++){
                fields.put(new Vector2d(i,j), new RegularField());
            }
        }
        generateRiver(riverMinX, riverMaxX, height);
        //generuj inne pola DO DODANIA!!
    }

    private void generateRiver(Integer minX, Integer maxX, Integer height) throws IllegalArgumentException{
        if (height<5){throw new IllegalArgumentException("can't generate river on map with height <5");}
        Random generator = new Random();
        Integer y = generator.nextInt(height-4)+2;
        for (int i=minX;i<maxX;i++){
            fields.put(new Vector2d(i,y), new RiverField());
        }
        for (int i=0;i<y;i++){
            fields.put(new Vector2d(minX,i), new RiverField());
        }
        for (int i=y+1;i<height;i++){
            fields.put(new Vector2d(maxX,i), new RiverField());
        }
    }
}
