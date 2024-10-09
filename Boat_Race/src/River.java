import java.util.ArrayList;

public class River {
	//attributes
	private String difficultyLevel;
    private Externals[] riverBoard = new Externals[100];
    private ArrayList<Externals> riverExternals;

    //constructor
    public River() {
        generateTrack();
    }

    //setters/getters
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        generateTrack();
    }

    public Externals[] getRiverBoard() {
        return riverBoard;
    }

    public void printRiverBoard() {
        System.out.print("    ");

        for (int i = 0; i < riverBoard.length / 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int i = 0; i < riverBoard.length / 10; i++) {
            System.out.print(" " + i + "  ");
            for (int j = 0; j < riverBoard.length / 10; j++) {
                if (riverBoard[i * 10 + j] instanceof Initialisation) {
                    System.out.print(".  ");
                } else if (riverBoard[i * 10 + j] instanceof Currents) {
                    riverBoard[i * 10 + j].generateMagnitude();
                    System.out.print("C  ");
                } else if (riverBoard[i * 10 + j] instanceof Traps) {
                    riverBoard[i * 10 + j].generateMagnitude();
                    System.out.printf("T  ");
                }
            }
            if (i == riverBoard.length / 10 - 1) {
                System.out.print("END");
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printRiverItem() {
        for (Externals riverExternal : riverExternals) {
            if (riverExternal instanceof Initialisation) {
                System.out.print(".");
            } else if (riverExternal instanceof Currents) {
                System.out.printf("C[%d]", riverExternal.getPosition());
            } else if (riverExternal instanceof Traps) {
                System.out.printf("T[%d]", riverExternal.getPosition());
            }
        }
        System.out.print(".");
    }

    private void generateRiverItems(int blankNum, int currentNum, int trapNum) {
    	riverExternals = new ArrayList<Externals>();
        int total_ratio = blankNum + currentNum + trapNum;

        for (int i = 0; i < (currentNum * 100) / total_ratio; i++) {
            Externals temp = new Currents();
            boolean positionValid = false;

            while (!positionValid) {
                int counter = 0;
                for (Externals riverExternal : riverExternals) {
                    if (temp.getPosition() != riverExternal.getPosition()) {
                        counter++;
                    } else {
                        temp = new Currents();
                        break;
                    }
                }

                if (counter == riverExternals.size()) {
                	riverExternals.add(temp);
                    positionValid = true;
                }
            }
        }

        for (int i = 0; i < (trapNum * 100) / total_ratio; i++) {
            Externals temp = new Traps();
            boolean positionValid = false;
            while (!positionValid) {
                int counter = 0;
                for (Externals riverExternal : riverExternals) {
                    if (temp.getPosition() != riverExternal.getPosition()) {
                        counter++;
                    } else {
                        temp = new Traps();
                        break;
                    }
                }

                if (counter == riverExternals.size()) {
                	riverExternals.add(temp);
                    positionValid = true;
                }
            }
        }
    }

    private void generateTrack() {
        if (difficultyLevel == null) {
            generateRiverItems(1, 0, 0);
        } else if (difficultyLevel.equals("1")) {
            generateRiverItems(5, 3, 1);
        } else if (difficultyLevel.equals("2")) {
            generateRiverItems(4, 2, 1);
        } else if (difficultyLevel.equals("3")) {
            generateRiverItems(3, 1, 1);
        }

        // generate currents and traps in river
        for (int i = 0; i < riverBoard.length; i++) {
            riverBoard[i] = new Initialisation();
        }
        // insert currents and traps into riverBoard
        for (Externals riverExternal : riverExternals) {
            riverBoard[riverExternal.getPosition()] = riverExternal;
        }

        while (!checkRiver()) {
            generateTrack();
        }
    }

    //boolean
    public boolean checkRiver() {
        int count = 0;
        for (int i = 0; i < riverBoard.length - 1; i++) {
            if (riverBoard[i] instanceof Traps && riverBoard[i + 1] instanceof Traps) {
                count++;
            } else {
                count = 0;
            }
        }
        return (count < 5) ? true : false;
    }

}
