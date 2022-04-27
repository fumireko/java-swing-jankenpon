public class Language {
    public String play1v1;
    public String player;
    public String playEasy;
    public String playHard;
    public String checkPrompt;
    public String scissors;
    public String paper;
    public String rock;
    public String invalidChoice;
    public String draw;
    public String win;
    public String computer;
    public String settings;
    public String leaveButton;

    public Language(int value) throws Exception {
        if(value == 0){ // Portuguese
            rock = "pedra";
            paper = "papel";
            scissors = "tesoura";

            player = "Jogador";
            computer = "Computador";

            win = "vence";
            draw = "Empate";

            play1v1 = "Dois jogadores";
            playEasy = "vs Computador - Fácil";
            playHard = "vs Computador - Difícil";
            settings = "Configurações";
            leaveButton = "Sair";

            checkPrompt = "digite pedra, papel ou tesoura";
            invalidChoice = "Opção Inválida!";
        }
        else if(value == 1){ // Spanish
            rock = "piedra";
            paper = "papel";
            scissors = "tijeras";

            player = "Jugador";
            computer = "Ordenador";

            win = "gaña";
            draw = "Empate";

            play1v1 = ("Dos jugadores");
            playEasy = ("vs Ordenador - Fácil");
            playHard = ("vs Ordenador - Difícil");
            settings = ("Ajustes");
            leaveButton = "Salir";

            checkPrompt = "escribie piedra, papel o tijera";
            invalidChoice = "Opción Inválida!";
        }
        else if(value == 2){ // Russia
            rock = "камень";
            paper = "бумага";
            scissors = "ножницы";

            player = "Плеер";
            computer = "Компьютер";

            win = "выигрывает";
            draw = "ничья";

            play1v1 = ("два игрока");
            playEasy = ("против компьютера - легко");
            playHard = ("против компьютера - сложно");
            settings = ("Настройки");
            leaveButton = "X";

            checkPrompt = "Вы должны набрать камень, бумага или ножницы";
            invalidChoice = "недействительный вариант";
        }
        else if(value == 3){ // Japanese
            rock = "石";
            paper = "紙";
            scissors = "はさみ";

            player = "プレイヤー";
            computer = "コンピュータ";

            win = "の勝ち";
            draw = "引き分け";

            play1v1 = ("二人のプレーヤー");
            playEasy = ("対コンピュータ - (イージー)");
            playHard = ("対コンピュータ - (ハード)");
            settings = ("設定");
            leaveButton = "X";

            checkPrompt = "ジャンケンしてください";
            invalidChoice = "無効な選択肢";
        }
        else if(value == 4){ // English
            rock = "rock";
            paper = "paper";
            scissors = "scissors";

            player = "Player";
            computer = "Computer";

            win = "wins";
            draw = "Draw";

            play1v1 = ("Two Players");
            playEasy = ("vs Computer - Easy");
            playHard = ("vs Computer - Hard");
            settings = ("Settings");
            leaveButton = "Leave";

            checkPrompt = "please type rock, paper or scissors";
            invalidChoice = "Invalid choice!";
        }
        else throw new Exception("InvalidLanguageException");
    }
}
