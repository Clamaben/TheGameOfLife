package zzy.inventorySystem.Control;

public class cellarrays {
	private int[] direct = {-1, 0, 1};
	public int cells[][];
	private int row,col;
	public cellarrays() {
	}
	public cellarrays(int row,int col) {
		this.row=row;
		this.col=col;
		this.cells=new int[row][col];
	}
	public int getRow() {
		return this.row;
	}
	public int[][] getcells() {
		return this.cells;
	}
	public boolean setRow( int row) {
		this.row=row;
		return true;
	}
	public int getCol() {
		return this.col;
	}
	public boolean setCol( int col) {
		this.col=col;
		return true;
	}
	public int getCell(int x, int y) {
        if (x < 0 || this.row <= x || y < 0 || this.col <= y) {
            return -1;
        }
        return this.cells[x][y];
    }
    public boolean setCell(int x, int y, int cell) {
        if (x < 0 || this.row <= x || y < 0 || this.col <= y) {
            return false;
        }
        this.cells[x][y] = cell;
        return true;
    }
    private int countLiveNeighbor(cellarrays now, int x, int y) {
        int count = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (CellState.LIVE.getValue() == now.getCell(x + this.direct[i], y + this.direct[j])) {
                    ++count;
                }
            }
        }
        if (CellState.LIVE.getValue() == now.getCell(x, y)) {
            --count;
        }
        return count;
    }
    public cellarrays multiply_once(cellarrays now) {
    	 if (null == now) {
             return null;
         }
         int liveCount;
         cellarrays next = new cellarrays(now.getRow(), now.getCol());
         for (int i = 0; i < next.getRow(); ++i) {
             for (int j = 0; j < next.getCol(); ++j) {
                 liveCount = this.countLiveNeighbor(now, i, j);
                 if (CellState.LIVE.getValue() == now.getCell(i, j) && (liveCount < 2 || liveCount > 3)) { //人口过少,人口过多
                     next.setCell(i, j, CellState.DEAD.getValue());
                 } else if (CellState.LIVE.getValue() == now.getCell(i, j) && (2 <= liveCount && liveCount <= 3)) { //正常
                     next.setCell(i, j, CellState.LIVE.getValue());
                 } else if (CellState.DEAD.getValue() == now.getCell(i, j) && (3 == liveCount)) { //繁殖
                     next.setCell(i, j, CellState.LIVE.getValue());
                 }
             }
         }
         return next;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        cellarrays other = (cellarrays) obj;
        if (this.row != other.getRow() || this.col != other.getCol()) return false;
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.col; ++j) {
                if (this.cells[i][j] != other.getCell(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
