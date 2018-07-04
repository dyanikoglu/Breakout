package com.dyanikoglu.retrobreakout;

import com.dyanikoglu.retrobreakout.GameObject.Brick.*;

import java.io.*;
import java.net.URL;

public class BrickLoader {
    public static Brick brickArr[] = new Brick[110];
    private static String splitArr[][] = new String[110][];

    public static void createBricks(URL bricksPath) {
        readCoordinates(bricksPath);
        for(int i=0;i<splitArr.length;i++) {
            if(Integer.parseInt(splitArr[i][2])==0) {
                brickArr[i]= new NormalBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==1) {
                brickArr[i]= new StoneBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==2) {
                brickArr[i]= new GemBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==3) {
                brickArr[i]= new GlassBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==4) {
                brickArr[i]= new BorderBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
        }
    }

    private static void readCoordinates(URL bricksPath) {
        BufferedReader in = null;
        int i = 0;
        try {
            in = new BufferedReader( new InputStreamReader(bricksPath.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                splitArr[i++]=inputLine.split(",");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}