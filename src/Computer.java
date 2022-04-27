public class Computer {

    Player j;
    boolean hard;
    static String choice;

    Computer(boolean hard, Player j){
        if(!hard) choose();
        else this.hard = hard;

        this.j = j;
    }

    public String choose(){
        if(!hard){
            if((int) ((Math.random() * 1000)% 3) == 0)
                setChoice(Main.language.rock);
            if((int) ((Math.random() * 1000)% 3) == 1)
                setChoice(Main.language.paper);
            if((int) ((Math.random() * 1000)% 3) == 2)
                setChoice(Main.language.scissors);
        }
        else{
            if(j.getChoice().equals(Main.language.rock))
                setChoice(Main.language.paper);
            if(j.getChoice().equals(Main.language.paper))
                setChoice(Main.language.scissors);
            if(j.getChoice().equals(Main.language.scissors))
                setChoice(Main.language.rock);
        }
        return getChoice();
    }

    public String getChoice() {
        return choice;
    }
    public void setChoice(String a) {
       choice = a;
    }
    public String getName() {
        return Main.language.computer;
    }
}
