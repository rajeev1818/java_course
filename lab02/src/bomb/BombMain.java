package bomb;

import common.IntList;

import java.util.Random;

public class BombMain {
    public static void main(String[] args) {
        int phase = 2;
        String password="";
        for(int i=0;i<1339;i++){
            if(i==1337){
                password+="-81201430";
                password+=" ";
            }
            else{
                password+= 'a';
                password+=" ";
            }

        }
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct passwords to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            b.phase1(IntList.of(0,9,3,0,8));
        }
        if (phase >= 2) {
            b.phase2(password);
        }
    }
}
