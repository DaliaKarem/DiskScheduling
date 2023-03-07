package com.company;

public class linkedAlloc {
    freeSpaceManager obj;

    public void linkedAllocation(int stat,int end) {
        int randomBlock[] = new int[4];
        int Block[] = new int[4];
        String empty = "nil";
        for (int i = 0; i < 4; i++) {
            randomBlock[i] = (int) (end * Math.random());
            if (obj.ifFree(randomBlock)) {
                Block[i] = randomBlock[i];
            }
            //else take another random num without increasing i

        }
    }
}
