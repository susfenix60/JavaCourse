package pl.susfenix.course.backend.game.tictactoe.model;

public class TicTacToeGameState {
    private Board board;
    private Player currentPlayer;
    private GameResult gameResult;

    public TicTacToeGameState(){
        this.board = new Board();
        this.currentPlayer = Player.X;
        this.gameResult = new GameResult(GameStatus.INICIALAZED, "new game started. current player is: " + currentPlayer.getSymbol());
    }

    public TicTacToeGameState(Board board, Player player, GameResult gameResult){
        this.board = new Board(board);
        this.currentPlayer = player;
        this.gameResult = gameResult;
    }

    public TicTacToeGameState(TicTacToeGameState otherGameState){
        this.board = new Board(otherGameState.board);
        this.currentPlayer = otherGameState.getCurrentPlayer();
        this.gameResult = new GameResult(otherGameState.getGameResult());
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    public GameResult getGameResult(){return this.gameResult;}
    public Board getBoard(){return this.board;}

}
