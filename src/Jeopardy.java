/***********************************************************************
 Note:  the code is below.  Download and compile EasyApp prior to compiling Jeopardy.


 To Do List

 (1) Add buttons for at least 3 questions in each category (100, 200, 300) -that makes a total of 12 questions. Make sure each button is disabled after use, and that it adds or subtracts the correct amount.  !!! Make sure your topics are significantly more interesting than the existing categories!!!

 Improve the ANSWER algorithm(s):
 // (2) Change the IF commands so they accept both CAPITAL and small letters.
 (3) Add a HINT for each question by telling:
 (a) the FIRST LETTER of the answer and
 (b) the number of letters in the answer
 (4) Use some STRING commands to:
 (a) make the scoring NON-case-sensitive
 (b) accept an answer as long as the first 3 letters and the last
 letter are correct - thus, it would ignore some spelling mistakes.
 (c) Allow the person to guess again if their answer is PART OF
 (contained in) the correct answer.

 Make a better game:
 Change the game to be played by 2 players. This means there must be a variable to keep track of which player is answering, and that must switch automatically between the two players after each question.

 There must also be 2 variables for scores (scoreA and scoreB), as well as two TextField boxes for displaying the scores.  Then change the program so that if a player gets a question correct, they get another turn.  They should keep playing until they give an incorrect answer.

 Add a "poison" question.  This doesn't ask a question - instead, the player automatically loses money - and loses their turn.

 Add a "Daily Double" question, where the player can "bet" as much money as they wish, up to the amount they currently have.  So if the player has 500, they can be 500 or less.  They must bet before they see the question.  Then they lose or win the amount they bet - not the amount showing on the button.

 Choose random questions from a group of 3 questions in each category.  Do this the easy way, and don't try to stop repeat questions - e.g. the same question might be asked twice if the player is lucky.  Something like this:
 int rand = (int)(Math.random()*3);
 if (rand == 0)
 {  String ans = input("How many eggs in a dozen?");
 if (ans == "12")
 { output("right");
 money = money + 100;
 }
 else
 {
 output("wrong");
 money = money - 100;
 }
 }
 if (rand == 1)
 { ..... }
 if (rand == 2)
 { ..... }

 Add anything else you can think of to make the best program you can.

 *********************************************************************/




import java.awt.*;

public class Jeopardy extends EasyApp {
    public static void main(String[] args) {
        new Jeopardy();
    }

    int player1Score = 0;
    int player2Score = 0;
    int currentPlayer = 1;

    Label lJeopardy = addLabel("Jeopardy", 60, 30, 200, 60, this);
    Label lCurrentPlayer = addLabel("P" + currentPlayer, 450, 58, 20, 20,this);

    Label l1Score = addLabel("P1 Score", 290, 40, 60, 30, this);
    TextField t1Score = addTextField("0", 350, 40, 80, 30, this);

    Label l2Score = addLabel("P2 Score", 290, 70, 60, 30, this);
    TextField t2Score = addTextField("0", 350, 70, 80, 30, this);

    Button bScience = addButton("Science 100", 50, 100, 100, 50, this);
    Button bSports = addButton("Sports 100", 150, 100, 100, 50, this);
    Button bHistory = addButton("History 100", 250, 100, 100, 50, this);
    Button bMath = addButton("Math 100", 350, 100, 100, 50, this);

    Button b2Science = addButton("Science 200", 50, 150, 100, 50, this);
    Button b2Sports = addButton("Sports 200", 150, 150, 100, 50, this);
    Button b2History = addButton("History 200", 250, 150, 100, 50, this);
    Button b2Math = addButton("Math 200", 350, 150, 100, 50, this);

    Button b3Science = addButton("Science 300", 50, 200, 100, 50, this);
    Button b3Sports = addButton("Sports 300", 150, 200, 100, 50, this);
    Button b3History = addButton("History 300", 250, 200, 100, 50, this);
    Button b3Math = addButton("Math 300", 350, 200, 100, 50, this);

    Button b4Science = addButton("Science 400", 50, 250, 100, 50, this);
    Button b4Sports = addButton("Sports 400", 150, 250, 100, 50, this);
    Button b4History = addButton("History 400", 250, 250, 100, 50, this);
    Button b4Math = addButton("Math 400", 350, 250, 100, 50, this);

    Button bPlayAgain = addButton("Play again", 50, 300, 400, 50, this);

    double score = 0;

    public Jeopardy()   // Constructor - change window appearance
    {

        setSize(500, 500);
        setTitle("Jeopardy");
        lJeopardy.setFont(new Font("Arial", 1, 36));
        lJeopardy.setBackground(new Color(255, 255, 180));
        lJeopardy.setForeground(Color.blue);
        lCurrentPlayer.setFont(new Font("Arial", 1, 16));
        lCurrentPlayer.setBackground(new Color(255, 255, 180));
        l1Score.setBackground(new Color(255, 255, 180));
        l2Score.setBackground(new Color(255, 255, 180));
        setBackground(new Color(255, 255, 180));

        bScience.setFont(new Font("Arial", 1, 16));
        bMath.setFont(new Font("Arial", 1, 16));
        bHistory.setFont(new Font("Arial", 1, 16));
        bSports.setFont(new Font("Arial", 1, 16));

        b2Science.setFont(new Font("Arial", 1, 16));
        b2Sports.setFont(new Font("Arial", 1, 16));
        b2History.setFont(new Font("Arial", 1, 16));
        b2Math.setFont(new Font("Arial", 1, 16));

        b3Science.setFont(new Font("Arial", 1, 16));
        b3Sports.setFont(new Font("Arial", 1, 16));
        b3History.setFont(new Font("Arial", 1, 16));
        b3Math.setFont(new Font("Arial", 1, 16));

        b4Science.setFont(new Font("Arial", 1, 16));
        b4Sports.setFont(new Font("Arial", 1, 16));
        b4History.setFont(new Font("Arial", 1, 16));
        b4Math.setFont(new Font("Arial", 1, 16));

        bPlayAgain.setFont(new Font("Arial", 1, 16));

    }

    public void score(int s) {
        if (currentPlayer == 1) {
            player1Score += s;
        } else {
            player2Score += s;
        }
    }

    public void switchPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    public void actions(Object source, String command) {
        if (source == bScience) {
            science();
        }
        if (source == bSports) {
            sports();
        }
        if (source == bHistory) {
            history();
        }
        if (source == bMath) {
            math();
        }
        if (source == b2Science) {
            science2();
        }
        if (source == b2Sports) {
            sports2();
        }
        if (source == b2History) {
            history2();
        }
        if (source == b2Math) {
            math2();
        }
        if (source == b3Science) {
            science3();
        }
        if (source == b3Sports)
            sports3();
        if (source == b3History) {
            history3();
        }
        if (source == b3Math) {
            math3();
        }
        if (source == b4Science) {
            science4();
        }
        if (source == b4Sports) {
            sports4();
        }
        if (source == b4History) {
            history4();
        }
        if (source == b4Math) {
            math4();
        }
        if (source == bPlayAgain) {
            bScience.setEnabled(true);
            bHistory.setEnabled(true);
            bSports.setEnabled(true);
            bMath.setEnabled(true);

            b2Science.setEnabled(true);
            b2History.setEnabled(true);
            b2Sports.setEnabled(true);
            b2Math.setEnabled(true);

            b3Science.setEnabled(true);
            b3History.setEnabled(true);
            b3Sports.setEnabled(true);
            b3Math.setEnabled(true);

            b4Science.setEnabled(true);
            b4History.setEnabled(true);
            b4Sports.setEnabled(true);
            b4Math.setEnabled(true);
            player1Score = 0;
            player2Score = 0;
            currentPlayer = 1;
        }
        t1Score.setText(player1Score + "");
        t2Score.setText(player2Score + "");
        lCurrentPlayer.setText("P" + currentPlayer);
    }

    public void science() {
        String guess = inputString("f = ma is a ________ law \n The first letter is P \n The answer is 7 letters");
        if (guess.equalsIgnoreCase("physics")) {
            score(100);
            output("Right!");
        } else {
            score(-100);
            switchPlayer();
            output("Wrong...");
        }


        bScience.setEnabled(false);
    }

    public void science2() {
        String guess = inputString("What part of the cell is known as the powerhouse?");
        if (guess.equalsIgnoreCase("mitochondria")) {
            score(200);
            output("Right!");
        } else {
            score(-200);
            switchPlayer();
            output("Wrong...");
        }


        b2Science.setEnabled(false);
    }

    public void science3() {
        String guess = inputString("What is the chemical symbol for gold?");
        if (guess.equalsIgnoreCase("au")) {
            score(300);
            output("Right!");
        } else {
            score(-300);
            switchPlayer();
            output("Wrong...");
        }


        b3Science.setEnabled(false);
    }

    public void science4() {
        String guess = inputString("What scientist developed the three laws of motion?");
        if (guess.equalsIgnoreCase("Isaac Newton")) {
            score(400);
            output("Right!");
        } else {
            score(-400);
            switchPlayer();
            output("Wrong...");
        }

        b4Science.setEnabled(false);
    }

    public void sports() {
        String guess = inputString("What sport did Pele play?");
        if (
                guess.equalsIgnoreCase("soccer")
                        || guess.equalsIgnoreCase("football")
                        || guess.equalsIgnoreCase("fussball")
        )   // || or
        {
            score(100);
            output("Right!");
        } else {
            score(-100);
            switchPlayer();
            output("Wrong...");
        }

        bSports.setEnabled(false);
    }

    public void sports2() {
        int guess = inputInt("What is a perfect score in bowling?");
        if (guess == 300) {
            score(200);
            output("Right!");
        } else {
            score(-200);
            switchPlayer();
            output("Wrong...");
        }
        b2Sports.setEnabled(false);
    }

    public void sports3() {
        String guess = inputString("What sport did Pele play?");
        if (
                guess.equalsIgnoreCase("soccer")
                        || guess.equalsIgnoreCase("football")
                        || guess.equalsIgnoreCase("fussball")
        )   // || or
        {
            score(300);
            output("Right!");
        } else {
            score(-300);
            switchPlayer();
            output("Wrong...");
        }
        b3Sports.setEnabled(false);
    }

    public void sports4() {
        String guess = inputString("What sport did Pele play?");
        if (
                guess.equalsIgnoreCase("soccer")
                        || guess.equalsIgnoreCase("football")
                        || guess.equalsIgnoreCase("fussball")
        )   // || or
        {
            score(400);
            output("Right!");
        } else {
            score(-400);
            switchPlayer();
            output("Wrong...");
        }
        b4Sports.setEnabled(false);
    }

    public void history2() {
        int guess = inputInt("What year did WW II end?");
        if (guess == 1945) {
            score(200);
            output("Right!");
        } else {
            score(-200);
            switchPlayer();
            output("Wrong...");
        }
        b2History.setEnabled(false);
    }

    public void history3() {
        int guess = inputInt("What year did WW II end?");
        if (guess == 1945) {
            score(300);
            output("Right!");
        } else {
            score(-300);
            switchPlayer();
            output("Wrong...");
        }
        b3History.setEnabled(false);
    }

    public void history4() {
        String guess = inputString("Who was the U.S. President during the Great Depression and World War II");
        if (
                guess.equalsIgnoreCase("Roosevelt")
                        || guess.equalsIgnoreCase("Franklin Roosevelt")
                        || guess.equalsIgnoreCase("Franklin D Roosevelt")
        )   // || or
        {
            score(400);
            output("Right!");
        } else {
            score(-400);
            switchPlayer();
            output("Wrong...");
        }
        b4History.setEnabled(false);
    }

    public void history() {
        int guess = inputInt("What year did WW II end?");
        if (guess == 1945) {
            score(100);
            output("Right!");
        } else {
            score(-100);
            switchPlayer();
            output("Wrong...");
        }
        bHistory.setEnabled(false);
    }

    public void math() {
        int guess = inputInt("What is 5! ?");
        if (guess == 120) {
            score(100);
            output("Right!");
        } else {
            score(-100);
            switchPlayer();
            output("Wrong...");
        }
        bMath.setEnabled(false);
    }

    public void math2() {
        int guess = inputInt("If a train travels 60 miles in 1.5 hours, what is its average speed in mph?");
        if (guess == 40) {
            score(200);
            output("Right!");
        } else {
            score(-200);
            switchPlayer();
            output("Wrong...");
        }
        b2Math.setEnabled(false);
    }

    public void math3() {
        int guess = inputInt("What is the square root of 169?");
        if (guess == 13) {
            score(300);
            output("Right!");
        } else {
            score(-300);
            switchPlayer();
            output("Wrong...");
        }
        b3Math.setEnabled(false);
    }

    public void math4() {
        int guess = inputInt("What is 5! ?");
        if (guess == 120) {
            score(400);
            output("Right!");
        } else {
            score(-400);
            switchPlayer();
            output("Wrong...");
        }
        b4Math.setEnabled(false);
    }
}


