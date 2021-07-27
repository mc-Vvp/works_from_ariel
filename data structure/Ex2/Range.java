package range;

public class Range {

	private int[] CountTimesArr;

	public Range(int[] a,int k) {
		this.CountTimesArr = new int[k+1];
		for(int i=0;i<a.length;i++) {
			CountTimesArr[a[i]]++;
		}
		int index = 0;
		for(int i=0;i<=k;i++) {
			index = index+CountTimesArr[i];
			CountTimesArr[i] = index;
		}
	}
	public int query(int a, int b) {
		int x = 0;
		if(a-1>=0)
			if(CountTimesArr[a-1]!=CountTimesArr[a])
				x++;
		return CountTimesArr[b]-CountTimesArr[a]+x;
	}

}
