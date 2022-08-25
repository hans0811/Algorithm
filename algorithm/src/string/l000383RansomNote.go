package main

//import "fmt"

func canConstruct(ransomNote string, magazine string) bool {
	var dict [26]int

	for i:=0; i < len(magazine); i++{
		dict[ int(rune(magazine[i]) - rune('a')) ]++
	}

	for j:=0; j < len(ransomNote); j++{
		dict[ int(rune(ransomNote[j]) - rune('a')) ] --

		if( dict[ int(rune(ransomNote[j]) - rune('a')) ] < 0 ){
			return false;
		}
		
	}

	return false;
}