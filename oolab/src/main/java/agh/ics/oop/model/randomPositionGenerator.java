package agh.ics.oop.model;

import java.util.*;

public class randomPositionGenerator implements Iterator<Vector2d> {
    private final int count;
    private int generatedCount = 0;
    private final List<Vector2d> possiblePositions = new ArrayList<>();
    private int max;
    private final Random random = new Random();

    public randomPositionGenerator(int maxWidth, int maxHeight, int count){
        this.count = count;
        this.max = maxWidth * maxHeight;
        for(int i=0; i<=maxWidth; i++){
            for(int j=0; j<=maxHeight; j++){
                possiblePositions.add(new Vector2d(i,j));
            }
        }
    }

    @Override
    public boolean hasNext() {
        return generatedCount < count;
    }

    @Override
    public Vector2d next() {
        int randomIndex = random.nextInt(max + 1);

        Collections.swap(possiblePositions,randomIndex,max);

        max--;
        generatedCount++;

        return possiblePositions.get(max+1);
    }
}
