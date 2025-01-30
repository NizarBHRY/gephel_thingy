import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        MaxFinder f = new MaxFinder();
        Scanner number = new Scanner(System.in);
        //Fisrst line of inputs
        int rows = number.nextInt();
        int colums = number.nextInt();
        int lastElev = number.nextInt();
        int cmds = number.nextInt();
        //Row column
        int[][] pasture = new int[rows][colums];
        for(int i = 0; i<rows;i++){
            for (int j=0;j<colums;j++){
                pasture[i][j]=number.nextInt();
            }
        }
        //commands
        int[][] coms = new int[cmds][3];
        for(int i = 0; i<cmds;i++){
            for (int j=0;j<3;j++){
                coms[i][j]=number.nextInt();
            }
        }
        //applying the commands
        for (int i =0; i<cmds; i++){
            int x = coms[i][0];
            int y = coms[i][1];
            int sub =coms[i][2];
            int[][] herd = new int[3][3];
            for(int j =0;j<3;j++){
                for(int v =0;v<3;v++){
                    herd[j][v] = pasture[(x-1)+j][(y-1)+v];
                }
            }
            int max = f.findmax(herd);
            int lowest = max-sub;
            for(int b = 0; b<3;b++){
                for (int u = 0; u<3; u++){
                    if (herd[b][u]>lowest){
                        herd[b][u] = lowest;
                    }
                }
            }
            //reassigning the now changed hights
            for(int j =0;j<3;j++){
                for(int v =0;v<3;v++){
                    pasture[(x-1)+j][(y-1)+v] = herd[j][v];
                }
            }
        }
        //now to do the hight thing
        for(int i = 0; i<rows;i++) {
            for (int j = 0; j < colums; j++) {
                if (pasture[i][j] - lastElev > 0) {
                    pasture[i][j] = 0;
                }else{
                    pasture[i][j] = -1*(pasture[i][j]-lastElev);
                }
            }
        }
        //finally add up all the valus and multiply
        int total=0;
        for(int i = 0; i<rows;i++){
            for (int j=0;j<colums;j++){
                total += pasture[i][j];
            }
        }
        System.out.println(72*72*total);

    }
}