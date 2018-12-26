package Marathon;


import Marathon.party.Cat;
import Marathon.party.Human;

class Team {
     private String[] cati={"Васька","Мурзик"};
     private String[] hum={"Миша","Петя"};
    public Competitor[] competitors=new Competitor[4];
    public Team() {
        for (int j=0; j<competitors.length; j++) {
            for (int i = 0; i < hum.length; i++) {
                competitors[j]=new Human(hum[i]);
                j++;
            }
            for (int i = 0; i < cati.length; i++) {
                competitors[j]=new Cat(cati[i]);
                j++;
            }
        }
    }
    public void showResults() {
        for (Competitor teamd : competitors) {
            teamd.info();
        }
    }
    }

