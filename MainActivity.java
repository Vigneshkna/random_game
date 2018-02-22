@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_rock = (Button) findViewById(R.id.b_rock);
        iv_computerChoice = (ImageView) findViewById(R.id.iv_computerChoice);
        iv_humanChoice = (ImageView) findViewById(R.id.iv_humanChoice);
        tv_score = (TextView) findViewById(R.id.tv_score);
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_humanChoice.setImageResource(R.drawable.hand);
                String message = play_turn("paper");
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human : "+Integer.toString(HumanScore)+
                        " Computer: "+ Integer.toString(ComputerScore));

            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_humanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
               // Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human : "+Integer.toString(HumanScore)+
                        " Computer: "+ Integer.toString(ComputerScore));
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_humanChoice.setImageResource(R.drawable.scissor);
                String message = play_turn("scissors");
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human : "+Integer.toString(HumanScore)+
                        " Computer: "+ Integer.toString(ComputerScore));
            }
        });
    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;
        if (computer_choice_number == 1) {
            computer_choice = "rock";
        } else if (computer_choice_number == 2) {
            computer_choice = "scissors";
        } else if (computer_choice_number == 3) {
            computer_choice = "paper";
        }
        if (computer_choice == "rock") {
            iv_computerChoice.setImageResource(R.drawable.rock);
        } else if (computer_choice == "paper") {
            iv_computerChoice.setImageResource(R.drawable.hand);
        } else if (computer_choice == "scissors") {
            iv_computerChoice.setImageResource(R.drawable.scissor);
        }
        if (computer_choice == player_choice) {
            return "Draw. No One Wins.";
        } else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "Rock Crushed Scissor.You Win!";
        } else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Paper Covers Rock.Computer Wins!";
        } else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Rock Crushed Scissor.Computer Win!";
        } else if (player_choice == "scissors" && computer_choice == "paper") {
            ComputerScore++;
            return "Scissor Cut Paper.Computer Win!";
        } else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Paper Covers Rock.You Win!";
        } else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Scissor Cuts Paper.Computer Win!";
        } else return "Not Sure";
    }
}
