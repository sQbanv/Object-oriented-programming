package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class TextMap implements WorldMap<String, Integer>{
    private final List<String> textList = new ArrayList<>();

    @Override
    public boolean canMoveTo(Integer position) {
        return position >= 0 && position < textList.size();
    }

    @Override
    public boolean place(String text) {
        textList.add(text);
        return true;
    }

    @Override
    public void move(String text, MoveDirection direction) {
        if(textList.contains(text)){
            int currPosition = textList.indexOf(text);
            switch (direction){
                case FORWARD -> {
                    if(canMoveTo(currPosition + 1)){
                        String next = textList.get(currPosition + 1);
                        textList.set(currPosition,next);
                        textList.set(currPosition + 1,text);
                    }
                }
                case BACKWARD -> {
                    if(canMoveTo(currPosition - 1)){
                        String prev = textList.get(currPosition - 1);
                        textList.set(currPosition,prev);
                        textList.set(currPosition - 1,text);
                    }
                }
            }
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return canMoveTo(position) && textList.get(position) != null;
    }

    @Override
    public String objectAt(Integer position) {
        return textList.get(position);
    }

    @Override
    public String toString() {
        return textList.toString();
    }
}
