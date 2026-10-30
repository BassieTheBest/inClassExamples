package inClassOct28;

public class Eval {

	public static void main(String[] args) {
		char[][] board = {
				{'x','x','x','o','o','o','x','x'},
				{'x','x','x','x','x','x','x','x'},
				{'x','x','x','o','o','o','o','x'},
				{'x','x','x','x','o','x','x','x'},
				{'x','x','x','x','x','x','x','x'},
				{'x','x','x','x','o','o','x','x'},
				{'x','x','o','o','o','o','o','o'},
				{'x','x','x','o','o','x','x','x'}};
		Sequence[] sequences = new Sequence[100];
		int count=0;

	
		horizontalScan(board,sequences,count);
	
	}
	
	public static void horizontalScan(char[][] array, Sequence[] sequences, int count) {
		int row, col;
		
		for(row=0;row<array.length;row++) {
				count=sequences(array[row],sequences,count);
		}
		show(sequences,count);
		
	}
	
	public static void show(Sequence[] sequences, int count) {
		int index;
		
		for(index=0;index<count;index++) {
			System.out.printf("Start: %d End: %d Char: %c Length: %d\n", sequences[index].start,
					sequences[index].end,sequences[index].ch,sequences[index].length);
		}
	}
	
	public static int sequences(char[] array, Sequence[] sequences, int count) {
		int start=0;
		int end=0;
	
		while(end<array.length) {
			if(array[start]==array[end] && (end-start<5)) {
				end++;
			}else {
				//System.out.printf("Start: %d End: %d Char: %c\n", start,end-1,array[start]);
				if(end-start>2 && array[start]=='o') {
					sequences[count++]=new Sequence(start,end-1,array[start]);
				}
				start=end;
			}
		}
		//System.out.printf("Start: %d End: %d Char: %c\n", start,end-1,array[start]);
		if(end-start>2 && array[start]=='o') {
			sequences[count++]=new Sequence(start,end-1,array[start]);
		}
		return count;
	}

}
