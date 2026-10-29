package inClassOct28;

public class Eval {

	public static void main(String[] args) {
		String str = "xxxooxxo";
		char[] array = str.toCharArray();
		Sequence[] sequences;
		
		sequences=sequences(array);
		show(sequences);
		
	}
	
	public static void show(Sequence[] sequences) {
		int index;
		
		for(index=0;index<sequences.length;index++) {
			System.out.printf("Start: %d End: %d Char: %c Length: %d\n", sequences[index].start,
					sequences[index].end,sequences[index].ch,sequences[index].length);
		}
	}
	
	public static Sequence[] sequences(char[] array) {
		Sequence[] sequences;
		int start=0;
		int end=0;
		int count=0;
		
		///Count Sequences
		while(end<array.length) {
			if(array[start]==array[end] && (end-start<5)) {
				end++;
			}else {
				count++;
				start=end;
			}
		}
		sequences = new Sequence[count+1];
		
		start=0;
		end=0;
		count=0;
		while(end<array.length) {
			if(array[start]==array[end] && (end-start<5)) {
				end++;
			}else {
				//System.out.printf("Start: %d End: %d Char: %c\n", start,end-1,array[start]);
				sequences[count++]=new Sequence(start,end-1,array[start]);
				start=end;
			}
		}
		//System.out.printf("Start: %d End: %d Char: %c\n", start,end-1,array[start]);
		sequences[count++]=new Sequence(start,end-1,array[start]);
		return sequences;
	}

}
