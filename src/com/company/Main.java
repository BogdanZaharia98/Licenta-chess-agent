package com.company;

public class Main {

    public static void main(String[] args) {

        ChessTable table=new ChessTable();
        int i=0;
        while(table.mutare(i)){
            if(i==0) i=1;
            else i=0;
        }
    }
}
