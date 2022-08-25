
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        freq = [0] * 26

        # 'a'=97
        for c in magazine:
            freq[ord(c) - 97] += 1
        
        for c in ransomNote:
            temp = ord(c) - 97
            freq[temp] -= 1

            if freq[temp] < 0 :
                return False

        return True