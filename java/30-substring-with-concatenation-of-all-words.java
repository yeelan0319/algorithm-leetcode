public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<Integer>();

		//注意word的输入不是List，而是String[]，所以不用get，size和iterator
		if(s == null || s.length() == 0 || words.length == 0) return ret;
		int m = words[0].length();
		int n = s.length();
		if(n < m * words.length) return ret;

		//根据题目有可能会出现test("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}, Arrays.asList(8));
		//也就是重复单词的情况，所以不可以使用Boolean，而是必须使用int来count
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(String t : words){
			hm.put(t, hm.containsKey(t)? hm.get(t) + 1 : 1);
		}
    //循环只需要在0~m-1之中就可以了，里面循环的次数才是n/m
		for(int i = 0; i < m; i++) {
			int start = i;
			int end = i;
			int count = words.length;
			HashMap<String, Integer> need = new HashMap<String, Integer>(hm);
			//注意此处的条件是 end + m <= n，而不是<，否则最后一个单词无法包含进来
			while(end + m <= n) {
				String str = s.substring(end, end + m);
				if(need.containsKey(str)) {
					if(need.get(str) > 0) {
						need.put(str, need.get(str) - 1);
						count--;
						end = end + m;
					}
					else {
						while(!str.equals(s.substring(start, start + m))) {
							need.put(s.substring(start, start + m), need.get(str) + 1);
							count++;
							start = start + m;
						}
						end = end + m;
						start = start + m;
					}
					//test("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}, Arrays.asList(6, 9, 12)); 无法通过
					//的原因是，找到重复的另一种可能性是，移动一格之后发现count仍然保持是0
					if(count == 0) {
						ret.add(start);
					}
				}
				else {
					need = new HashMap<String, Integer>(hm);
					count = words.length;
					end = end + m;
					start = end;
				}
			}
		}
		return ret;
	}
}