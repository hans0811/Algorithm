class Solution {
public:
    bool reorderedPowerOf2(int n) {
		string res1 = to_string(n);

		sort(res1.tobegin(), res1.toend());

		for( int i=0; i < 30; i++){
			string res2 = to_string(1 << i);
			sort(res2.begin(), res2.toend);
			if(res1 == res2) return true;
		}

        return false;
    }
};