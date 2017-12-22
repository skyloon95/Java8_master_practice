package kr.devdogs.omok.ingame;

public class Stone {
	public static byte[][] stone = new byte[Main.CROSS_POINT][Main.CROSS_POINT];	//	바둑판 매트릭스
	private static boolean color = false;	//	 직전에 놓 돌의 색
	
	//	실좌표로 변경 리턴
	public static float getCoordinateX(int x) {
		float corX;

		corX = Main.BOARDLINE_START_WIDTH + Main.LINE_SPACE*x - Main.STONE_SIZE/2;

		return corX;
	}

	//	실좌표로 변경 리턴
	public static float getCoordinateY(int y) {
		float corY;

		corY = Main.BOARDLINE_START_HEIGHT + Main.LINE_SPACE*y - Main.STONE_SIZE/2;

		return corY;
	}
	
	public static boolean getColor() {
		return color;
	}
	
	//	돌 놓기
	public static boolean putStone(int x, int y, boolean clr) {
		color = clr;
		//	비어있는 경우 돌 놓기 실행
		if(isEmpty(x,y)){
			if(color) {
				stone[x][y] = 2;
				color = false;	//	 돌을 놓고 난 뒤 다음놓아질 돌을 위해 색 변경.
			}
			else {
				stone[x][y] = 1;
				color = true;
			}
			return true;
		}
		else
			return false;
	}
	
	//	해당 위치가 비었는지 확인
	private static boolean isEmpty(int x, int y) {
		if(stone[x][y]==0)
			return true;
		else
			return false;
	}

	public static void resetMatrix() {
		for(int i = 0 ; i < stone.length ; ++i) {
			for(int j = 0 ; j < stone.length ; ++j)
				stone[i][j]=0;
		}
	}
}
