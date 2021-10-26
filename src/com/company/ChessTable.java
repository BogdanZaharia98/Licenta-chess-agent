package com.company;

import java.util.ArrayList;
import java.util.Random;

public class ChessTable {

    ArrayList<String> piese=new ArrayList<>();
    ArrayList<ArrayList<ArrayList<Integer>>> tabla=new ArrayList<>();
    ArrayList<ArrayList<Integer>> mutari=new ArrayList<>();

    public ChessTable(){
        piese.add("Pion");
        piese.add("Tura");
        piese.add("Cal");
        piese.add("Nebun");
        piese.add("Rege");
        piese.add("Regina");
        ArrayList<Integer> piesaCuloare=new ArrayList<>();
        ArrayList<ArrayList<Integer>> pozitie=new ArrayList<>();

        piesaCuloare.add(5);    //punctaj piesa: tura=5
        piesaCuloare.add(0);    //culoarea piesei: alb
        piesaCuloare.add(0);    //culoarea pozitiei: alb
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(4);    //puctaj piesa: cal=4
        piesaCuloare.add(0);
        piesaCuloare.add(1);    //cuoarea pozitiei: negru
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(3);    //punctaj piesa: nebun=3
        piesaCuloare.add(0);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(9);  //punctaj piesa: regina: 9
        piesaCuloare.add(0);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(1000);    //punctaj piesa: rege=1000
        piesaCuloare.add(0);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(3);
        piesaCuloare.add(0);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(4);
        piesaCuloare.add(0);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(5);
        piesaCuloare.add(0);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        tabla.add(pozitie);

        pozitie=new ArrayList<>();
        for(int i=0;i<8;i++){
            piesaCuloare=new ArrayList<>();
            piesaCuloare.add(1); //punctaj piesa: pion=1
            piesaCuloare.add(0);
            piesaCuloare.add((i%2+1)%2);
            pozitie.add(piesaCuloare);
        }
        tabla.add(pozitie);

        for(int j=0;j<4;j++){
            pozitie=new ArrayList<>();

            for(int i=0;i<8;i++){
                piesaCuloare=new ArrayList<>();
                piesaCuloare.add(-1); //punctaj piesa: pozitie goala=-1
                piesaCuloare.add(-1); // culoarea piesei necunoscuta -1
                piesaCuloare.add(tabla.get(j).get(i).get(2));
                pozitie.add(piesaCuloare);
            }
            tabla.add(pozitie);
        }


        pozitie=new ArrayList<>();
        for(int i=0;i<8;i++){
            piesaCuloare=new ArrayList<>();
            piesaCuloare.add(1); //punctaj piesa: pion=1
            piesaCuloare.add(1);
            piesaCuloare.add((i%2));
            pozitie.add(piesaCuloare);
        }
        tabla.add(pozitie);


        pozitie=new ArrayList<>();

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(5);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(4);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(3);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(9);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(1000);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(3);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(4);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare=new ArrayList<>();
        piesaCuloare.add(5);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        tabla.add(pozitie);
        pozitie=new ArrayList<>();

    }

    public ArrayList<Integer> mutariPion(Integer pozitieX,Integer pozitieY,Integer culoarePiesa){
        ArrayList<Integer> mutari=new ArrayList<>();
        mutari.add(1);      //punctaj piesa pion==1
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);
        if (culoarePiesa==0) {
            if (pozitieX == 1) {
                if (tabla.get(3).get(pozitieY).get(0) == -1) {
                    mutari.add(0);  //muta pe orizonatala 0 pozitii
                    mutari.add(2);  //muta pe verticala 2 pozitii
                }

                if (tabla.get(3).get(pozitieY).get(0) != -1)
                    if (tabla.get(3).get(pozitieY).get(1) != culoarePiesa) {
                        mutari.add(0);  //muta pe orizonatala 0 pozitii
                        mutari.add(2);  //muta pe verticala 2 pozitii
                    }
            }

            if (tabla.get(pozitieX+1).get(pozitieY).get(0)==-1){
                mutari.add(0);
                mutari.add(1);
            }
            if (tabla.get(pozitieX+1).get(pozitieY).get(0)!=-1){
                if (tabla.get(pozitieX+1).get(pozitieY).get(1) != culoarePiesa) {
                    mutari.add(0);
                    mutari.add(1);
                }
            }
        }
        else {
            if (pozitieX == 6) {
                if (tabla.get(4).get(pozitieY).get(0) == -1) {
                    mutari.add(0);  //muta pe orizonatala 0 pozitii
                    mutari.add(-2);  //muta pe verticala 2 pozitii
                }

                if (tabla.get(3).get(pozitieY).get(0) != -1)
                    if (tabla.get(3).get(pozitieY).get(1) != culoarePiesa) {
                        mutari.add(0);  //muta pe orizonatala 0 pozitii
                        mutari.add(-2);  //muta pe verticala 2 pozitii
                    }
            }

            if (tabla.get(pozitieX-1).get(pozitieY).get(0)==-1){
                mutari.add(0);
                mutari.add(-1);
            }
            if (tabla.get(pozitieX-1).get(pozitieY).get(0)!=-1){
                if (tabla.get(pozitieX-1).get(pozitieY).get(1) != culoarePiesa) {
                    mutari.add(0);
                    mutari.add(-1);
                }
            }
        }
        this.mutari.add(mutari);
        return mutari;

        //IA PIESA PE DIAGONALA
        //VERIFICA POZITIILE NAINTE DE A APELA .GET
    }


    public ArrayList<Integer> mutariTura(Integer pozitieX,Integer pozitieY,Integer culoarePiesa){
        ArrayList<Integer> mutari=new ArrayList<>();
        mutari.add(5);
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        boolean notDone=true;
        for(int i=1;notDone&&i<8-pozitieX;i++){
            if(tabla.get(pozitieX+i).get(pozitieY).get(0)==-1) {
                mutari.add(0);
                mutari.add(i);
            }
            else {
                if(culoarePiesa!=tabla.get(pozitieX+i).get(pozitieY).get(1)){
                    mutari.add(0);
                    mutari.add(i);
                }

                notDone=false;
            }
        }
        notDone=true;
        for(int i=pozitieX-1;notDone&&i>=0;i--){
            if(tabla.get(i).get(pozitieY).get(0)==-1) {
                mutari.add(0);
                mutari.add(i-pozitieX);
            }
            else {
                if(culoarePiesa!=tabla.get(i).get(pozitieY).get(1)){
                    mutari.add(0);
                    mutari.add(i-pozitieX);
                }
                notDone=false;
            }
        }
        notDone=true;
        for(int i=1;notDone&&i<8-pozitieY;i++){
            if(tabla.get(pozitieX).get(i+pozitieY).get(0)==-1) {
                mutari.add(i);
                mutari.add(0);
            }
            else {
                if(culoarePiesa!=tabla.get(pozitieX).get(i+pozitieY).get(1)) {
                    mutari.add(i);
                    mutari.add(0);
                }

                notDone=false;
            }
        }
        notDone=true;
        for(int i=pozitieY-1;notDone&&i>=0;i--){
            if(tabla.get(pozitieX).get(i).get(0)==-1) {
                mutari.add(i-pozitieY);
                mutari.add(0);
            }
            else {
                if(tabla.get(pozitieX).get(i).get(1)!=culoarePiesa){
                    mutari.add(i-pozitieY);
                    mutari.add(0);
                }
                notDone=false;
            }
        }
        this.mutari.add(mutari);
        return mutari;
    }

    public ArrayList<Integer> mutariCal(Integer pozitieX,Integer pozitieY,Integer culoarePiesa){
        ArrayList<Integer> mutari=new ArrayList<>();
        mutari.add(4);
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

            if(pozitieX-1>0 && pozitieY-2>=0) {
                if (tabla.get(pozitieX - 1).get(pozitieY - 2).get(0) == -1)
                {
                    mutari.add(-2);
                    mutari.add(-1);
                }
                else
                    if(culoarePiesa!=tabla.get(pozitieX - 1).get(pozitieY - 2).get(1)){
                        mutari.add(-2);
                        mutari.add(-1);
                    }
            }

            if(pozitieX+1<8 && pozitieY-2>=0) {
                if (tabla.get(pozitieX + 1).get(pozitieY - 2).get(0) == -1)
                {
                    mutari.add(-2);
                    mutari.add(1);
                }
                else
                if(culoarePiesa!=tabla.get(pozitieX + 1).get(pozitieY - 2).get(1)){
                    mutari.add(-2);
                    mutari.add(1);
                }
            }




        if(pozitieX-1>=0 && pozitieY+2<8) {
            if (tabla.get(pozitieX - 1).get(pozitieY + 2).get(0) == -1)
            {
                mutari.add(2);
                mutari.add(-1);
            }
            else
            if(culoarePiesa!=tabla.get(pozitieX - 1).get(pozitieY + 2).get(1)){
                mutari.add(2);
                mutari.add(-1);
            }
        }

        if(pozitieX+1<8 && pozitieY+2<8) {
            if (tabla.get(pozitieX + 1).get(pozitieY + 2).get(0) == -1)
            {
                mutari.add(2);
                mutari.add(1);
            }
            else
            if(culoarePiesa!=tabla.get(pozitieX + 1).get(pozitieY + 2).get(1)){
                mutari.add(2);
                mutari.add(1);
            }
        }



        if(pozitieX-2>=0 && pozitieY-1>=0) {
            if (tabla.get(pozitieX - 2).get(pozitieY - 1).get(0) == -1)
            {
                mutari.add(-1);
                mutari.add(-2);
            }
            else
            if(culoarePiesa!=tabla.get(pozitieX - 2).get(pozitieY - 1).get(1)){
                mutari.add(-1);
                mutari.add(-2);
            }
        }
        if(pozitieX-2>=0 && pozitieY+1<8) {
            if (tabla.get(pozitieX - 2).get(pozitieY + 1).get(0) == -1)
            {
                mutari.add(1);
                mutari.add(-2);
            }
            else
            if(culoarePiesa!=tabla.get(pozitieX -2).get(pozitieY +1).get(1)){
                mutari.add(1);
                mutari.add(-2);
            }
        }



        if(pozitieX+2<8 && pozitieY-1>=0) {
            if (tabla.get(pozitieX + 2).get(pozitieY - 1).get(0) == -1)
            {
                mutari.add(-1);
                mutari.add(2);
            }
            else
            if(culoarePiesa!=tabla.get(pozitieX + 2).get(pozitieY - 1).get(1)){
                mutari.add(-1);
                mutari.add(2);
            }
        }
        if(pozitieX+2<8 && pozitieY+1<8) {
            if (tabla.get(pozitieX + 2 ).get(pozitieY + 1).get(0) == -1)
            {
                mutari.add(1);
                mutari.add(2);
            }
            else
            if(culoarePiesa!=tabla.get(pozitieX + 2).get(pozitieY +1).get(1)){
                mutari.add(1);
                mutari.add(2);
            }
        }
        this.mutari.add(mutari);
        return mutari;

    }

    public ArrayList<Integer> mutariNebun(Integer pozitieX,Integer pozitieY,Integer culoarePiesa){
        ArrayList<Integer> mutari=new ArrayList<>();
        mutari.add(3);
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        boolean notDone=true;
        for(int i=pozitieX+1;i<8&&notDone;i++){
                if(tabla.get(i).get(i).get(0)==-1) {
                    mutari.add(i-pozitieX);
                    mutari.add(i-pozitieX);
                }
                else{
                    if(tabla.get(i).get(i).get(1)!=culoarePiesa) {
                        mutari.add(i-pozitieX);
                        mutari.add(i-pozitieX);
                    }
                    notDone=false;
                }
            }

        notDone=true;
        for(int i=pozitieX+1;i<8&&notDone;i++){
            System.out.println(pozitieY-(i-pozitieX));
                if(tabla.get(i).get(pozitieY-(i-pozitieX)).get(0)==-1) {//////////////////////////////////////////////////
                    mutari.add(-1*(i-pozitieX));
                    mutari.add(i-pozitieX);
                }
                else{
                    if(tabla.get(i).get(pozitieY-(i-pozitieX)).get(1)!=culoarePiesa) {
                        mutari.add(-1*(i-pozitieX));
                        mutari.add(i-pozitieX);
                    }
                    notDone=false;
                }
            }

        notDone=true;
        for(int i=pozitieX+1;i<8&&notDone;i++){
            if((pozitieX+pozitieX-i)>=0)
            if(tabla.get(pozitieX+pozitieX-i).get(i).get(0)==-1) {
                mutari.add(i-pozitieX);
                mutari.add(-1*(i-pozitieX));
            }
            else{
                if(tabla.get(pozitieX+pozitieX-i).get(i).get(1)!=culoarePiesa) {
                    mutari.add(i-pozitieX);
                    mutari.add(-1*(i-pozitieX));
                }
                notDone=false;
            }
        }


        notDone=true;
        for(int i=pozitieX+1;i<8&&notDone;i++){
            if((pozitieX+pozitieX-i)>=0)
            if(tabla.get(pozitieX+pozitieX-i).get(pozitieX+pozitieX-i).get(0)==-1) {
                mutari.add(-1*(i-pozitieX));
                mutari.add(-1*(i-pozitieX));
            }
            else{
                if(tabla.get(pozitieX+pozitieX-i).get(pozitieX+pozitieX-i).get(1)!=culoarePiesa) {
                    mutari.add(-1*(i-pozitieX));
                    mutari.add(-1*(i-pozitieX));
                }
                notDone=false;
            }
        }
        this.mutari.add(mutari);
        return mutari;
    }


    public ArrayList<Integer> mutariRegina(Integer pozitieX,Integer pozitieY,Integer culoarePiesa) {
        ArrayList<Integer> mutari;
        mutari=mutariNebun(pozitieX,pozitieY,culoarePiesa);
        mutari.set(0,9);

        ArrayList<Integer> mutariT=mutariTura(pozitieX,pozitieY,culoarePiesa);
        mutariT.remove(0);
        mutariT.remove(0);
        mutariT.remove(0);
        mutariT.remove(0);
        for(int i=0;i<mutariT.size();i++){
            mutari.add(mutariT.get(i));
        }
        this.mutari.add(mutari);
        return mutari;
    }

    public ArrayList<Integer> mutariRege(Integer pozitieX,Integer pozitieY,Integer culoarePiesa) {
        ArrayList<Integer> mutari=new ArrayList<>();
        mutari.add(1000);      //punctaj piesa pion==1
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        ArrayList<Integer> mutariP=new ArrayList<>();
        mutariP.add(0);
        mutariP.add(1);

        mutariP.add(0);
        mutariP.add(-1);

        mutariP.add(1);
        mutariP.add(0);

        mutariP.add(1);
        mutariP.add(1);

        mutariP.add(1);
        mutariP.add(-1);

        mutariP.add(-1);
        mutariP.add(1);

        mutariP.add(-1);
        mutariP.add(0);

        mutariP.add(-1);
        mutariP.add(-1);


        for (int i=0;i<16;i+=2) {
            if((pozitieX+mutariP.get(i))>=0&&(pozitieX+mutariP.get(i))<8&&(pozitieY+mutariP.get(i+1))>=0&&(pozitieY+mutariP.get(i+1))<8)
            if (tabla.get(pozitieX+mutariP.get(i)).get(pozitieY+mutariP.get(i+1)).get(0)==-1){
                mutari.add(mutariP.get(i+1));
                mutari.add(mutariP.get(i));
            }
            else
                if (tabla.get(pozitieX+mutariP.get(i)).get(pozitieY+mutariP.get(i+1)).get(1) != culoarePiesa) {
                    mutari.add(mutariP.get(i+1));
                    mutari.add(mutariP.get(i));
                }

        }
        this.mutari.add(mutari);
        return mutari;


        /////////////////////rocada
    }

    public void muta(int pozX,int pozY){

        tabla.get(mutari.get(pozX).get(2)).get(mutari.get(pozX).get(3)).set(0,-1);
        tabla.get(mutari.get(pozX).get(2)).get(mutari.get(pozX).get(3)).set(1,-1);
        tabla.get(mutari.get(pozX).get(pozY+1)+mutari.get(pozX).get(2)).get(mutari.get(pozX).get(pozY)+mutari.get(pozX).get(3)).set(0,mutari.get(pozX).get(0));
        tabla.get(mutari.get(pozX).get(pozY+1)+mutari.get(pozX).get(2)).get(mutari.get(pozX).get(pozY)+mutari.get(pozX).get(3)).set(1,mutari.get(pozX).get(1));

    }

    public int evaluate(byte b,int b1){
        int sum=0;
        System.out.println(mutari.get(b).get(b1+1)+mutari.get(b).get(2));
        System.out.println(mutari.get(b).get(b1)+mutari.get(b).get(3));
        if(tabla.get(mutari.get(b).get(b1+1)+mutari.get(b).get(2)).get(mutari.get(b).get(b1)+mutari.get(b).get(3)).get(1)!=mutari.get(b).get(1))
            sum+=5;
        if(mutari.get(b).get(b1)>0)
            sum+=1;


        return sum;
    }



    public void mutare(int c){

        mutari=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {

                switch (tabla.get(i).get(j).get(0)) {
                    case 1:
                        mutariPion(i, j, tabla.get(i).get(j).get(1));
                        break;
                    case 3:
                        mutariNebun(i, j, tabla.get(i).get(j).get(1));
                        break;
                    case 4:
                        mutariCal(i, j, tabla.get(i).get(j).get(1));
                        break;
                    case 5:
                        mutariTura(i, j, tabla.get(i).get(j).get(1));
                        break;
                    case 9:
                        mutariRegina(i, j, tabla.get(i).get(j).get(1));
                        break;
                    case 1000:
                        mutariRege(i, j, tabla.get(i).get(j).get(1));
                        break;
                }
            }
        }

        Random rand = new Random();
        boolean modificat;
        ArrayList<Byte> populatie=new ArrayList<>();
        for (int i=0;i<mutari.size();i++) {
            modificat=false;
            if(mutari.get(i).size()>4&&mutari.get(i).get(1)==c)
            for (int j=4;j<mutari.get(i).size();j+=2) {
                int x=rand.nextInt(1000)%3;
                if(x==2){
                    modificat=true;
                    populatie.add((byte)i);
                    populatie.add((byte)j);
                }
            }
            if(!modificat&&mutari.get(i).size()>4&&mutari.get(i).get(1)==c){
                populatie.add((byte)i);
                populatie.add((byte)4);
            }
        }


        ArrayList<Integer> fitness=new ArrayList<>();
        for(int i=0;i<populatie.size();i+=2){
            fitness.add(evaluate(populatie.get(i),populatie.get(i+1)));
        }

        int t=0;
        while(t<10){
            boolean done=false;
            while (!done){
                done=true;
                for(int i=0;i<populatie.size()-4;i+=4){

                    if(fitness.get(i/2)>fitness.get(i/2+1))
                    {
                        int tmp=fitness.get(i/2);
                        fitness.set(i/2,fitness.get(i/2+1));
                        fitness.set(i/2+1,tmp);
                        tmp=populatie.get(i);
                        populatie.set(i,populatie.get(i+2));
                        populatie.set(i+2,(byte)tmp);
                        tmp=populatie.get(i+1);
                        populatie.set(i+1,populatie.get(i+3));
                        populatie.set(i+3,(byte)tmp);
                        done=false;
                    }
                }
            }

            ///ordoneaza dupa fitness

            int n=fitness.size()*30/100;
            System.out.println("Numarul de indivizi care vor fi recombinati: "+n);

            for(int i=populatie.size();i>populatie.size()-n*2;i-=2){
                int x=populatie.get(i-1);
                x=x^ (rand.nextInt(100))%mutari.get(populatie.get(i-2)).size();
                if(x<4) x=4;
                if(x%2==1) x=x-1;
                populatie.set(i-1,(byte)x);
            }

            t++;
        }

        muta(populatie.get(0),populatie.get(1));

    }



}
