import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static void next_move(int posr, int posc, String[] board){
        //add logic here
    
      int mindirtdist=4;
      int mindirtR=-1;
      int mindirtC=-1;
    int n=board.length;
    
    String nextMove="";
    
    if(board[posr].charAt(posc)=='d')
        {
        nextMove="CLEAN";
    }
    else
        {
    
      for(int i=-1;i<=1;i++)   // loop to find the dirt in the visible region
          {
           if((posr+i)<0 || (posr+i)>=n)
               continue;
          for(int j=-1;j<=1;j++)
              {
              if((posc+j)<0 || (posc+j)>=n)
               continue;
              
              if(board[posr+i].charAt(posc+j)=='d')
                  {
                  int dirtR=posr+i;
                  int dirtC=posc+j;
                  int dirtdistR=posr-dirtR;
                  int dirtdistC=posc-dirtC;
                  
                  if(dirtdistR<0)
                      dirtdistR*=-1;
                  
                  if(dirtdistC<0)
                      dirtdistC*=-1;
                      
                  int dirtdist=dirtdistR+dirtdistC;
                  
                  if(dirtdist<mindirtdist)
                      {
                      
                      mindirtdist=dirtdist;
                      mindirtR=posr+i;
                      mindirtC=posc+j;
                  }
              }
          }
      }  // loop ends
    
    if(mindirtR!=-1 && mindirtC!=-1)  // logic if the dirt is found in the visible region
        {
        int dirtdistR=posr-mindirtR;
        int dirtdistC=posc-mindirtC;
        
        if(dirtdistC!=0)
            {
            if(dirtdistC>0)
                nextMove="LEFT";
            else
                nextMove="RIGHT";
        }
        else
            {
            if(dirtdistR!=0)
                {
                if(dirtdistR>0)
                    nextMove="UP";
                else
                    nextMove="DOWN";
            }
        }
    }
      else   // this will move the bot in a definite manner if the dirt is not found within the visible region
          {
            if(posc!=n-1 || posr!=n-1)
                {
                if(posr==n-1 && posc%2==0)
                    {
                      nextMove="RIGHT";
                }
                else if(posr==0 && posc%2==1)
                    nextMove="RIGHT";
                    else
                    {
                    if(posc%2==0)
                        nextMove="DOWN";
                    else
                        nextMove="UP";
                }
            }
          
      }
    }
    
    System.out.println(nextMove);
    
    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
