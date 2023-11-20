package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class TextMap{
    private final List<String> textList = new ArrayList<>();


    public boolean canMoveTo(Integer position) {
        return position >= 0 && position < textList.size();
    }


    public boolean place(String text) {
        textList.add(text);
        return true;
    }


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


    public boolean isOccupied(Integer position) {
        return canMoveTo(position) && textList.get(position) != null;
    }


    public String objectAt(Integer position) {
        return textList.get(position);
    }


    public String toString() {
        return textList.toString();
    }
}
