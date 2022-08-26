fn reordered_power_of2(_n: i32) -> bool {
	let s: String = _n.to_string();
	let mut s2c = s.chars().collect::<Vec<_>>();
	s2c.sort_unstable();

	println!["{:?}", s2c];

	for x in 0..30{
		let _res: String = (1 << x).to_string();
		let mut res2c = _res.chars().collect::<Vec<_>>();
		res2c.sort_unstable();

		if s2c == res2c {
			return true;
		}
	}


	return false;

}

fn main() {

	reordered_power_of2(132654);

}