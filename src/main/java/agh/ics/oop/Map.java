package agh.ics.oop;

import javafx.scene.image.Image;

import java.util.*;

public class Map {
    private final HashMap<Vector2d, IField> fields=new HashMap<>();
    private HashMap<Vector2d, IProblem> problems = new HashMap<>();
    private HashMap<Vector2d, IHero> heroes = new HashMap<>();
    private SuperFighter fighter;
    private SuperFireman fireman;
    private SuperDetective detective;
    private SuperCompuerScientist scientist;
    private Integer width;
    private Integer height;


    public Map(Integer height, Integer width, Integer riverMinX, Integer riverMaxX, Integer bridges, Integer HardToPassN, Integer noEntryN) {
        this.width=width;
        this.height=height;
        generateRiver(riverMinX, riverMaxX, height, bridges);
        List<Vector2d> emptyFields=new ArrayList<>();
        for (int i=0; i<width;i++){
            for (int j=0;j<height;j++){
                if (!fields.containsKey(new Vector2d(i,j))){emptyFields.add(new Vector2d(i,j));}
            }
        }
        generateHardToPassFields(emptyFields,HardToPassN);
        generateNoEntryFields(emptyFields,noEntryN);
        Vector2d sweetHomePos=generateSpecialFields(emptyFields);
        generateRegularFields(emptyFields);
        generateHeros(sweetHomePos);
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

    private Vector2d generateSpecialFields(List<Vector2d> emptyFields){
        if (emptyFields.size()<2){throw new IllegalArgumentException("there is not enough empty fields to generate TownHall and Home");}
        Random generator = new Random();

        Integer ix = generator.nextInt(emptyFields.size());
        fields.put(emptyFields.get(ix), new TownHall());
        emptyFields.remove(ix);

        ix = generator.nextInt(emptyFields.size());
        Vector2d sweetHomePos=emptyFields.get(ix);
        fields.put(sweetHomePos, new SweetHome());
        emptyFields.remove(ix);
        return sweetHomePos;
    }

    private void generateRegularFields(List<Vector2d> emptyFields){
        for (int i=0;i<emptyFields.size();i++){
            fields.put(emptyFields.get(i), new RegularField());
        }
    }
    private void generateHeros(Vector2d sweetHomePos) {
        fighter=new SuperFighter(sweetHomePos);
        fireman=new SuperFireman(sweetHomePos);
        detective=new SuperDetective(sweetHomePos);
        scientist=new SuperCompuerScientist(sweetHomePos);
        heroes.put(sweetHomePos,fighter);
        heroes.put(sweetHomePos,fireman);
        heroes.put(sweetHomePos,detective);
        heroes.put(sweetHomePos,scientist);
    }

    protected void placeProblemOnMap(IProblem problem){
        Random generator = new Random();
        int x = generator.nextInt(width);
        int y = generator.nextInt(height);

        //tu można chyba trochę lepiej jeśli zrobimy set z miejscami w których mogą się pojawiać problem
        while (!fields.get(new Vector2d(x, y)).canProblemOccur() || problems.containsKey(new Vector2d(x,y))){
            x  = generator.nextInt(width);
            y = generator.nextInt(height);
        }

        problems.put(new Vector2d(x, y), problem);
        problem.placeOnMap(new Vector2d(x,y));
    }

    public IField getFieldOnPosition(Vector2d position){
        return fields.get(position);
    }

    public void removeProblem(Vector2d position){
        problems.remove(position);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getColorOnField(Vector2d position) {
        return fields.get(position).getColor();
    }

    public MoveCoordinates moveHeroOnMap(HeroType hType, MoveDirection direction){
        IHero currHero= switch(hType){
            case Fighter -> fighter;
            case Fireman -> fireman;
            case Detective -> detective;
            case ComputerScientist -> scientist;
        };
        Vector2d newPosition=currHero.getPosition().add(direction.toUnitVector());
        if (currHero.getEnergy()-fields.get(newPosition).energyCost(currHero)>=0){
            MoveCoordinates moveCoordinates= new MoveCoordinates(currHero.getPosition(), newPosition);
            heroes.remove(currHero.getPosition());
            currHero.changePosition(newPosition);
            heroes.put(currHero.getPosition(),currHero);
            currHero.assignProblem(problems.get(currHero.getPosition()));
            return moveCoordinates;
        }
        return null;
    }

    public void renewHeroesEnergy(){
        fireman.renewEnergy();
        fighter.renewEnergy();
        scientist.renewEnergy();
        detective.renewEnergy();
    }

    public void fightProblems(){
        fireman.fightProblem();
        fighter.fightProblem();
        scientist.fightProblem();
        detective.fightProblem();
    }
    public boolean isProblemOnField(Vector2d position) {
        return problems.containsKey(position);
    }

    public String getProblemImage(Vector2d position) {
        if (!isProblemOnField(position)){return null;}
        return problems.get(position).getImage();
    }

    public boolean isHeroOnField(Vector2d position) {
        return heroes.containsKey(position);
    }
    public String getHeroImage(Vector2d position) {
        if (!isHeroOnField(position)){return null;}
        return heroes.get(position).getImage();
    }

    public void removeSolvedProblems(Engine engine) {
        Vector2d[] positions = (Vector2d[]) problems.keySet().toArray();
        for(Vector2d position : positions){
            if(problems.get(position).isSolved()){
                engine.addTrustPoints(problems.get(position).trustLoaf());
                problems.remove(position);
            }
        }
    }

    public void destructProblems(Engine engine) {
        Vector2d[] positions = (Vector2d[]) problems.keySet().toArray();
        for(Vector2d position : positions){
            if(problems.get(position).shouldBeDestructed(engine.getDayNumber())){
                engine.removeTrustPoint();
                problems.remove(position);
            }
        }
    }
}
