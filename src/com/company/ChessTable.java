package com.company;

import java.util.ArrayList;
import java.util.Random;

public class ChessTable {

    ArrayList<String> piese = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<Integer>>> tabla = new ArrayList<>();
    ArrayList<ArrayList<Integer>> mutari = new ArrayList<>();
    boolean rocadaAlb = true, rocadaNegru = true;

    public ChessTable() {
        piese.add("Pion");
        piese.add("Tura");
        piese.add("Cal");
        piese.add("Nebun");
        piese.add("Rege");
        piese.add("Regina");
        ArrayList<Integer> piesaCuloare = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pozitie = new ArrayList<>();

        piesaCuloare.add(5);    //punctaj piesa: tura=5
        piesaCuloare.add(0);    //culoarea piesei: alb
        piesaCuloare.add(0);    //culoarea pozitiei: alb
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(4);    //puctaj piesa: cal=4
        piesaCuloare.add(0);
        piesaCuloare.add(1);    //cuoarea pozitiei: negru
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(3);    //punctaj piesa: nebun=3
        piesaCuloare.add(0);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(9);  //punctaj piesa: regina: 9
        piesaCuloare.add(0);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(1000);    //punctaj piesa: rege=1000
        piesaCuloare.add(0);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(3);
        piesaCuloare.add(0);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(4);
        piesaCuloare.add(0);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(5);
        piesaCuloare.add(0);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        tabla.add(pozitie);

        pozitie = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            piesaCuloare = new ArrayList<>();
            piesaCuloare.add(1); //punctaj piesa: pion=1
            piesaCuloare.add(0);
            piesaCuloare.add((i % 2 + 1) % 2);
            pozitie.add(piesaCuloare);
        }
        tabla.add(pozitie);

        for (int j = 0; j < 4; j++) {
            pozitie = new ArrayList<>();

            for (int i = 0; i < 8; i++) {
                piesaCuloare = new ArrayList<>();
                piesaCuloare.add(-1); //punctaj piesa: pozitie goala=-1
                piesaCuloare.add(-1); // culoarea piesei necunoscuta -1
                piesaCuloare.add(tabla.get(j).get(i).get(2));
                pozitie.add(piesaCuloare);
            }
            tabla.add(pozitie);
        }


        pozitie = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            piesaCuloare = new ArrayList<>();
            piesaCuloare.add(1); //punctaj piesa: pion=1
            piesaCuloare.add(1);
            piesaCuloare.add((i % 2));
            pozitie.add(piesaCuloare);
        }
        tabla.add(pozitie);


        pozitie = new ArrayList<>();

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(5);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(4);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(3);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(9);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(1000);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(3);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(4);
        piesaCuloare.add(1);
        piesaCuloare.add(1);
        pozitie.add(piesaCuloare);

        piesaCuloare = new ArrayList<>();
        piesaCuloare.add(5);
        piesaCuloare.add(1);
        piesaCuloare.add(0);
        pozitie.add(piesaCuloare);

        tabla.add(pozitie);
        pozitie = new ArrayList<>();

    }

    public ArrayList<Integer> mutariPion(Integer pozitieX, Integer pozitieY, Integer culoarePiesa) {
        ArrayList<Integer> mutari = new ArrayList<>();
        mutari.add(1);      //punctaj piesa pion==1
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);
        if (culoarePiesa == 0) {
            if (pozitieX == 1) {
                if (tabla.get(3).get(pozitieY).get(0) == -1) {
                    mutari.add(0);  //muta pe orizonatala 0 pozitii
                    mutari.add(2);  //muta pe verticala 2 pozitii
                }

            }

            if (pozitieX + 1 < 8)
                if (tabla.get(pozitieX + 1).get(pozitieY).get(0) == -1) {
                    mutari.add(0);
                    mutari.add(1);
                }
            if (pozitieX + 1 < 8 && pozitieY + 1 < 8)
                if (tabla.get(pozitieX + 1).get(pozitieY + 1).get(0) != -1 && tabla.get(pozitieX + 1).get(pozitieY + 1).get(0) != 1000) {
                    if (tabla.get(pozitieX + 1).get(pozitieY + 1).get(1) != culoarePiesa) {
                        mutari.add(1);
                        mutari.add(1);
                    }
                }
            if (pozitieX + 1 < 8 && pozitieY - 1 >= 0)
                if (tabla.get(pozitieX + 1).get(pozitieY - 1).get(0) != -1 && tabla.get(pozitieX + 1).get(pozitieY - 1).get(0) != 1000) {
                    if (tabla.get(pozitieX + 1).get(pozitieY - 1).get(1) != culoarePiesa) {
                        mutari.add(-1);
                        mutari.add(1);
                    }
                }
        } else {
            if (pozitieX == 6) {
                if (tabla.get(4).get(pozitieY).get(0) == -1) {
                    mutari.add(0);  //muta pe orizonatala 0 pozitii
                    mutari.add(-2);  //muta pe verticala 2 pozitii
                }

            }

            if (pozitieX - 1 >= 0)
                if (tabla.get(pozitieX - 1).get(pozitieY).get(0) == -1) {
                    mutari.add(0);
                    mutari.add(-1);
                }
            if (pozitieX - 1 >= 0 && pozitieY + 1 < 8)
                if (tabla.get(pozitieX - 1).get(pozitieY + 1).get(0) != -1 && tabla.get(pozitieX - 1).get(pozitieY + 1).get(0) != 1000) {
                    if (tabla.get(pozitieX - 1).get(pozitieY + 1).get(1) != culoarePiesa) {
                        mutari.add(1);
                        mutari.add(-1);
                    }
                }

            if (pozitieX - 1 >= 0 && pozitieY - 1 >= 0)
                if (tabla.get(pozitieX - 1).get(pozitieY - 1).get(0) != -1 && tabla.get(pozitieX - 1).get(pozitieY - 1).get(0) != 1000) {
                    if (tabla.get(pozitieX - 1).get(pozitieY - 1).get(1) != culoarePiesa) {
                        mutari.add(-1);
                        mutari.add(-1);
                    }
                }
        }

        return mutari;

    }


    public ArrayList<Integer> mutariTura(Integer pozitieX, Integer pozitieY, Integer culoarePiesa) {
        ArrayList<Integer> mutari = new ArrayList<>();
        mutari.add(5);
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        boolean notDone = true;
        for (int i = 1; notDone && i < 8 - pozitieX; i++) {
            if (pozitieX + i < 8)
                if (tabla.get(pozitieX + i).get(pozitieY).get(0) == -1) {
                    mutari.add(0);
                    mutari.add(i);
                } else {
                    if (tabla.get(pozitieX + i).get(pozitieY).get(0) != 1000)
                        if (pozitieX + i < 8)
                            if (culoarePiesa != tabla.get(pozitieX + i).get(pozitieY).get(1)) {
                                mutari.add(0);
                                mutari.add(i);
                            }

                    notDone = false;
                }
        }
        notDone = true;
        for (int i = pozitieX - 1; notDone && i >= 0; i--) {
            if (tabla.get(i).get(pozitieY).get(0) == -1) {
                mutari.add(0);
                mutari.add(i - pozitieX);
            } else {
                if (tabla.get(i).get(pozitieY).get(0) != 1000)
                    if (culoarePiesa != tabla.get(i).get(pozitieY).get(1)) {
                        mutari.add(0);
                        mutari.add(i - pozitieX);
                    }
                notDone = false;
            }
        }
        notDone = true;
        for (int i = 1; notDone && i < 8 - pozitieY; i++) {
            if (i + pozitieY < 8)
                if (tabla.get(pozitieX).get(i + pozitieY).get(0) == -1) {
                    mutari.add(i);
                    mutari.add(0);
                } else {
                    if (tabla.get(pozitieX).get(i + pozitieY).get(0) != 1000)
                        if (culoarePiesa != tabla.get(pozitieX).get(i + pozitieY).get(1)) {
                            mutari.add(i);
                            mutari.add(0);
                        }

                    notDone = false;
                }
        }
        notDone = true;
        for (int i = pozitieY - 1; notDone && i >= 0; i--) {
            if (tabla.get(pozitieX).get(i).get(0) == -1) {
                mutari.add(i - pozitieY);
                mutari.add(0);
            } else {
                if (tabla.get(pozitieX).get(i).get(0) != 1000)
                    if (tabla.get(pozitieX).get(i).get(1) != culoarePiesa) {
                        mutari.add(i - pozitieY);
                        mutari.add(0);
                    }
                notDone = false;
            }
        }
        if (mutari.get(0) == 0)
            System.out.println("Tura");
        return mutari;
    }

    public ArrayList<Integer> mutariCal(Integer pozitieX, Integer pozitieY, Integer culoarePiesa) {
        ArrayList<Integer> mutari = new ArrayList<>();
        mutari.add(4);
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        if (pozitieX - 1 > 0 && pozitieY - 2 >= 0) {
            if (tabla.get(pozitieX - 1).get(pozitieY - 2).get(0) == -1) {
                mutari.add(-2);
                mutari.add(-1);
            } else if (tabla.get(pozitieX - 1).get(pozitieY - 2).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX - 1).get(pozitieY - 2).get(1)) {
                    mutari.add(-2);
                    mutari.add(-1);
                }
        }

        if (pozitieX + 1 < 8 && pozitieY - 2 >= 0) {
            if (tabla.get(pozitieX + 1).get(pozitieY - 2).get(0) == -1) {
                mutari.add(-2);
                mutari.add(1);
            } else if (tabla.get(pozitieX + 1).get(pozitieY - 2).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX + 1).get(pozitieY - 2).get(1)) {
                    mutari.add(-2);
                    mutari.add(1);
                }
        }


        if (pozitieX - 1 >= 0 && pozitieY + 2 < 8) {
            if (tabla.get(pozitieX - 1).get(pozitieY + 2).get(0) == -1) {
                mutari.add(2);
                mutari.add(-1);
            } else if (tabla.get(pozitieX - 1).get(pozitieY + 2).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX - 1).get(pozitieY + 2).get(1)) {
                    mutari.add(2);
                    mutari.add(-1);
                }
        }

        if (pozitieX + 1 < 8 && pozitieY + 2 < 8) {
            if (tabla.get(pozitieX + 1).get(pozitieY + 2).get(0) == -1) {
                mutari.add(2);
                mutari.add(1);
            } else if (tabla.get(pozitieX + 1).get(pozitieY + 2).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX + 1).get(pozitieY + 2).get(1)) {
                    mutari.add(2);
                    mutari.add(1);
                }
        }


        if (pozitieX - 2 >= 0 && pozitieY - 1 >= 0) {
            if (tabla.get(pozitieX - 2).get(pozitieY - 1).get(0) == -1) {
                mutari.add(-1);
                mutari.add(-2);
            } else if (tabla.get(pozitieX - 2).get(pozitieY - 1).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX - 2).get(pozitieY - 1).get(1)) {
                    mutari.add(-1);
                    mutari.add(-2);
                }
        }
        if (pozitieX - 2 >= 0 && pozitieY + 1 < 8) {
            if (tabla.get(pozitieX - 2).get(pozitieY + 1).get(0) == -1) {
                mutari.add(1);
                mutari.add(-2);
            } else if (tabla.get(pozitieX - 2).get(pozitieY + 1).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX - 2).get(pozitieY + 1).get(1)) {
                    mutari.add(1);
                    mutari.add(-2);
                }
        }


        if (pozitieX + 2 < 8 && pozitieY - 1 >= 0) {
            if (tabla.get(pozitieX + 2).get(pozitieY - 1).get(0) == -1) {
                mutari.add(-1);
                mutari.add(2);
            } else if (tabla.get(pozitieX + 2).get(pozitieY - 1).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX + 2).get(pozitieY - 1).get(1)) {
                    mutari.add(-1);
                    mutari.add(2);
                }
        }
        if (pozitieX + 2 < 8 && pozitieY + 1 < 8) {
            if (tabla.get(pozitieX + 2).get(pozitieY + 1).get(0) == -1) {
                mutari.add(1);
                mutari.add(2);
            } else if (tabla.get(pozitieX + 2).get(pozitieY + 1).get(0) != 1000)
                if (culoarePiesa != tabla.get(pozitieX + 2).get(pozitieY + 1).get(1)) {
                    mutari.add(1);
                    mutari.add(2);
                }
        }
        if (mutari.get(0) == 0)
            System.out.println("Cal");
        return mutari;


    }

    public ArrayList<Integer> mutariNebun(Integer pozitieX, Integer pozitieY, Integer culoarePiesa) {
        ArrayList<Integer> mutari = new ArrayList<>();
        mutari.add(3);
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        boolean notDone = true;
        for (int i = pozitieX + 1; i < 8 && notDone; i++) {     // diagonala +x+y
            if (pozitieY + i - pozitieX < 8)
                if (tabla.get(i).get(pozitieY + i - pozitieX).get(0) == -1) {
                    mutari.add(i - pozitieX);
                    mutari.add(i - pozitieX);
                } else {

                    if (tabla.get(i).get(pozitieY + i - pozitieX).get(0) != 1000)
                        if (tabla.get(i).get(pozitieY + i - pozitieX).get(1) != culoarePiesa) {
                            mutari.add(i - pozitieX);
                            mutari.add(i - pozitieX);
                        }
                    notDone = false;
                }
        }

        notDone = true;
        for (int i = pozitieX + 1; i < 8 && notDone; i++) {         ///diagonala +x-y
            if (pozitieY - (i - pozitieX) >= 0)
                if (tabla.get(i).get(pozitieY - (i - pozitieX)).get(0) == -1) {
                    mutari.add(-1 * (i - pozitieX));
                    mutari.add(i - pozitieX);
                } else {

                    if (tabla.get(i).get(pozitieY - (i - pozitieX)).get(0) != 1000)
                        if (tabla.get(i).get(pozitieY - (i - pozitieX)).get(1) != culoarePiesa) {
                            mutari.add(-1 * (i - pozitieX));
                            mutari.add(i - pozitieX);
                        }
                    notDone = false;
                }
        }

        notDone = true;
        for (int i = pozitieX + 1; i < 8 && notDone; i++) {         /// diagonala -x+y
            if ((pozitieX + pozitieX - i) >= 0 && pozitieY + (i - pozitieX) < 8)
                if (tabla.get(pozitieX + pozitieX - i).get(pozitieY + i - pozitieX).get(0) == -1) {
                    mutari.add(i - pozitieX);
                    mutari.add(-1 * (i - pozitieX));
                } else {

                    if (tabla.get(pozitieX + pozitieX - i).get(pozitieY + i - pozitieX).get(0) != 1000)
                        if (tabla.get(pozitieX + pozitieX - i).get(pozitieY + i - pozitieX).get(1) != culoarePiesa) {
                            mutari.add(i - pozitieX);
                            mutari.add(-1 * (i - pozitieX));
                        }
                    notDone = false;
                }
        }


        notDone = true;
        for (int i = pozitieX + 1; i < 8 && notDone; i++) {
            if ((pozitieX + pozitieX - i) >= 0 && pozitieY - (i - pozitieX) >= 0)
                if (tabla.get(pozitieX + pozitieX - i).get(pozitieY + pozitieX - i).get(0) == -1) {
                    mutari.add(-1 * (i - pozitieX));
                    mutari.add(-1 * (i - pozitieX));
                } else {

                    if (tabla.get(pozitieX + pozitieX - i).get(pozitieY + pozitieX - i).get(0) != 1000)
                        if (tabla.get(pozitieX + pozitieX - i).get(pozitieY + pozitieX - i).get(1) != culoarePiesa) {
                            mutari.add(-1 * (i - pozitieX));
                            mutari.add(-1 * (i - pozitieX));
                        }
                    notDone = false;
                }
        }

        return mutari;
    }


    public ArrayList<Integer> mutariRegina(Integer pozitieX, Integer pozitieY, Integer culoarePiesa) {
        ArrayList<Integer> mutari;
        mutari = mutariNebun(pozitieX, pozitieY, culoarePiesa);
        mutari.set(0, 9);

        ArrayList<Integer> mutariT = mutariTura(pozitieX, pozitieY, culoarePiesa);
        mutariT.remove(0);
        mutariT.remove(0);
        mutariT.remove(0);
        mutariT.remove(0);
        for (int i = 0; i < mutariT.size(); i++) {
            mutari.add(mutariT.get(i));
        }
        if (mutari.get(0) == 0)
            System.out.println("Regina");
        if (mutari.size() > 1) ;
        return mutari;
    }

    public ArrayList<Integer> mutariRege(Integer pozitieX, Integer pozitieY, Integer culoarePiesa) {
        ArrayList<Integer> mutari = new ArrayList<>();
        mutari.add(1000);      //punctaj piesa rege==1000
        mutari.add(culoarePiesa);
        mutari.add(pozitieX);
        mutari.add(pozitieY);

        ArrayList<Integer> mutariP = new ArrayList<>();
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


        for (int i = 0; i < 16; i += 2) {
            if ((pozitieX + mutariP.get(i)) >= 0 && (pozitieX + mutariP.get(i)) < 8 && (pozitieY + mutariP.get(i + 1)) >= 0 && (pozitieY + mutariP.get(i + 1)) < 8)
                if (tabla.get(pozitieX + mutariP.get(i)).get(pozitieY + mutariP.get(i + 1)).get(0) == -1) {
                    boolean done = false;
                    for (int j = 0; j < this.mutari.size(); j++)
                        if (this.mutari.get(j).get(0) == 1000 && this.mutari.get(j).get(1) != culoarePiesa)
                            for (int k = 4; k < this.mutari.get(j).size(); k += 2) {
                                if (this.mutari.get(j).get(2) + this.mutari.get(j).get(k + 1) != mutari.get(2) + mutariP.get(i) &&
                                        this.mutari.get(j).get(3) + this.mutari.get(j).get(k) != mutari.get(3) + mutariP.get(i+1)) {
                                    done = true;

                                }
                            }
                    if (!done) {
                        mutari.add(mutariP.get(i + 1));
                        mutari.add(mutariP.get(i));
                    }

                } else if ((pozitieX + mutariP.get(i)) >= 0 && (pozitieX + mutariP.get(i)) < 8 && (pozitieY + mutariP.get(i + 1)) >= 0 && (pozitieY + mutariP.get(i + 1)) < 8)
                    if (tabla.get(pozitieX + mutariP.get(i)).get(pozitieY + mutariP.get(i + 1)).get(1) != culoarePiesa &&tabla.get(pozitieX + mutariP.get(i)).get(pozitieY + mutariP.get(i + 1)).get(0)!=1000) {
                        boolean done = false;
                        for (int j = 0; j < this.mutari.size() && !done; j++)
                            if (this.mutari.get(j).get(0) == 1000 && this.mutari.get(j).get(1) != culoarePiesa)
                                for (int k = 4; k < this.mutari.get(j).size() && !done; k += 2) {
                                    if (this.mutari.get(j).get(2) + this.mutari.get(j).get(k + 1) == mutari.get(2) + mutariP.get(i) &&
                                            this.mutari.get(j).get(3) + this.mutari.get(j).get(k) == mutari.get(3) + mutariP.get(i+1)) {
                                        done = true;
                                    }
                                }
                        if (!done) {
                            mutari.add(mutariP.get(i + 1));
                            mutari.add(mutariP.get(i));
                        }
                    }

        }


        if (!sah(culoarePiesa)) {
            if (pozitieX == 0 && pozitieY == 4 && culoarePiesa == 0 && rocadaAlb){
                if (tabla.get(0).get(3).get(0) == -1 && tabla.get(0).get(2).get(0) == -1 && tabla.get(0).get(1).get(0) == -1 && tabla.get(0).get(0).get(0) == 5) {
                    mutari.add(-2);
                    mutari.add(0);
                }

            if (tabla.get(0).get(5).get(0) == -1 && tabla.get(0).get(6).get(0) == -1 && tabla.get(0).get(7).get(0) == 5) {
                mutari.add(2);
                mutari.add(0);
            }}

            if (pozitieX == 7 && pozitieY == 4 && culoarePiesa == 1 && rocadaNegru){
                if (tabla.get(7).get(3).get(0) == -1 && tabla.get(7).get(2).get(0) == -1 && tabla.get(7).get(1).get(0) == -1 && tabla.get(7).get(0).get(0) == 5) {
                    mutari.add(-2);
                    mutari.add(0);
                }
            if (tabla.get(7).get(5).get(0) == -1 && tabla.get(7).get(6).get(0) == -1 && tabla.get(7).get(7).get(0) == 5) {
                mutari.add(2);
                mutari.add(0);
            }}

        }
        /////////////////////rocada
        return mutari;
    }

    public boolean sah(int culoareRege) {
        boolean sah = false;
        int pozX = 0, pozY = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabla.get(i).get(j).get(0) == 1000 && tabla.get(i).get(j).get(1) == culoareRege) {
                    pozX = i;
                    pozY = j;
                    i = 8;
                    break;
                }
            }
        }

        for (int i = 0; i < mutari.size(); i++) {
            if (mutari.get(i).size() > 4)
                if (mutari.get(i).get(1) != culoareRege)
                    for (int j = 4; j < mutari.get(i).size(); j += 2) {
                        if (mutari.get(i).get(j) + mutari.get(i).get(3) == pozY && mutari.get(i).get(j + 1) + mutari.get(i).get(2) == pozX) {
                            sah = true;
                            if (culoareRege == 0) rocadaAlb = false;
                            else
                                rocadaNegru = false;
                            i = mutari.size();
                            break;
                        }
                    }

        }

        return sah;
    }

    public void muta(int pozX, int pozY) {
        System.out.println("Muta " + tabla.get(mutari.get(pozX).get(2)).get(mutari.get(pozX).get(3)).get(0) + "de culoarea " + tabla.get(mutari.get(pozX).get(2)).get(mutari.get(pozX).get(3)).get(1));
        System.out.println("de la Y " + mutari.get(pozX).get(3) + " cu " + mutari.get(pozX).get(pozY));

        System.out.println("de la x " + mutari.get(pozX).get(2) + " cu " + mutari.get(pozX).get(pozY + 1));


        if( tabla.get(mutari.get(pozX).get(pozY + 1) + mutari.get(pozX).get(2)).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).get(0)!=1000) {
            tabla.get(mutari.get(pozX).get(2)).get(mutari.get(pozX).get(3)).set(0, -1);
            tabla.get(mutari.get(pozX).get(2)).get(mutari.get(pozX).get(3)).set(1, -1);
            tabla.get(mutari.get(pozX).get(pozY + 1) + mutari.get(pozX).get(2)).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).set(0, mutari.get(pozX).get(0));
            tabla.get(mutari.get(pozX).get(pozY + 1) + mutari.get(pozX).get(2)).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).set(1, mutari.get(pozX).get(1));

            //rocada rege
            if (mutari.get(pozX).get(0) == 1000) {
                if (mutari.get(pozX).get(1) == 0) {
                    if (mutari.get(pozX).get(pozY) == 2) {
                        tabla.get(0).get(0).set(0, -1);
                        tabla.get(0).get(0).set(1, -1);
                        tabla.get(0).get(3).set(0, 5);
                        tabla.get(0).get(3).set(1, 0);
                    }
                    if (mutari.get(pozX).get(pozY) == -2) {
                        tabla.get(0).get(7).set(0, -1);
                        tabla.get(0).get(7).set(1, -1);
                        tabla.get(0).get(5).set(0, 5);
                        tabla.get(0).get(5).set(1, 0);
                    }
                    rocadaAlb = false;
                } else {
                    if (mutari.get(pozX).get(pozY) == 2) {
                        tabla.get(7).get(0).set(0, -1);
                        tabla.get(7).get(0).set(1, -1);
                        tabla.get(7).get(3).set(0, 5);
                        tabla.get(7).get(3).set(1, 1);
                    }
                    if (mutari.get(pozX).get(pozY) == -2) {
                        tabla.get(7).get(7).set(0, -1);
                        tabla.get(7).get(7).set(1, -1);
                        tabla.get(7).get(5).set(0, 5);
                        tabla.get(7).get(5).set(1, 1);
                    }
                    rocadaNegru = false;
                }
            }
        }
        else System.out.println("--------");
        if (mutari.get(pozX).get(0) == 1 && mutari.get(pozX).get(3) + mutari.get(pozX).get(pozY) == 7 && mutari.get(pozX).get(1) == 0)
        {
            tabla.get(7).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).set(0, 9);
            tabla.get(7).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).set(1, mutari.get(pozX).get(1));
        }
        if (mutari.get(pozX).get(0) == 1 && mutari.get(pozX).get(3) + mutari.get(pozX).get(pozY) == 0 && mutari.get(pozX).get(1) == 1)
        {
            tabla.get(0).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).set(0, 9);
            tabla.get(0).get(mutari.get(pozX).get(pozY) + mutari.get(pozX).get(3)).set(1, mutari.get(pozX).get(1));

        }

    }

    public int evaluate(byte b, byte b1) {
        int sum = 0, x = -1, y = -1, c = -1;
        if (tabla.get(mutari.get(b).get(b1 + 1) + mutari.get(b).get(2)).get(mutari.get(b).get(b1) + mutari.get(b).get(3)).get(1) != mutari.get(b).get(1))
            sum += (tabla.get(mutari.get(b).get(b1 + 1) + mutari.get(b).get(2)).get(mutari.get(b).get(b1) + mutari.get(b).get(3)).get(0));
        //daca luam o piesa adaugam punctajul
        if (mutari.get(b).get(b1) > 0)
            sum += 2;//daca ne apropiem de adversar
        for (int i = 0; i < mutari.size(); i++) {
            if (mutari.get(i).get(1) == mutari.get(b).get(1)) {
                for (int j = 0; j < mutari.get(i).size(); j += 2) {
                    if (mutari.get(i).get(2) + mutari.get(i).get(j + 1) == mutari.get(b).get(b1 + 1) + mutari.get(b).get(2))
                        if (mutari.get(i).get(3) + mutari.get(i).get(j) == mutari.get(b).get(b1) + mutari.get(b).get(3))
                            sum += 2;
                    //daca pozitia este aparata fitnessul creste
                }
            } else if (mutari.get(i).get(0) == 1000) {
                c = mutari.get(i).get(1);
                x = mutari.get(i).get(2);
                y = mutari.get(i).get(3);
            }
        }


        int X, Y, C;
        X = mutari.get(b).get(b1 + 1) + mutari.get(b).get(2);
        Y = mutari.get(b).get(b1) + mutari.get(b).get(3);
        C = mutari.get(b).get(1);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer >list2 = mutariRege(x, y, c);


        tabla.get(mutari.get(b).get(2)).get(mutari.get(b).get(3)).set(0,-1);
        tabla.get(mutari.get(b).get(2)).get(mutari.get(b).get(3)).set(1,-1);

        switch (mutari.get(b).get(0)) {
            case 1:
                list = mutariPion(X, Y, C);
                break;
            case 3:
                list = mutariNebun(X, Y, C);
                break;
            case 4:
                list = mutariCal(X, Y, C);
                break;
            case 5:
                list = mutariTura(X, Y, C);
                break;
            case 9:
                list = mutariRegina(X, Y, C);
                break;
        }
        for (int i = 4; i < list.size(); i += 2) {

            if (tabla.get(X + list.get(i + 1)).get(Y + list.get(i)).get(0) == 1000 && tabla.get(X + list.get(i + 1)).get(Y + list.get(i)).get(1) == c) {
                sum += 35;
                //daca mutarea viitoare da sah
                break;
            }
        }


        for (int i = 4; i < list2.size(); i += 2) {
            if (x + list2.get(i + 1) == X && y + list2.get(i) == Y) {
                if (list2.size()>8)
                sum += 10;
                //daca micsorez sansele de scapare ale regelui

            }
        }

        switch (mutari.get(b).get(0)) {
            case 1:
                list = mutariPion(X, Y, C);
                break;
            case 3:
                list = mutariNebun(X, Y, C);
                break;
            case 4:
                list = mutariCal(X, Y, C);
                break;
            case 5:
                list = mutariTura(X, Y, C);
                break;
            case 9:
                list = mutariRegina(X, Y, C);
                break;
        }
        mutari.add(list);
        Random random=new Random();
        if(random.nextInt()%2==1)
        for(int i=4;i<list.size();i+=2){
            sum+=(evaluate((byte) (mutari.size()-1),(byte)i)+1)/(float)(((float)list.size()-3)/4);
        }
        mutari.remove(mutari.size()-1);

        tabla.get(mutari.get(b).get(2)).get(mutari.get(b).get(3)).set(0,mutari.get(b).get(0));
        tabla.get(mutari.get(b).get(2)).get(mutari.get(b).get(3)).set(1,mutari.get(b).get(1));

        return sum;
    }




    public boolean mutare(int c) {

        mutari = new ArrayList<>();
        if (!sah(c))
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    switch (tabla.get(i).get(j).get(0)) {
                        case 1:
                            mutari.add(mutariPion(i, j, tabla.get(i).get(j).get(1)));
                            break;
                        case 3:
                            mutari.add(mutariNebun(i, j, tabla.get(i).get(j).get(1)));
                            break;
                        case 4:
                            mutari.add(mutariCal(i, j, tabla.get(i).get(j).get(1)));
                            break;
                        case 5:
                            mutari.add(mutariTura(i, j, tabla.get(i).get(j).get(1)));
                            break;
                        case 9:
                            mutari.add(mutariRegina(i, j, tabla.get(i).get(j).get(1)));
                            break;
                        case 1000:
                            mutari.add(mutariRege(i, j, tabla.get(i).get(j).get(1)));
                            break;
                    }
                }
            }
        else {
            int pozX = 0, pozY = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tabla.get(i).get(j).get(0) == 1000 && tabla.get(i).get(j).get(1) == c) {
                        pozX = i;
                        pozY = j;
                        i = 8;
                        break;
                    }
                }
            }
            mutari.add(mutariRege(pozX, pozY, c));
            if (mutari.size() == 4) {
                System.out.println("A castigat jucatorul " + c);
                return false;
            }

        }

        Random rand = new Random();
        boolean modificat;
        ArrayList<Byte> populatie = new ArrayList<>();
        for (int i = 0; i < mutari.size(); i++) {
            modificat = false;
            if (mutari.get(i).size() > 4 && mutari.get(i).get(1) == c) {
                for (int j = 4; j < mutari.get(i).size(); j += 2) {
                    int x = rand.nextInt(1000) % 3;
                    if (x == 2) {
                        modificat = true;
                        populatie.add((byte) i);
                        populatie.add((byte) j);
                    }
                }
                if (!modificat && mutari.get(i).size() > 4 && mutari.get(i).get(1) == c) {
                    populatie.add((byte) i);
                    populatie.add((byte) 4);
                }
            }
        }


        ArrayList<Integer> fitness = new ArrayList<>();
        for (int i = 0; i < populatie.size(); i += 2) {
            fitness.add(evaluate(populatie.get(i), populatie.get(i + 1)));
        }

        int t = 0;
        while (t < 10) {
            boolean done = false;
            while (!done) {
                done = true;
                for (int i = 0; i < populatie.size() - 2; i += 2) {

                    if (fitness.get(i / 2) > fitness.get(i / 2 + 1)) {
                        int tmp = fitness.get(i / 2);
                        fitness.set(i / 2, fitness.get(i / 2 + 1));
                        fitness.set(i / 2 + 1, tmp);
                        tmp = populatie.get(i);
                        populatie.set(i, populatie.get(i + 2));
                        populatie.set(i + 2, (byte) tmp);
                        tmp = populatie.get(i + 1);
                        populatie.set(i + 1, populatie.get(i + 3));
                        populatie.set(i + 3, (byte) tmp);
                        done = false;
                    }
                }
            }

            ///ordoneaza dupa fitness

            int n = fitness.size() * 40 / 100;
            //System.out.println("Numarul de indivizi care vor fi recombinati: "+n);

            for (int i = populatie.size(); i > populatie.size() - (n * 2); i -= 2) {
                if (rand.nextInt(100) % 3 == 1) {
                    int x = populatie.get(i - 1);
                    x = (x ^ (populatie.get(i - 3))) % mutari.get(populatie.get(i - 2)).size();
                    if (x < 4) x = 4;
                    if (x % 2 == 1) x = x - 1;
                    populatie.set(i - 3, (byte) x);
                    populatie.set(i - 4, populatie.get(i - 2));
                    i -= 2;
                } else {
                    int x = populatie.get(i - 1);
                    x = (x ^ (rand.nextInt(100))) % mutari.get(populatie.get(i - 2)).size();
                    if (x < 4) x = 4;
                    if (x % 2 == 1) x = x - 1;
                    populatie.set(i - 1, (byte) x);
                }
            }

            t++;
        }
        if(populatie.size()==0){
            System.out.println("Pat");}
        else{
            int tmp;
            if (populatie.size() > 4)
                tmp = rand.nextInt(populatie.size() - 2) % 10;
            else
                tmp = 0;
            if (tmp % 2 == 1) tmp++;
            if (c == 0)
                muta(populatie.get(tmp), populatie.get(tmp + 1));

            else muta(populatie.get(populatie.size() - 2), populatie.get(populatie.size() - 1));
        }

        return true;
    }


}
