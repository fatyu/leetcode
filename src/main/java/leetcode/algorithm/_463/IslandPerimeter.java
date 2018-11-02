package leetcode.algorithm._463;

/**
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 Grid cells are connected horizontally/vertically (not diagonally).
 The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 The island doesn't have"lakes"(water inside that isn't connected to the water around the island).
 One cell is a square with side length 1.
 The grid is rectangular, width and height don't exceed 100.
 Determine the perimeter of the island.
 Example:
 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:
 <img src="https://leetcode.com/static/images/problemset/island.png"></img>
 一个单元格周长是4，计算被设置为1的方块的周长。注意：一个被设置为1的单元格相邻如果有一个被设置为1，相邻的就会减少2
 判断上一个单元格，和左侧单元格是不是为1，如果为1则减少2
 */
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int sum = 0;
		int divide = 0;
		int y = grid[0].length;
		int x = grid.length;

		for (int i = x - 1; i >= 0; i--) {
			for (int j = y - 1; j >= 0; j--) {
				if (grid[i][j] == 1) {
					sum += 4;
					//判断左侧节点
					if (j > 0) {
						if (grid[i][j - 1] == 1) {
							divide += 2;
						}
					}
					//判断上侧节点
					if (i > 0) {
						if (grid[i - 1][j] == 1) {
							divide += 2;
						}
					}
				}

			}
		}
		return sum - divide;
	}

	public static void main(String[] args) {
		IslandPerimeter ilp = new IslandPerimeter();
		int[][] data = {{1, 0, 0, 1}, {0, 0, 1, 0}};
		System.out.println(ilp.islandPerimeter(data));
		;
	}
}
