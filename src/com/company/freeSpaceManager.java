package com.company;

import java.util.ArrayList;

public class freeSpaceManager {
    private int numOfBlocks;
    private int[] blocks;
    public ArrayList<Integer> start=new ArrayList<Integer>();
    public ArrayList<Integer> end=new ArrayList<Integer>();

    public int[] getBlocks() {
        return this.blocks;
    }
   public int bestFit(int len)
     {
       //int lenFile= arr.length;
       int count,index=0;
       ArrayList<Integer> freeBlocks=new ArrayList<Integer>();
       for(int i=0;i<numOfBlocks;i++)
       {  count=0;
           index=0;
           if(blocks[i]==0)
           {
               if(index==0)
           {
               start.add(i);
               index++;
           }
               count++;
           }
           else {
               end.add(i-1);
               freeBlocks.add(count);
               break;
           }
       }
       int best=getMin(freeBlocks,len);
       return best;
     }

    public int getMin(ArrayList<Integer>arr,int len)
    {int Min=arr.get(0);
        for(int i=0;i<arr.size();i++)
        {
            if(Min>arr.get(i) &&arr.get(i)>=len)
            {
                Min=arr.get(i);
            }
        }

        return Min;
    }
    public freeSpaceManager(int numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
        this.blocks = new int[numOfBlocks];
        for (int i = 0; i < numOfBlocks; i++) {
            this.blocks[i] = 0;
        }
    }

    public void getFreeBlocks() {
        System.out.println("Free Blocks is:");
        System.out.print("[");
        for (int i = 0; i < numOfBlocks; i++) {
            if (blocks[i] == 0) {
                System.out.print(i + 1);
                System.out.print(" ,");
            }
        }
        System.out.println("]");
    }

//    public boolean searchFreeContiguousBlocks(int length) {
//        int count = 0;
//        int store = 0;
//        ArrayList<Integer> contiguousBlocks = new ArrayList<Integer>();
//        for (int i = 0; i < numOfBlocks; i++) {
//            if (blocks[i] == 0) {
//                if (store == i - 1) {
//                    count++;
//                    contiguousBlocks.add(i);
//                }
//                store = i;
//            }
//        }
//        if (count >= length) {
//            System.out.println("There are free contiguous blocks for this file:");
//            System.out.println(contiguousBlocks);
//            return true;
//        }
//        return false;
//    }
//
    public boolean ifFree(int[] positions) {
        boolean status = true;
        for (int i = 0; i < positions.length; i++) {
            if (blocks[positions[i] - 1] != 0) {
                status = false;
                break;
            }
        }
        return status;
    }

    public void allocateBlocks(file obj) {
        if(ifFree(obj.getAllocatedBlocks())){
            for (int i=0;i<obj.getAllocatedBlocks().length;i++){
                blocks[obj.getAllocatedBlocks()[i] - 1] = 1;
            }
            System.out.println("The blocks are allocated successfully");
        }else {
            System.out.println("All these positions or some of them are already allocated!");
        }
    }

    public void deAllocationBlocks(file obj) {
        for (int i = 0; i < obj.getAllocatedBlocks().length; i++) {
            blocks[obj.getAllocatedBlocks()[i] - 1] = 0;
        }
        System.out.println("File blocks are deallocated successfully!");
    }
}
