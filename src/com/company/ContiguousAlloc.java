package com.company;

public class ContiguousAlloc {
    private freeSpaceManager obj;

    public void contiguousAllocation(int start,int length)
    {

        int Blockes[]=new int[length];
        for(int i=0;i<length;i++)
        {
            Blockes[i]=start+i;
        }
        if(obj.ifFree(Blockes)){
            System.out.println("Done");
        }
        else {
            System.out.println("Not Free ");
        }
        //obj.allocateBlocks(Blockes);
    }
}
