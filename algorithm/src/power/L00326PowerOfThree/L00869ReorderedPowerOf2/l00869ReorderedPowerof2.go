package main

import (
	"sort"
	"strconv"
)

func reorderedPowerOf2(n int) bool {
	origin2str := strconv.Itoa(n)

	charArray2str := []rune(origin2str)

	sort.Slice(charArray2str, func( i int, j int) bool {
		return charArray2str[i] < charArray2str[j]
	})

	for i := 0; i < 29; i++ {

		groupStr := strconv.Itoa( 1 << i)

		str2Array := []rune(groupStr)

		sort.Slice(str2Array, func( i int, j int) bool {
			return str2Array[i] < str2Array[j]
		})

		if( string(str2Array) == string(charArray2str)){
			return true;
		}
	}

	return false;


}