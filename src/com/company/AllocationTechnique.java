package com.company;

import com.sun.istack.internal.localization.NullLocalizable;

import java.util.ArrayList;

public class AllocationTechnique {
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

    public void linkedAllocation(int stat,int end)
    { int randomBlock[]=new int[4];
        int Block[]=new int[4];
        String empty="nil";
        for(int i=0;i<4;i++)
        {
            randomBlock[i]=(int)(end * Math.random());
            if(obj.ifFree(randomBlock)){
                Block[i]=randomBlock[i];
            }
            //else take another random num without increasing i

        }
        for(int i=0;i<4;i++) {
            if(i==3)
            {
                Block[4]=Integer.parseInt(empty);
            }
                System.out.println(Block[i]+" "+Block[i+1]);
            }
        }

    public void indexedAllocation(int index,int content[])
    {

    }

}
