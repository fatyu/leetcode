package leetcode._292;

/**
 *  You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
 *  The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 *	Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *	For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 *
 *  https://en.wikipedia.org/wiki/Nim
 */
public class NimGame {

	//解决问题的关键 找寻必胜规律
	// heap stoneNum == 1  first gamer win
	// heap stoneNum == 2  first gamer win
	// heap stoneNum == 3  first gamer win
	// heap stoneNum == 4  second gamer win
	// heap stoneNum == 5  first gamer win
	// heap stoneNum == 6  first gamer win
	// heap stoneNum == 7  first gamer win
	// heap stoneNum == 8  second gamer win
	// ...
	// ...

	public boolean canWinNim(int n) {
		return n % 4 > 0;
	}

	public static void main(String[] args) {
		NimGame nimGame = new NimGame();
		for (int i = 0; i < 100; i++) {
			System.out.println("heap stone number is " + i + ",can you win? ->" + nimGame.canWinNim(i));
		}
	}
}
