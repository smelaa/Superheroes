package agh.ics.oop;

import java.util.*;

public class Map {
    private final HashMap<Vector2d, IField> fields=new HashMap<>();
    private HashMap<Vector2d, IProblem> problems = new HashMap<>();


    public Map(Integer height, Integer width, Integer riverMinX, Integer riverMaxX, Integer bridges, Integer HardToPassN, Integer noEntryN) {
        generateRiver(riverMinX, riverMaxX, height, bridges);
        List<Vector2d> emptyFields=new ArrayList<>();
        for (int i=0; i<width;i++){
            for (int j=0;j<height;j++){
                if (!fields.containsKey(new Vector2d(i,j))){emptyFields.add(new Vector2d(i,j));}
            }
        }
        generateHardToPassFields(emptyFields,HardToPassN);
        generateNoEntryFields(emptyFields,noEntryN);
        generateSpecialFields(emptyFields);
        generateRegularFields(emptyFields);
    }

    public Map(){
        this(16,16,4,11,4,8,16);
    }

    private void generateRiver(Integer minX, Integer maxX, Integer height, Integer bridges) throws IllegalArgumentException{
        if (height<5){throw new IllegalArgumentException("can't generate river on map with height <5");}
        if (minX<=maxX){throw new IllegalArgumentException("river needs to change direction - wrong minX, maxX arguments");}
        Random generator = new Random();
        Integer y = generator.nextInt(height-4)+2;
        List<Vector2d> forBridges=new ArrayList<>();
        for (int i=minX+1;i<maxX;i++){
            fields.put(new Vector2d(i,y), new RiverField());
            forBridges.add(new Vector2d(i,y));
        }
        fields.put(new Vector2d(minX,y), new RiverField());
        fields.put(new Vector2d(maxX,y), new RiverField());
        for (int i=0;i<y;i++){
            fields.put(new Vector2d(minX,i), new RiverField());
            forBridges.add(new Vector2d(minX,i));
        }
        for (int i=y+1;i<height;i++){
            fields.put(new Vector2d(maxX,i), new RiverField());
            forBridges.add(new Vector2d(maxX,i));
        }
        if (forBridges.size()<bridges){throw new IllegalArgumentException("can't generate bridges on the river");}
        for (int i=0;i<bridges;i++){
            Integer bridgeIX = generator.nextInt(forBridges.size());
            fields.put(forBridges.get(bridgeIX), new BridgeField());
        }
    }

    private void generateHardToPassFields(List<Vector2d> emptyFields, Integer n)throws IllegalArgumentException{
        if (emptyFields.size()<n){throw new IllegalArgumentException("there is not enough empty fields to generate HardToPassFields");}
        Random generator = new Random();
        for (int i=0;i<n;i++){
            Integer newFieldIX = generator.nextInt(emptyFields.size());
            fields.put(emptyFields.get(newFieldIX), new HardToPassField());
            emptyFields.remove(newFieldIX);
        }
    }

    private void generateNoEntryFields(List<Vector2d> emptyFields, Integer n)throws IllegalArgumentException{
        if (emptyFields.size()<n){throw new IllegalArgumentException("there is not enough empty fields to generate NoEntryFields");}
        Random generator = new Random();
        for (int i=0;i<n;i++){
            Integer newFieldIX = generator.nextInt(emptyFields.size());
            fields.put(emptyFields.get(newFieldIX), new NoEntryField());
            emptyFields.remove(newFieldIX);
        }
    }

    private void generateSpecialFields(List<Vector2d> emptyFields){
        if (emptyFields.size()<2){throw new IllegalArgumentException("there is not enough empty fields to generate TownHall and Home");}
        Random generator = new Random();

        Integer ix = generator.nextInt(emptyFields.size());
        fields.put(emptyFields.get(ix), new TownHall());
        emptyFields.remove(ix);

        ix = generator.nextInt(emptyFields.size());
        fields.put(emptyFields.get(ix), new SweetHome());
        emptyFields.remove(ix);

    }

    private void generateRegularFields(List<Vector2d> emptyFields){
        for (int i=0;i<emptyFields.size();i++){
            fields.put(emptyFields.get(i), new RegularField());
        }
    }

    private void placeProblemOnMap(String problemName){
        Random generator = new Random();
        IField regular = new RegularField();
        int x = generator.nextInt(16);
        int y = generator.nextInt(16);

        while (fields.get(new Vector2d(x, y)) != regular){
            x  = generator.nextInt(16);
            y = generator.nextInt(16);
        }

        IProblem problem;
        switch (problemName){
            case "fire" -> problem = new Fire();
            case "detective" -> problem = new DetectivePuzzle();
            case "technical" -> problem = new TechnicalIssue();
            default -> problem = new SupervilainProblem();
        }


        problems.put(new Vector2d(x, y), problem);


    }


    private void whichProblemGenerate(){
        Random generator = new Random();
        if (generator.nextInt(101) <= 85){ //typical problem

            switch (generator.nextInt(3)){
                case 0 -> placeProblemOnMap("fire");
                case 1-> placeProblemOnMap("detective");
                default -> placeProblemOnMap("technical");
            }
        }
        else{ //supervillain problem
            placeProblemOnMap("supervillain");

        }
    }


    private void generateProblemsAtStart(){
        for (int i = 0; i < 3; i++){
            whichProblemGenerate();
        }
    }


    private void randomProblems(){
       whichProblemGenerate();
    }


}
